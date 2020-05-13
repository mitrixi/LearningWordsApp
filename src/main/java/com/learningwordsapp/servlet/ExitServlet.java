package com.learningwordsapp.servlet;

import com.testData.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setAttribute("name", null);
        session.setAttribute("login", null);
        response.sendRedirect("/home");
    }

}