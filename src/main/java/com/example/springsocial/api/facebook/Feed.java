package com.example.springsocial.api.facebook;

import java.util.List;


public class Feed {

	private List<Post> data;


	public Feed() {
	}

	public Feed(List<Post> data) {
		this.data = data;
	}

	public List<Post> getData() {
		return data;
	}

	public void setData(List<Post> data) {
		this.data = data;
	}
}
