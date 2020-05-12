package com.learningwordsapp.servlet;

import com.learningwordsapp.model.User;
import com.testData.ConnectDB;

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
            connection = ConnectDB.get(getServletContext().getRealPath("/WEB-INF/classes/db.properties"));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse response)
            throws ServletException, IOException {
        req.getRequestDispatcher("/view/createNewUser.jsp").forward(req, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse response)
            throws ServletException, IOException {
        String userID = "TEMP VALUE";
        String userName = req.getParameter("username");
        String userLogin = req.getParameter("userlogin");
        String userEmail = req.getParameter("useremail");
        String userPassword = req.getParameter("userpassword");
        String confirmationPassword = req.getParameter("confirmationpassword");
        User newUser = new User(userName, userLogin, userEmail, userPassword);

        String querry = "insert into site.user (id, name) values (?, ?);";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userLogin);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        response.sendRedirect("/home");
    }
}
