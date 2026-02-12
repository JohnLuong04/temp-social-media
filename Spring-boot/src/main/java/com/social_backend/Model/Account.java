package com.social_backend.Model;

import java.util.Objects;
import com.social_backend.Model.*;

public class Account {

    
    public static String username; //Also a Unique ID
    public static String password;

    private com.social_backend.Model.Profile profile;
    
    public Account(String get_username, String get_password){
        username = Objects.requireNonNull(get_username, "Username cannot be null");
        password = Objects.requireNonNull(get_password, "Password cannot be null");
    }

    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}
    public String getDateCreated() {return this.dateCreated;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
}
