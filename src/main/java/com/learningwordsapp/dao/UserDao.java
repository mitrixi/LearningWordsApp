package com.learningwordsapp.dao;

import com.learningwordsapp.model.User;

public interface UserDao extends AbstractModelDao<User> {

    User getUserById(byte[] id);

    User getUserByLoginPassword(final String login, final String password);

    boolean add(final User user);

    User.ROLE getRoleByLoginPassword(final String login, final String password);

    boolean userIsExist(String login, String password);

    public User getUserByLoginOrEmailAndPassword(String loginEmail, String password);

//    public boolean checkUserPasswordByLoginOrEmail(String loginEmail, String password);
}
