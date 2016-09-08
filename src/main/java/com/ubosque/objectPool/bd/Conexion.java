package com.ubosque.objectPool.bd;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion  {

    public Connection getConnection() {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5555/swii", "swii", "swii");
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return conn;
    }


}
