package com.balalin.servlet;

import com.kirilin.ConnectDB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/newUser")
public class UserCreateServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            connection = ConnectDB.Get(getServletContext()
                    .getRealPath("/WEB-INF/classes/db.properties"));
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/createNewUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String userID = "TEMP VALUE";
        //не совсем понимаю зачем нужно одновременно username и userlogin
        String userName = req.getParameter("username");
        String userLogin = req.getParameter("userlogin");
        String userEmail = req.getParameter("useremail");
        String userPassword = req.getParameter("userpassword");

        try {
            Statement statement = connection.createStatement();
            // лучше использовать какой нибодь фреймворк
            String sqlInsert = String.format("INSERT INTO users (user_id, user_name, user_login, user_email, user_password) VALUES('%s', '%s', '%s', '%s', '%s');", userID, userName, userLogin, userEmail, userPassword);
            System.out.println(sqlInsert);                  // just look
            statement.execute(sqlInsert);


        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

}
