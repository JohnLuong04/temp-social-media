package com.social_backend.Model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String id;
    private String content;
    private final String timestamp;
    private Profile profile;

    public Post(String id, String content, Profile profile) {
        this.id = id;
        this.content = content;
        this.profile = profile;
        LocalDateTime currTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        String date = currTime.format(dateFormat);
        String time = currTime.format(timeFormat);
        this.timestamp = (date + " at " + time);
    }

    public String getId() {return this.id;}
    public String getContent() {return this.content;}
    public String getTimestamp() {return this.timestamp;}
    public Profile getProfile() {return this.profile;}
    public void setId(String id) {this.id = id;}
    public void setContent(String content) {this.content = content;}
    public void setProfile(Profile profile) {this.profile = profile;}
}
