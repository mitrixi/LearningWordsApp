package com.learningwordsapp.servlet;

import com.testData.ConnectDB;
import com.testData.TestUser;
import com.learningwordsapp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() {
        try {
            connection = ConnectDB.get(getServletContext().getRealPath("/WEB-INF/classes/db.properties"));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    protected  void sendPage(
            HttpServletRequest request,
            HttpServletResponse response,
            String error) throws ServletException, IOException {
        request.setAttribute("error", error);
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         sendPage(request, response, "");
    }

    public static void Login(HttpServletRequest request,
                             String name,
                             String login){
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("login", login);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loginUser = new User("", "","",request.getParameter("userpassword"));
        String nameEmail = request.getParameter("username");
        Pattern pattern = Pattern.compile("[^@]+@[^@]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nameEmail);
        if (matcher.find()){
            loginUser.setEmail(nameEmail);
        }
        else{
            loginUser.setLogin(nameEmail);
        }
        if (TestUser.isAdmin(loginUser)){
            Login(request, TestUser.Admin().getName(), TestUser.Admin().getLogin());
            response.sendRedirect("/home");
        }
        else{
            sendPage(request, response, String.format("Пользователь %s, %s, %s не найден",
                    loginUser.getLogin(),
                    loginUser.getEmail(),
                    loginUser.getPassword()
            ));
        }
    }

}