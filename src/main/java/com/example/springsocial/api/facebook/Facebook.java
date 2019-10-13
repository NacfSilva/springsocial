package com.example.springsocial.api.facebook;

import com.example.springsocial.api.ApiBinding;
import com.example.springsocial.api.facebook.album.Album;
import com.example.springsocial.api.facebook.album.AlbumResponse;
import com.example.springsocial.api.facebook.album.Albums;

import java.util.List;

public class Facebook extends ApiBinding {

	private static final String GRAPH_API_BASE_URL = "https://graph.facebook.com/v4.0";
	
	public Facebook(String accessToken) {
		super(accessToken);
	}
	
	public Profile getProfile() {
		return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me", Profile.class);
	}
	
	public List<Post> getFeed() {
		return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me/feed", Feed.class).getData();
	}

	public List<Album> getAlbums() {
		String queryFilter = "{name,count,cover_photo{picture}}";
		return restTemplate.getForObject(GRAPH_API_BASE_URL + "/me?fields=albums.limit(5){queryFilter}", AlbumResponse.class,queryFilter).getAlbums().getData();
	}

	public String getToken() {
		return super.accessToken;
	}
}
