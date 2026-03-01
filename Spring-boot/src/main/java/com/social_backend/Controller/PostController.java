package com.social_backend.Controller;

import com.social_backend.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.social_backend.Persistence.PostBack;

import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {

    @Autowired
    private PostBack postback;

    @GetMapping("/{postID}")
    public ResponseEntity<Post> getPost(@PathVariable String postID) throws SQLException {
        Post post = postback.get_post(postID);
        if(post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) throws SQLException {
        postback.insert_post(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/{postID}")
    public ResponseEntity<Post> editPost(@PathVariable String postID, @RequestBody Map<String, String> postData) throws SQLException {
        Post post = postback.get_post(postID);
        if(post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postback.edit_post(postID, postData.get("content"));
        Post updatedPost = postback.get_post(postID);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{postID}")
    public ResponseEntity<Void> deletePost(@PathVariable String postID) throws SQLException {
        Post post = postback.get_post(postID);
        if(post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postback.delete_post(postID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
