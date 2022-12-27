package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;

import java.util.List;
import java.util.Optional;

public interface IGlobalService<T> {

    List<Event> getAll();
    Event save(T t);

    Optional<Event> findById(int id);

    Event update(Event event);
}
