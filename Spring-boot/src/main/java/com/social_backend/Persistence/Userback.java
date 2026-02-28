package com.social_backend.Persistence;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.social_backend.Model.*;

/* Author: Jason Ha */

/* Communicate with Database to handle UserBack */

@Service
public class Userback{

    /**
    *   Gets the user from userData if it exist within the userData table. This function should only be used on the backend no where near
    *   the frontend in the future. I'll probably make does_exist boolean function later.
    *   @Param (username: The unique username, password: password)
    *   @Return: If exist [Username, password] else [null]
     *
     *  SELECT gets its own connection command
    */
    public String[] get_user(String username, String password){
        try(Connection conn = DriverManager.getConnection(db_location)){
            
            String sql_command = "SELECT username, password from users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql_command);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            //Working with hash password later
            ResultSet rs = preparedStatement.executeQuery();
            String result_username = rs.getString("username");
            String result_password = rs.getString("password");

            if((result_username == null) || (result_password == null)){
                return null;
            }else{
                return new String[] {result_username,result_password};
            }
        } catch(SQLException e){
            System.out.println("Database not exist");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        Userback userback = new Userback();
        System.out.println(Arrays.toString(
            userback.get_user("WINTER", "test")));
    }
}