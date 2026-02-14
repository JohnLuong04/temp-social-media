package com.social_backend.Persistence;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Arrays;

//Author: Jason Ha

@Service
public class Profileback {

    private static String db_location = "jdbc:sqlite:spring-boot/src/main/resources/social-media-database.db";

    /**
     * Deleting a profile 
     * @param username user_id where we deleting
     */
    public void delete_profile(String username){
        try(Connection con = DriverManager.getConnection(db_location)){
            String sql_remove = "DELETE FROM PROFILE WHERE user_id = ?";
            PreparedStatement statement = con.prepareStatement(sql_remove);
            statement.setString(1, username);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Post a profile data into tha profile the table
     * @param username Unique Username
     * @param nickname Nickname can be anything
     */
    public void post_profile(String username, String nickname) {
        try(Connection con = DriverManager.getConnection(db_location)){
            String sql_post = "INSERT INTO profile(user_id, nickname) VALUES(?,?)";
            PreparedStatement statement = con.prepareStatement(sql_post);
            statement.setString(1, username);
            statement.setString(2, nickname);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Edit the profile nickname should never edit the username
     * @param username unique username
     * @param new_nickname user new nickname // Cannot be Null 
     */
    public void edit_profile(String username, String new_nickname){
        try(Connection con = DriverManager.getConnection(db_location)){
            String sql = "UPDATE Profile SET nickname = ? WHERE user_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, new_nickname);
            statement.setString(2, username);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    /**
     *  Get_Profile gets the profile from the database from username. Where username
     *  is a unique name from UserData table. 
     *  @Param Username: the Unique Username 
     *  @Return Profile [Unique Username, Nickname]
    */
    public String[] get_profile(String username){
        try(Connection con = DriverManager.getConnection(db_location)){
            String sql_get = "SELECT * from profile where user_id = ?";
            PreparedStatement statement = con.prepareStatement(sql_get);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return new String[] {
                    rs.getString("user_id"),
                    rs.getString("nickname")
                };
            }else{
                return null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){

        Profileback test = new Profileback();
        test.post_profile("winter", "test2");
        System.out.println(Arrays.toString(test.get_profile("WINTER")));
        System.out.println(Arrays.toString(test.get_profile("winter")));
        test.delete_profile("winter");
        System.out.println(Arrays.toString(test.get_profile("winter")));

    }
}
