package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    public static Connection getCon() {

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tirupatitradersmanagementsystem", "your_username", "your_password");
            return con;
        } catch (Exception e) {
            // Handle any exceptions that might occur
            System.out.println(e);
            return null;
        }

    }
}
