package com.social_backend.Persistence;
import java.sql.*;
import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


//Author: Jason Ha
/* 
The Database class is where we first intialize the database instance, However it might be removed for future uses.
You only need to create database ONCE!! and is located under resources directory in src.
To query or insert you have to use connect with JDBC DriveManager to talk to the SQL file and then create Statement instance to insert and ResultSet to read.
I will leave things I already ran to give you understanding how I connect to database
*/
public class Database{

    private final static String db_location = "jdbc:sqlite:src/main/resources/social-media-database.db";

    public static void execute_update(String query, Object... param) throws SQLException {
        if(query.isEmpty()){
            System.out.println("Line 30 - Database: Nothing to execute?");
            return;
        }
        try(Connection conn = DriverManager.getConnection(db_location)){
            PreparedStatement statement = conn.prepareStatement(query);
            for(int i = 0; i < param.length; i++){
                statement.setString(i+1, (String) param[i]); //i+1 because we can't start with 0
            }
            statement.execute();

        }
    }

    //Run Once
    public static void main(String[] args) {
        String url = "jdbc:sqlite:Spring-boot/src/main/resources/social-media-database.db";
        String path = "Spring-boot/src/main/resources/social-media-database.db";
        File dbFile = new File(path);
        
        System.out.println("Absolute path: " + dbFile.getAbsolutePath());
        System.out.println("Exists? " + dbFile.exists());


        try(Connection conn = DriverManager.getConnection(url)) {
           
            Statement statement = conn.createStatement();
            // statement.execute("INSERT INTO users(username, password) VALUES ('WINTER', 'test')");

            conn.createStatement().execute("PRAGMA foreign_keys = ON");
            /*
            ResultSet rs = statement.executeQuery("SELECT * from users");
              while (rs.next()) {
                System.out.println(rs.getString("username") + " - " + rs.getString("password"));
            }
            */
        }catch(SQLException e){
            System.out.println("Database problem");
            e.printStackTrace();
        }
    }

}
