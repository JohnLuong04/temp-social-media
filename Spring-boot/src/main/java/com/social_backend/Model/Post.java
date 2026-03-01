package com.social_backend.Model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Post {
    private final String postID;
    private final String username;
    private String content;

    // Used when constructing a new post from scratch with user input
    @JsonCreator
    public Post(@JsonProperty("username") String username, @JsonProperty("content") String content) {
        this.postID = UUID.randomUUID().toString();
        this.username = username;
        this.content = content;
    }

    // Used when reconstructing a post from database information
    public Post(String postID, String username, String content) {
        this.postID = postID;
        this.username = username;
        this.content = content;
    }

    public String getPostID() {return this.postID;}
    public String getContent() {return this.content;}
    public String getUsername() {return this.username;}
    public void setContent(String content) {this.content = content;}
}
