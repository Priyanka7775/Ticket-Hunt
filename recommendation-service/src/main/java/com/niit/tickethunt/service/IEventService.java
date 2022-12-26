package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;

public interface IEventService {
    Event save(Event event);

    Event findById(int Id);

    Event update(Event event);
}
