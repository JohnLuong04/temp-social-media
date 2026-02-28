package com.social_backend.Persistence;

import com.social_backend.Model.Post;

import java.sql.*;
import java.util.ArrayList;
import static com.social_backend.Persistence.Database.execute_update;

public class PostBack {

    public void insert_post(Post post, String who) throws SQLException {
        String insert_post = "INSERT INTO Post (UserID, Content) VALUES (?, ?)";

        execute_update(insert_post, who, post.getContent());
    }

    public void delete_post(int id) throws SQLException {
        String delete_post = "DELETE FROM Post WHERE PostID = ?";

        execute_update(delete_post, id);
    }

    public void edit_post(Post post, int id) throws SQLException {
        String edit_post = "UPDATE Post SET Content = ? WHERE PostID = ?";
        execute_update(edit_post, post.getContent(), id);

    }
}
