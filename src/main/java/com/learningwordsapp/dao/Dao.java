package com.learningwordsapp.dao;

import java.util.List;

public interface Dao<T> {
    T find(Integer id);

    void save(T model);

    void change(T model);

    void delete(Integer id);

    List<T> findAll();
}
