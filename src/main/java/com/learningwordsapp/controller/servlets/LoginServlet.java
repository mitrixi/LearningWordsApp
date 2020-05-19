package com.learningwordsapp.controller.servlets;

import com.learningwordsapp.dao.FactoryDao;
import com.learningwordsapp.model.User;
import com.learningwordsapp.util.QueryFactory;
import com.learningwordsapp.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/login")
public class AuthServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        connection = FactoryDao.getInstance().getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmailLogin = req.getParameter("useremaillogin");         //считываем или логин или пароль
        String userPassword = req.getParameter("userpassword");
        String userLogin = "";
        String userEmail = "";

        try (Statement statement = connection.createStatement()) {
            if (UserUtil.isEmail(userEmailLogin)) {
                userEmail = userEmailLogin;
                ResultSet resultSet = statement.executeQuery(QueryFactory.getLoginByEmail(userEmail));
                if (resultSet.next())
                    userLogin = resultSet.getString("login");
            } else {
                userLogin = userEmailLogin;
                ResultSet resultSet = statement.executeQuery(QueryFactory.getEmailByLogin(userLogin));
                if (resultSet.next())
                    userEmail = resultSet.getString("email");
                resultSet.close();
            }

            if (userEmail.isEmpty() || userLogin.isEmpty()) {
                req.setAttribute("error", "Пользователь не найден");
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            } else if (statement.executeQuery(QueryFactory.checkByPassword(userPassword, userLogin)).next()) {
                HttpSession session = req.getSession();
                session.setAttribute("email", userEmail);
                session.setAttribute("login", userLogin);
            } else {
                req.setAttribute("error", "Введен неверный пароль");
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            }

        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }

        resp.sendRedirect("/home");
    }
}