package com.social_backend.Controller;

import com.social_backend.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import com.social_backend.Persistence.Userback;


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

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account user) {
        try{


            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch(IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



}