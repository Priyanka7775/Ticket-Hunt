package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;

import java.util.List;
import java.util.Optional;

public interface IGlobalService<T> {

    List<T> getAll();
    T save(T t);

    Optional<T> findById(int id);

    T update(T t);
}
