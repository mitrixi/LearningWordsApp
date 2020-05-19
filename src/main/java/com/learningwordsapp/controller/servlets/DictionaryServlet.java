package com.learningwordsapp.controller.servlets;

import com.learningwordsapp.model.Word;
import com.learningwordsapp.util.ConnectDB;
import com.testData.TestWords;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/dictionary")
public class DictionaryServlet extends HttpServlet{
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageIndex;
        try{
            pageIndex = Integer.parseInt(request.getParameter("page"));
        }
        catch (Exception e){
            pageIndex = 0;
        }
        ArrayList<Word> words = TestWords.GetDictionaryPage(pageIndex);
        request.setAttribute("words", words);
        ArrayList<Integer> pageCount = new ArrayList<Integer>();
        for(int i = 0; i < TestWords.countPage(); i++){
            pageCount.add(i);
        }
        request.setAttribute("pageCount", pageCount);
        request.getRequestDispatcher("/view/dictionary.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer =
                new PrintWriter(new OutputStreamWriter(
                        response.getOutputStream(),
                        StandardCharsets.UTF_8),
                        true);
        try {
            writer.println(TestWords.GetRandom().toJson());
        } finally {
            writer.close();
        }
        response.setStatus(200);
    }
}
