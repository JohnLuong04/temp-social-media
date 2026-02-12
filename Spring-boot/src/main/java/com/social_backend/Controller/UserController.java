package com.social_backend.Controller;

import com.social_backend.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.io.IOException;
import java.sql.SQLException;

import com.social_backend.Persistence.Userback;

// Author: Jason Ha
/*
This UserController manages information from users database.

Things need to be done:
    Managing User Information
    - Inserting 
    - Removing 
    - Editing 
*/
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController{

    @Autowired
    private Userback userback;

    @PostMapping("/text")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Backend/Frontend Connection");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String,String> user) {
        System.out.println("HIT /user/login with body: " + user);
        if(userback.get_user(user.get("username"), user.get("password")) != null){
            return new ResponseEntity<>("User Exists", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Wrong User or Password", HttpStatus.UNAUTHORIZED);
        }
    }



}