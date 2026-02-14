package com.social_backend.Controller;


import com.social_backend.Persistence.Profileback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfileController {

    @Autowired
    private Profileback profileback;

//    @PostMapping
//    public ResponseEntity<String> get_profile(@RequestBody String username){
//        if()
//
//        return null;
//    }
}
