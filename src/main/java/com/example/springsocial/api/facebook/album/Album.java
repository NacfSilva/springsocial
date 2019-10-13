package com.example.springsocial.api.facebook.album;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Bernardo on 10/6/2019
 */
public class Album {

    private String name;
    private Integer count;
    @JsonProperty("cover_photo")
    private CoverPhoto coverPhoto;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CoverPhoto getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(CoverPhoto coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
