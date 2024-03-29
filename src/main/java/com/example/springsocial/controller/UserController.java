package com.example.springsocial.controller;

import com.example.springsocial.api.facebook.Facebook;
import com.example.springsocial.api.facebook.Profile;
import com.example.springsocial.api.facebook.album.Album;
import com.example.springsocial.api.facebook.album.AlbumResponse;
import com.example.springsocial.exception.ResourceNotFoundException;
import com.example.springsocial.model.User;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.CurrentUser;
import com.example.springsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private Facebook facebookApi;


    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/user/me/photos")
    @PreAuthorize("hasRole('USER')")
    public AlbumResponse getCurrentUserPhotos(@RequestParam(name="more", required = false) String paging,
                                              @RequestParam(name="limit", required = false) Integer limit,
                                              @RequestParam(name="after", required = false) String after) {

        if(paging == null){
            return facebookApi.getAlbums();
        } else {
            AlbumResponse response= new AlbumResponse();
            response.setAlbums(facebookApi.getAlbums(paging,limit,after));
            return response;
        }


    }




}
