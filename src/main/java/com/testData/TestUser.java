package com.testData;

import com.learningwordsapp.model.User;

public class TestUser {
    public static User Admin(){
        return  new User(
                "admin",
                "Alex",
                "admin@yandex.ru",
                "123456");
    }
    public  static  boolean isAdmin(User user){
        return  (user.getLogin().equals(Admin().getLogin()) || user.getEmail().equals(Admin().getEmail())) &&
                user.getPassword().equals(Admin().getPassword());
    }
}
