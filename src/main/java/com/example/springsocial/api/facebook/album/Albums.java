package com.example.springsocial.api.facebook.album;

import java.util.List;

/**
 * Created by Bernardo on 10/6/2019
 */
public class Albums {

    private List<Album> data;

    private Paging paging;

    public List<Album> getData() {
        return data;
    }

    public void setData(List<Album> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
