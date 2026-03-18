package com.social_backend.Model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    private int postID = -1;
    private final String username;
    private String content;
    private String createdAt;

    // Used when constructing a new post from scratch with user input
    @JsonCreator
    public Post(@JsonProperty("username") String username, @JsonProperty("content") String content) {
        this.username = username;
        this.content = content;
    }

    // Used when reconstructing a post from database information
    public Post(int postID, String username, String content, String createdAt) {
        this.postID = postID;
        this.username = username;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getPostID() {return this.postID;}
    public String getContent() {return this.content;}
    public String getUsername() {return this.username;}
    public void setContent(String content) {this.content = content;}
}
