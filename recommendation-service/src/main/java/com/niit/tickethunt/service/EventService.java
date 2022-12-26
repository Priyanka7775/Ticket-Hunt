package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;
import com.niit.tickethunt.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EventService implements IEventService{

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public Event findById(int Id) {
        return null;
    }

    @Override
    public Event update(Event event) {
        return null;
    }
}
