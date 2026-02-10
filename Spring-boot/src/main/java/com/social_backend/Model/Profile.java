package com.social_backend.Model;

import java.util.Objects;

public class Profile {

    private Account User;
    public String nickname;
    public String description;
    
    public Profile(String get_nickname, String get_description){
        nickname = Objects.requireNonNull(get_nickname, "nickname cannot be null");
        description = Objects.requireNonNull(get_description, "description cannot be null");
    }

    public boolean set_user(Account get_user){
        return (User = get_user) != null;
    }

    public String get_nickname(){
        return nickname;
    }

    public String get_description(){
        return description;
    }
}
