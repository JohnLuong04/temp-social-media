package com.social_backend.Persistence;

import com.social_backend.Model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

import static com.social_backend.Persistence.Database.execute_query;
import static com.social_backend.Persistence.Database.execute_update;
import static com.social_backend.Persistence.Database.db_location;

@Service
public class PostBack {

    public void insert_post(Post post) {
        String insert_post = "INSERT INTO Post VALUES (?, ?, ?)";
        execute_update(insert_post, post.getPostID(), post.getUsername(), post.getContent());
    }

    public void delete_post(String postID) {
        String delete_post = "DELETE FROM Post WHERE PostID = ?";
        execute_update(delete_post, postID);
    }

    public void edit_post(String postID, String content) {
        String edit_post = "UPDATE Post SET Content = ? WHERE PostID = ?";
        execute_update(edit_post, content, postID);
    }

    public Post get_post(String postID) {
        String get_post = "SELECT * FROM Post WHERE PostID = ?";
        //Post_Info Contains: (PostID, UserID and Content)
        ArrayList<Object> post_info = execute_query(get_post, postID).get(0);
        return new Post((Integer) post_info.get(0), post_info.get(1).toString(), post_info.get(2).toString(), post_info.get(3).toString());
    }

    public ArrayList<Post> get_some_post(String username, Integer lastseenPostID){
        ArrayList<ArrayList<Object>> list;
        
        if(lastseenPostID == null){
            String get_postlist_firstbatch = "SELECT * FROM Post WHERE UserID != ? ORDER BY PostID DESC LIMIT 10";
            list = execute_query(get_postlist_firstbatch, username);
        }else{
            String get_postlist_firstbatch = "SELECT * FROM Post WHERE UserID != ? AND PostID < ? ORDER BY PostID DESC LIMIT 10";
            list = execute_query(get_postlist_firstbatch, username, lastseenPostID);
        }

        ArrayList<Post> posts = new ArrayList<>();
        for(ArrayList<Object> row : list){
            int postID = (int) row.get(0);
            String userID = (String) row.get(1);
            String content = (String) row.get(2);
            Timestamp createdAt = (Timestamp) row.get(3); 
            Post post = new Post(postID, userID, content, createdAt.toString());
            posts.add(post);
        }

        return posts;
    }


//    public void main(String[] args){
//        PostBack postback = new PostBack();
//
//        postback.insert_post(new Post());
//
//    }
}
