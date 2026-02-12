package com.social_backend.Model;

import java.util.Objects;
import com.social_backend.Model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Account {

    private String username;
    private String password;

    @JsonIgnore
    private Profile profile;
    
    public Account(@JsonProperty("username") String get_username, @JsonProperty("password") String get_password){
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
