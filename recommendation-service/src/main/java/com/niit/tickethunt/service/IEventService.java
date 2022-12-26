package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;

import java.util.List;
import java.util.Optional;

public interface IEventService {

    List<Event> getEvents();
    Event save(Event event);

    Optional<Event> findById(int id);

    Event update(Event event);
}
