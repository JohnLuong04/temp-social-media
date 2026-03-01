package com.social_backend.Persistence;

import com.social_backend.Model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;

import static com.social_backend.Persistence.Database.execute_update;

@Service
public class PostBack {

    public void insert_post(Post post) throws SQLException {
        String insert_post = "INSERT INTO Post VALUES (?, ?, ?)";
        execute_update(insert_post, post.getPostID(), post.getUsername(), post.getContent());
    }

    public void delete_post(String postID) throws SQLException {
        String delete_post = "DELETE FROM Post WHERE PostID = ?";
        execute_update(delete_post, postID);
    }

    public void edit_post(String postID, String content) throws SQLException {
        String edit_post = "UPDATE Post SET Content = ? WHERE PostID = ?";
        execute_update(edit_post, content, postID);
    }

    public Post get_post(String postID) throws SQLException {
        String get_post = "SELECT * FROM Post WHERE PostID = ?";
        // Need function to get post data from database and return as resultset
        // ResultSet rs =
        String username = rs.getString("username");
        String content = rs.getString("content");
        return new Post(postID, username, content);
    }
}
