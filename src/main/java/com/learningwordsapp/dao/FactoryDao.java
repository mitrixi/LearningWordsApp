package com.learningwordsapp.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection Pool
 */

public class FactoryDao {

    private static volatile FactoryDao instance;

    private FactoryDao() {
    }

    public static FactoryDao getInstance() {
        if (instance == null) {
            synchronized (FactoryDao.class) {
                if (instance == null) {
                    instance = new FactoryDao();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        Context context;
        Connection conn = null;
        try {
            context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/dbpoolconnection");
            conn = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
