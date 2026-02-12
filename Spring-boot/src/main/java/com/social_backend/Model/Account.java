package com.social_backend.Model;
import java.time.LocalDate;

public class Account {
    private String username; //Also a Unique ID
    private String password;
    private final String dateCreated;
    
    public Account(String username, String password, Profile profile){
        this.username = username;
        this.password = password;
        LocalDate now = LocalDate.now();
        this.dateCreated = now.toString();
    }

    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}
    public String getDateCreated() {return this.dateCreated;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
}
