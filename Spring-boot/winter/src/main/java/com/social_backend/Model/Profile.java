package com.social_backend.Model;

public class Profile {

    private Account User;
    public String nickname;
    public String description;
    
    public Profile(String get_nickname, String get_description){
        nickname = get_nickname;
        description = get_description;
    }

    public boolean set_user(Account get_user){
        return (User = get_user) != null;
    }
}
