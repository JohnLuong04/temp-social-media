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

import static com.social_backend.Persistence.Database.execute_query;

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
    public ArrayList<ArrayList<Object>> get_user(String username, String password){
        String get_user_sql = "SELECT username, password from users WHERE username = ? AND password = ?";
        return execute_query(get_user_sql, username, password);
    }

    public boolean check_user(String username, String password){
        String get_user_sql = "SELECT username, password from users WHERE username = ? AND password = ?";
        return !(execute_query(get_user_sql,username,password).isEmpty());
    }

    public static void main(String[] args) {
        Userback userback = new Userback();
        System.out.println(userback.get_user("WINTER","test"));
    }
}