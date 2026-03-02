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

    public static void execute_update(String query, Object... param){
        if(query.isEmpty()){
            throw new IllegalArgumentException("Line 30 - Database: Nothing to execute");
        }
        try(Connection conn = DriverManager.getConnection(db_location)){
            PreparedStatement statement = conn.prepareStatement(query);
            for(int i = 0; i < param.length; i++){
                statement.setString(i+1, (String) param[i]); //i+1 because we can't start with 0
            }
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<Object>> execute_query(String query, Object... param) {
        if(query.isEmpty()){
          throw new IllegalArgumentException("Line 36 - Database: Nothing to execute");
        }

        try(Connection conn = DriverManager.getConnection(db_location)){
            PreparedStatement statement = conn.prepareStatement(query);
            for(int i = 0; i < param.length; i++){
                statement.setString(i+1, (String) param[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            ArrayList<ArrayList<Object>> list = new ArrayList<>();
            while(resultSet.next()){
                ArrayList<Object> result = new ArrayList<>();
                for(int i = 0; i < resultSet.getMetaData().getColumnCount(); i++){
                    result.add(resultSet.getObject(i+1));
                }
                list.add(result);
            }
            resultSet.close();
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //Run Once
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(db_location)) {
           
            Statement statement = conn.createStatement();

            //Insert your SQL COMMAND HERE REMOVE \n

            String sql_command = "";

            conn.createStatement().execute(sql_command);
        }catch(SQLException e){
            System.out.println("Database problem");
            e.printStackTrace();
        }
    }

}
