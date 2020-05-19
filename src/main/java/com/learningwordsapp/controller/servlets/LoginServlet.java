package com.learningwordsapp.controller.servlets;

import com.learningwordsapp.dao.dbqueries.UserDbQueryDao;
import com.learningwordsapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmailLogin = req.getParameter("useremaillogin");         //считываем или логин или пароль
        String userPassword = req.getParameter("userpassword");

        Map<String, String> messages = new HashMap<>();

        if (userEmailLogin == null || userEmailLogin.trim().isEmpty()) {
            messages.put("loginemail", "Введите логин или электронную почту");
        }

        if (userPassword == null || userPassword.trim().isEmpty()) {
            messages.put("password", "Введите пароль");
        }

        if (messages.isEmpty()) {
            if (new UserDbQueryDao().userIsExist(userEmailLogin, userPassword)) {

                User user = new UserDbQueryDao().getUserByLoginOrEmailAndPassword(userEmailLogin, userPassword);

                req.getSession().setAttribute("userlogin", user.getLogin());
                req.getSession().setAttribute("useremail", user.getEmail());

                resp.sendRedirect("/home");
                return;

            } else {
                messages.put("user", "Пользователь не найден");
            }
        }
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);

    }
}