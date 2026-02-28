package com.social_backend.Persistence;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Arrays;
;import static com.social_backend.Persistence.Database.execute_update;

//Author: Jason Ha

@Service
public class Profileback {

    /**
     * Deleting a profile 
     * @param username user_id where we deleting
     */
    public void delete_profile(String username) throws SQLException {
        String delete_profile_command = "DELETE FROM PROFILE WHERE user_id = ?";
        execute_update(delete_profile_command, username);
    }

    /**
     * Post a profile data into tha profile the table
     * @param username Unique Username
     * @param nickname Nickname can be anything
     */
    public void post_profile(String username, String nickname) throws SQLException {
        String post_profile_command = "INSERT INTO profile(user_id, nickname) VALUES(?,?)";
        execute_update(post_profile_command, nickname);
    }

    /**
     * Edit the profile nickname should never edit the username
     * @param username unique username
     * @param new_nickname user new nickname // Cannot be Null 
     */
    public void edit_profile(String username, String new_nickname) throws SQLException {
        String edit_profile_command = "UPDATE Profile SET nickname = ? WHERE user_id = ?";
        execute_update(edit_profile_command, new_nickname);
    }


    /**
     *  Get_Profile gets the profile from the database from username. Where username
     *  is a unique name from UserData table. 
     *  @Param Username: the Unique Username 
     *  @Return Profile [Unique Username, Nickname]
     *
     *  SELECT gets its own connection command
    */

    public String[] get_profile(String username) throws SQLException {
       return null;
    }
     

    /*
    public static void main(String[] args) throws SQLException {

        Profileback test = new Profileback();
        test.post_profile("winter", "test2");
        System.out.println(Arrays.toString(test.get_profile("WINTER")));
        System.out.println(Arrays.toString(test.get_profile("winter")));
        test.delete_profile("winter");
        System.out.println(Arrays.toString(test.get_profile("winter")));

    }
    *
     */
}

     
