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

@Service
public class Userback{
    private final ObjectMapper objectMapper;
    private final String filepath = "src/main/resources/temp-database.json";

    public Userback(){
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public List<Account> readUsersData() throws IOException{

    }
    
    public boolean writeUsersData(List<Account> users) throws IOException {

    }

    public boolean createUser(Account user) throws IOException{
        
    }




}