package com.social_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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



}