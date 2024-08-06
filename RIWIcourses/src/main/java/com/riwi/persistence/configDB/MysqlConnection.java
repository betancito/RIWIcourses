package com.riwi.persistence.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    //Set connection
    private static Connection connection = null;
    //set method to open connection with db
    public static Connection openConnection(){
        //Set constants for db connection
        String URL = "jdbc:mysql://127.0.0.1:3306/RIWIcourses";
        String user = "root";
        String password = "Rlwl2023.";
        try {
            connection = DriverManager.getConnection(URL,user,password);
            System.out.println("Connected!");
        }catch (SQLException error){
            throw new RuntimeException(error.getMessage());
        }
        return connection;
    }
    //Set method to disconnect from the db
    public static void closeConnection(){
        if (connection!=null){
            try {
                connection.close();
                System.out.println("Disconnected!");
            } catch (SQLException error){
                throw new RuntimeException(error.getMessage());
            }
        }
    }
}
