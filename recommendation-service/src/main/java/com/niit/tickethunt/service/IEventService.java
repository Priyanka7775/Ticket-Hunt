package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;

import java.util.Optional;

public interface IEventService {
    Event save(Event event);

    Optional<Event> findById(int id);

    Event update(Event event);
}
