package com.learningwordsapp.servlet;

import com.learningwordsapp.util.ConnectDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/newUser")
public class UserCreateServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        try {
            connection = ConnectDB.getConnection(getServletContext().getRealPath("/WEB-INF/classes/db.properties"));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/createNewUser.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userID = "TEMP VALUE 2";
        String userName = req.getParameter("username");
        String userLogin = req.getParameter("userlogin");
        String userEmail = req.getParameter("useremail");
        String userPassword = req.getParameter("userpassword");

        //language=SQL
        final String SQL_INSERT_USER = "INSERT INTO learning_words_app.user (id, name, login, email, password) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);) {
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userLogin);
            preparedStatement.setString(4, userEmail);
            preparedStatement.setString(5, userPassword);
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }




        resp.sendRedirect("/home");
    }
}
