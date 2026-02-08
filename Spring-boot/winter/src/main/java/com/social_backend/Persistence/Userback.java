package com.social_backend.Persistence;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.social_backend.Model.*;

/* Author: Jason Ha */

@Service
public class Userback{
    private final ObjectMapper objectMapper;
    private final String filepath = "src/main/resources/temp-database.json";

    public Userback(){
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public List<Account> readUsersData() throws IOException{
        File file = new File(filepath);
        if(!file.exists()){
            return new ArrayList<>();
        }
        Account[] userArray = objectMapper.readValue(file, Account[].class);
        return new ArrayList<>(Arrays.asList(userArray));
    }
    
    public void writeUsersData(List<Account> users) throws IOException {
        File file = new File(filepath);
        objectMapper.writeValue(file, users);
    }

    private void saveUsersData(Account user) throws IOException {
        List<Account> users = readUsersData();
        users.add(user);
        writeUsersData(users);
        System.out.println(readUsersData() + "check");
    }


    public void createUser(Account user) throws IOException{
         if(user == null || user.get_username() == null || user.get_password() == null){
            throw new IllegalArgumentException("Name cannot be empty or user doesn't exist");
        }
        saveUsersData(user);
    }

    public static void main(String[] args){
        System.out.println("Hi from Persistence/Userback");
    }


}