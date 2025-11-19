package com.vcube.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    // Update these constants with your DB credentials
    private static final String URL = "jdbc:mysql://localhost:3306/online_bookstore?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "rootpassword";

    static {
        try {
            // For MySQL 8+: com.mysql.cj.jdbc.Driver is still fine; driver jar must be added to project in Eclipse
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
