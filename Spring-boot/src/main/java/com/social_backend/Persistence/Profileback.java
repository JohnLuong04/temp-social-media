package com.social_backend.Persistence;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Arrays;

//Author: Jason Ha

@Service
public class Profileback {

    private static String db_location = "jdbc:sqlite:spring-boot/src/main/resources/social-media-database.db";

    /*
        All usernames in UserData are unique
        Each profile is linked by a user from the username

     */
    // public boolean post_profile(String username, String nickname) throws SQLException {
    //     try(Connection con = DriverManager.getConnection(db_location)){
    //         Statement stmt = con.createStatement();
    //         stmt.execute("INSERT INTO profile(username,)")

    //     }
    // }


    /*
        Get_Profile gets the profile from the database from username. Where username
        is a unique name from UserData table. 
        @Param
        Username: the Unique Username 
        @Return
        Profile [Unique Username, Nickname]
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
        System.out.println(Arrays.toString(test.get_profile("WINTER")));
        System.out.println(Arrays.toString(test.get_profile("winter")));

    }
}
