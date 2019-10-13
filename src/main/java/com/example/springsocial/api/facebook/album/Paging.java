package com.example.springsocial.api.facebook.album;

/**
 * Created by Bernardo on 10/13/2019
 */
public class Paging {

    private Cursors cursors;

    private String next;

    private String previous;

    public Cursors getCursors() {
        return cursors;
    }

    public void setCursors(Cursors cursors) {
        this.cursors = cursors;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
