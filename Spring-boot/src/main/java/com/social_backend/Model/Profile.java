package com.social_backend.Model;

public class Profile {

    private String username;
    private String displayName;
    private String bio;
    // figure out how to store profile images
    
    public Profile(String username, String displayName, String bio){
        this.displayName = displayName;
        this.bio = bio;
        this.username = username;
    }

    public String getUsername() {return this.username;}
    public String getDisplayName() {return displayName;}
    public String getBio() {return this.bio;}
    public void setUsername(String username) {this.username = username;}
    public void setBio(String bio) {this.bio = bio;}
    public void setDisplayName(String displayName) {this.displayName = displayName;}
}
