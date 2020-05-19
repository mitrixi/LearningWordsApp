package com.learningwordsapp.controller.servlets;

import com.learningwordsapp.dao.dbqueries.UserDbQueryDao;
import com.learningwordsapp.model.User;
import com.learningwordsapp.util.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/newUser")
public class CreateUserServlet extends HttpServlet {

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

        Map<String, String> messages = new HashMap<>();


        if (userName == null || userName.trim().isEmpty()) {
            messages.put("name", "Введите ваше имя");
        }
        if (userLogin == null || userLogin.trim().isEmpty()) {
            messages.put("login", "Введите логин");
        }
        if (userEmail == null || userEmail.trim().isEmpty()) {
            messages.put("name", "Введите электронную почту");
        }
        if (userPassword == null || userPassword.trim().isEmpty())
            messages.put("password", "Введите пароль");


        if (messages.isEmpty()) {

            User user = new User(userID, userName, userLogin, userEmail, userPassword, User.ROLE.USER);

            if (new UserDbQueryDao().checkSuchUserAlreadyExists(user)) {

                messages.put("user", "Такой пользователь уже существует");
                req.getRequestDispatcher("/view/createNewUser.jsp").forward(req, resp);


            } else if (new UserDbQueryDao().add(user)) {

                HttpSession session = req.getSession();
                session.setAttribute("email", userEmail);
                session.setAttribute("login", userLogin);

                resp.sendRedirect("/home");
            }
        }
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/view/createNewUser.jsp").forward(req, resp);
    }
}
