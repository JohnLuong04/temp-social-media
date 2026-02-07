package com.social_backend.Model;

public class Account {

    
    public String username; //Also a Unique ID
    public String password;

    private Profile profile;
    
    public Account(String get_username, String get_password){
        username = get_username;
        password = get_password;

    }

    public boolean set_profile(Profile get_profile){
        return (profile = get_profile) != null;
    }

}
