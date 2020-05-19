//package com.learningwordsapp.controller;
//
//import com.learningwordsapp.dao.UserDao;
//import com.learningwordsapp.dao.dbqueries.UserDbQueryDao;
//import com.learningwordsapp.model.User;
//import com.learningwordsapp.util.UUIDUtil;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.util.concurrent.atomic.AtomicReference;
//
//@WebListener
//public class ContextListener implements ServletContextListener {
//
//    private AtomicReference<UserDao> dao;
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        dao = new AtomicReference<>(new UserDbQueryDao());
//
//        dao.get().add(new User(
//                UUIDUtil.createByteUUID(),
//                "Митя",
//                "mitrixi",
//                "balalindmitry@gmail.com",
//                "123",
//                User.ROLE.ADMIN));
//
//        final ServletContext servletContext = servletContextEvent.getServletContext();
//
//        servletContext.setAttribute("dao", dao);
//
//
//    }
//
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        dao = null;
//    }
//}
