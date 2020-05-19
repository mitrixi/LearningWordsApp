package com.learningwordsapp.controller.filters;

import com.learningwordsapp.dao.UserDao;
import com.learningwordsapp.dao.dbqueries.UserDbQueryDao;
import com.learningwordsapp.model.User;
import com.learningwordsapp.util.UserUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        String loginEmail = req.getParameter("useremaillogin");     //считываем или логин или пароль
        String password = req.getParameter("userpassword");

         /*на данный момент считан
                                    логин или емэил
                                                      и пароль*/

        @SuppressWarnings("unchecked") final AtomicReference<UserDbQueryDao> dao = (AtomicReference<UserDbQueryDao>) req.getServletContext().getAttribute("dao");

        final HttpSession session = req.getSession();

        if ((nonNull(session.getAttribute("login")) ||
                nonNull(session.getAttribute("email"))) &&
                nonNull(session.getAttribute("password"))) {

            User.ROLE role = (User.ROLE) session.getAttribute("role");

            moveToMenu(req, res, role);

        } else if (dao.get().userIsExist(loginEmail, password)) {       //если пользователь с таким логином и паролем есть в БД, то:

            final User.ROLE role = dao.get().getRoleByLoginPassword(loginEmail, password);  //берем его роль

            req.getSession().setAttribute("password", password);    //и сетаем в реквест
            req.getSession().setAttribute("login", loginEmail);
//            req.getSession().setAttribute("email", );
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, role);

        } else {
            moveToMenu(req, res, User.ROLE.UNKNOWN);
        }
    }

    private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final User.ROLE role) throws ServletException, IOException {


        if (role.equals(User.ROLE.ADMIN)) {
            req.getRequestDispatcher("/WEB-INF/view/adminMenu.jsp").forward(req, res);
        } else if (role.equals(User.ROLE.USER)) {
            req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
