package com.social_backend.Model;
public class Post {
    private String id;
    private String content;
    private Profile profile;

    public Post(String id, String content, Profile profile) {
        this.id = id;
        this.content = content;
        this.profile = profile;
    }

    public String getId() {return this.id;}
    public String getContent() {return this.content;}
    public Profile getProfile() {return this.profile;}
    public void setId(String id) {this.id = id;}
    public void setContent(String content) {this.content = content;}
    public void setProfile(Profile profile) {this.profile = profile;}
}
