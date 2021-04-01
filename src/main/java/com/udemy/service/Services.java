package com.udemy.service;

import java.util.List;

public interface Services<T> {

    List<T> getServicesList (String sort);
    void saveFromServices (T t);
    void deleteFromServices (int id);
    T getFromServices (int id);
}
