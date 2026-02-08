package com.social_backend.Model;

import java.util.Objects;

public class Account {

    
    public static String username; //Also a Unique ID
    public static String password;

    private Profile profile;
    
    public Account(String get_username, String get_password){
        username = Objects.requireNonNull(get_username, "Username cannot be null");
        password = Objects.requireNonNull(get_password, "Password cannot be null");
    }

    public String get_username(){
        return username;
    }

    public String get_password(){
        return password;
    }

    public boolean set_profile(Profile get_profile){
        return (profile = get_profile) != null;
    }

}
