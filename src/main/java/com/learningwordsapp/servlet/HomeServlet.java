package com.learningwordsapp.servlet;

import com.kirilin.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //необходимо реализовать логику проверки залогинился ли пользователь на сайт
        //если нет то вывести страницу авторизации
        //request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        //если да то вывести гравную страницу
        request.getRequestDispatcher("/view/home.jsp").forward(request, response);
    }

}
