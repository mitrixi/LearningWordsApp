package com.learningwordsapp.dao;

import java.util.List;

public interface CrudDao<T> {
    T get(Integer id);

    void create(T model);

    void update(T model);

    void delete(Integer id);
}
