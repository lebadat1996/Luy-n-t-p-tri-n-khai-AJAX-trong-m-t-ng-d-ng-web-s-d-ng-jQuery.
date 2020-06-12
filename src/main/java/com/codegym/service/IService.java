package com.codegym.service;

import com.codegym.model.Phones;

public interface IService<T> {
    Iterable<T> findAll();

    T getPhoneById(Long id);

    T save(T model);

    T delete(Long id);
}
