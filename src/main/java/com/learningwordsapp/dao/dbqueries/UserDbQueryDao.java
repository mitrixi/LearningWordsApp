package com.learningwordsapp.dao.dbqueries;

import com.learningwordsapp.dao.ExceptionDao;
import com.learningwordsapp.dao.FactoryDao;
import com.learningwordsapp.dao.UserDao;
import com.learningwordsapp.model.User;
import com.learningwordsapp.util.UUIDUtil;
import com.learningwordsapp.util.UserUtil;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDbQueryDao implements UserDao {

    FactoryDao factoryDao = FactoryDao.getInstance();

    @Override
    public List<User> getAll() throws ExceptionDao {
        return null;
    }

    @Override
    public User get(byte[] id) throws ExceptionDao {
        return null;
    }

    @Override
    public void create(User model) throws ExceptionDao {

    }

    @Override
    public void update(User model) throws ExceptionDao {

    }

    @Override
    public void delete(Integer id) throws ExceptionDao {

    }

    @Override
    public User getUserById(byte[] id) {
        return null;
    }

    @Override
    public User getUserByLoginPassword(String login, String password) {
        return null;
    }

    @Override
    public boolean add(User user) {
        //language=SQL
        String query = "INSERT INTO learning_words_app.user (id, name, login, email, password, role) VALUES (?, ?, ?, ?, ?, ?);";

        ResultSet resultSet = null;

        try (Connection connection = factoryDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setBytes(1, UUIDUtil.createByteUUID());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setInt(6, 2);
            statement.execute();

            resultSet = statement.executeQuery();


            return resultSet.next();

        } catch (SQLException throwables) {
            throw new IllegalStateException();
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User.ROLE getRoleByLoginPassword(String login, String password) {
        return null;
    }


    @Override
    public boolean userIsExist(String loginEmail, String password) {
        //language=SQL
        String query = "SELECT login, email, password FROM learning_words_app.user WHERE (login = ? OR email = ?) AND password = ?;";

        ResultSet resultSet = null;

        try (Connection connection = factoryDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, loginEmail);
            statement.setString(2, loginEmail);
            statement.setString(3, password);

            resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException throwables) {
            throw new IllegalStateException();
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public User getUserByLoginOrEmailAndPassword(String loginEmail, String password) {
        //language=SQL
        String query = "SELECT * FROM learning_words_app.user WHERE (login = ? OR email = ?) AND password = ?;";

        ResultSet resultSet = null;
        User user = null;

        try (Connection connection = factoryDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, loginEmail);
            statement.setString(2, loginEmail);
            statement.setString(3, password);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                byte[] id = resultSet.getBytes("id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String pswrd = resultSet.getString("password");
                User.ROLE role = User.ROLE.valueOf(resultSet.getString("role"));

                user = new User(id, name, login, email, pswrd, role);

            }
        } catch (SQLException throwables) {
            throw new IllegalStateException();
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }


    public boolean checkSuchUserAlreadyExists(User user) {

        //language=SQL
        String query = "SELECT login, email FROM learning_words_app.user WHERE login = ? AND email = ?;";

        ResultSet resultSet = null;

        try (Connection connection = factoryDao.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());

            resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException throwables) {
            throw new IllegalStateException();
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
