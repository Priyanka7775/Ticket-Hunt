package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;
import com.niit.tickethunt.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EventService implements IEventService{

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(int id) {
        return eventRepository.findById((long) id);
    }

    @Override
    public Event update(Event event) {
        return null;
    }
}
