package com.social_backend.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;


//Author: Jason Ha
public class Database{

    public String Database_Name;
    public Connection connected;

    public Database(String database_name){
        Database_Name = database_name;
        String url = "jdbc:sqlite:" + database_name + ".db";
        
        try(Connection conn = DriverManager.getConnection(url)){
            connected = conn;

            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT)");
            stmt.execute("CREATE TABLE profile (user_id TEXT PRIMARY KEY, nickname TEXT NOT NULL, FOREIGN KEY (user_id) REFERENCES users(user_ID) ON DELETE CASCADE)");

            stmt.execute(
            "CREATE TABLE follows (" +
            "follower_user_id INTEGER NOT NULL, " +
            "followed_user_id INTEGER NOT NULL, " +
            "PRIMARY KEY (follower_user_id, followed_user_id), " +
            "FOREIGN KEY (follower_user_id) REFERENCES users(user_id) ON DELETE CASCADE, " +
            "FOREIGN KEY (followed_user_id) REFERENCES users(user_id) ON DELETE CASCADE" +
            ")"
        );
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //Run Once
    public static void main(String[] args) {
        String url = "jdbc:sqlite:Spring-boot/winter/src/main/resources/social-media-database.db";
        try(Connection conn = DriverManager.getConnection(url)) {
            if(conn != null){
                System.out.println("Database connected");
            }else{
                return;
            }
            Statement statement = conn.createStatement();
            // statement.execute("INSERT INTO users(username, password) VALUES ('WINTER', 'test')");

            ResultSet rs = statement.executeQuery("SELECT * from users");
              while (rs.next()) {
                System.out.println(rs.getString("username") + " - " + rs.getString("password"));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
