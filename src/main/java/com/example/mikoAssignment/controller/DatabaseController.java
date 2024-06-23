package com.example.mikoAssignment.controller;

import com.example.mikoAssignment.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController

public class DatabaseController {
    @Autowired
    DatabaseService databaseService;

     @Autowired
     StringRedisTemplate redisTemplate;
     @PostMapping("/execute")
     public String executeSqlString(@RequestBody String sqlString) throws IOException {
        sqlString = sqlString.trim();
       try {
           if (sqlString.startsWith("CREATE TABLE")) {
               databaseService.handleCreateTable(sqlString);
           } else if (sqlString.startsWith("INSERT INTO")) {
               databaseService.handleInsertTable(sqlString);
           }
           redisTemplate.opsForValue().increment("SUCCESS");


       }
        catch (Exception ex){
            redisTemplate.opsForValue().increment("FAILURE");
        }
        return "operation successful";
    }
}
