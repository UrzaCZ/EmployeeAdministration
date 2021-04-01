package com.udemy.dao;

import java.util.List;

public interface DAO<T> {

    List<T> getDataFromDB(String sort);
    void save (T t);
    T getPerson(int id);
    void delete(int id);
}
