package com.learningwordsapp.dao;

import java.util.List;

public interface AbstractModelDao<T> {

    List<T> getAll() throws ExceptionDao;

    T get(byte[] id) throws ExceptionDao;

    void create(T model) throws ExceptionDao;

    void update(T model) throws ExceptionDao;

    void delete(Integer id) throws ExceptionDao;
}
