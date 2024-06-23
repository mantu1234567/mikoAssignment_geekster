package com.example.mikoAssignment.service;

import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class DatabaseService {

    private static final String METADATA_FILE = "metadata.txt";
    private static final String DATA_FILE = "data.txt";

    // CREATE TABLE USERS (id INTEGER,name String)
    public void handleCreateTable(String sqlString) throws IOException {
        StringBuilder createQueryMetaData = new StringBuilder();
        // Converting sqlString to Array
        String[] sqlArr = sqlString.split(" ");

        // extract table name
        String tableName = sqlArr[2];

        // extract columns
        String columnPart = sqlString.substring(sqlString.indexOf('(')+1,sqlString.indexOf(')'));

        // columnPart = id INTEGER,name String
        String[] columns = columnPart.split(",");

        // columns[0] = id INTEGER
        for (String column:columns){
            createQueryMetaData.append(column.trim()).append("\n");
        }

        // save meta_data data in file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(METADATA_FILE))) {
            writer.write(createQueryMetaData.toString());
        }

    }

    // INSERT INTO USERS VALUES (1,"Mantu")
    // INSERT INTO USERS (name,id) VALUES ("Mantu",1)
    public void handleInsertTable(String sqlString) throws IOException{
        StringBuilder insertQueryMetaData = new StringBuilder();
        // Converting sqlString to Array
        String[] sqlArr = sqlString.split(" ");

        // extract table name
        String tableName = sqlArr[2];


        // extract values
        String valuePart = sqlString.substring(sqlString.indexOf("VALUES")+6).trim();
        valuePart = valuePart.substring(1,valuePart.length()-1);
          String[] value = valuePart.split(",");
        // 1,"Mantu"
         for (String val:value){
             insertQueryMetaData.append(val.trim()).append(" ");
         }
         insertQueryMetaData.append("\n");


         // save data in  file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
            writer.write(insertQueryMetaData.toString());
        }


    }
}
