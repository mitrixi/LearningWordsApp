package com.balalin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@WebServlet("/")
public class UserCreateServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.userpassword");
            String driverClassName = properties.getProperty("db.driverClassName");

            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("Servlet is running");
            req.getRequestDispatcher("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = "TEMP VALUE";
        String userName = req.getParameter("username");
        String userLogin = req.getParameter("userlogin");
        String userEmail = req.getParameter("useremail");
        String userPassword = req.getParameter("userpassword");

        try {
            Statement statement = connection.createStatement();
            String sqlInsert = String.format("INSERT INTO users (user_id, user_name, user_login, user_email, user_password) VALUES('%s', '%s', '%s', '%s', '%s');", userID, userName, userLogin, userEmail, userPassword);
            System.out.println(sqlInsert);                  // just look
            statement.execute(sqlInsert);


        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }
}
