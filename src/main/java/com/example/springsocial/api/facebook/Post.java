package com.example.springsocial.api.facebook;




public class Post {

	private String id;
	private String story;
	private String message;

	public Post() {
	}

	public Post(String id, String story, String message) {
		this.id = id;
		this.story = story;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
