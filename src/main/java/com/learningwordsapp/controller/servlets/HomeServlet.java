package com.learningwordsapp.controller.servlets;

import com.learningwordsapp.util.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //необходимо реализовать логику проверки залогинился ли пользователь на сайт
        //если нет то вывести страницу авторизации
//        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        //если да то вывести гравную страницу
        request.getRequestDispatcher("/view/home.jsp").forward(request, response);
    }

}
