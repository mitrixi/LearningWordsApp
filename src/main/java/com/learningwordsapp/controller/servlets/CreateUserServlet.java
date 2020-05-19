package com.learningwordsapp.controller.servlets;

import com.learningwordsapp.model.User;
import com.learningwordsapp.util.ConnectDB;
import com.learningwordsapp.util.QueryFactory;
import com.learningwordsapp.util.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/newUser")
public class UserCreateServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        try {
            connection = ConnectDB.getDbConnection(getServletContext().getRealPath("/WEB-INF/classes/db.properties"));
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

        byte[] userID = UUIDUtil.createByteUUID();
        String userName = req.getParameter("username");
        String userLogin = req.getParameter("userlogin");
        String userEmail = req.getParameter("useremail");
        String userPassword = req.getParameter("userpassword");

        User user = new User(userID, userName, userLogin, userEmail, userPassword);

        try (Statement statement = connection.createStatement();
             PreparedStatement prepStatement = connection.prepareStatement(QueryFactory.getInsertUser())) {

            if (statement.executeQuery(QueryFactory.checkByLogin(userLogin)).next() ||
                    statement.executeQuery(QueryFactory.checkByEmail(userEmail)).next()) {
                req.setAttribute("error", "Пользователь с такими данными уже существует");
                req.getRequestDispatcher("/view/createNewUser.jsp").forward(req, resp);
            } else {
                prepStatement.setBytes(1, userID);
                prepStatement.setString(2, userName);
                prepStatement.setString(3, userLogin);
                prepStatement.setString(4, userEmail);
                prepStatement.setString(5, userPassword);
                prepStatement.execute();

                HttpSession session = req.getSession();
                session.setAttribute("email", userEmail);
                session.setAttribute("login", userLogin);

                resp.sendRedirect("/home");
            }

        } catch (SQLException | ServletException | IOException throwables) {
            throw new IllegalStateException(throwables);
        }
    }
}
