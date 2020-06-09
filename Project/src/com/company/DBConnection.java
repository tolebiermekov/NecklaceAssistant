package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection conn;

    private DBConnection(){}

    public static Connection getConnection()
    {
        try
        {
            if(conn == null)
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stone","mydatabase_admin","admin");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return conn;
    }
}
