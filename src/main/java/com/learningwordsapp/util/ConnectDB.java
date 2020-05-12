package com.learningwordsapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDB {
    public static Connection getConnection(String realPath) throws ClassNotFoundException, SQLException, IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(realPath));

        String dbUrl = properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.userpassword");
        String driverClassName = properties.getProperty("db.driverClassName");

        Class.forName(driverClassName);

        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }
}
