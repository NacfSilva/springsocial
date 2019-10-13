package com.example.springsocial.config;

import com.example.springsocial.api.facebook.Facebook;
import com.example.springsocial.security.CurrentUser;
import com.example.springsocial.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SocialConfig {

    @Bean
    @Lazy
    @RequestScope
    public Facebook facebookTokenTest(OAuth2AuthorizedClientService authorizedClientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication;
        UserPrincipal userPrincipal = (UserPrincipal) authToken.getPrincipal();
        String accessToken = null;
        OAuth2AuthorizedClient authorizedClient =
                authorizedClientService.loadAuthorizedClient("facebook", userPrincipal.getEmail());
        if (authorizedClient != null) {
            accessToken = authorizedClient.getAccessToken().getTokenValue();
        }

        return new Facebook(accessToken);
    }

}
