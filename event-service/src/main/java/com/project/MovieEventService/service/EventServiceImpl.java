package com.project.MovieEventService.service;

import com.project.MovieEventService.domain.Event;
//import com.project.MovieEventService.domain.Movie;
import com.project.MovieEventService.exception.EventAlreadyFoundException;
import com.project.MovieEventService.exception.EventNotFoundException;
import com.project.MovieEventService.repository.EventRepository;
//import com.project.MovieEventService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public List<Event> viewAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getAllEventOfUser(String email)throws EventNotFoundException {
        Event event=eventRepository.findByEmail(email);
        if(event== null){
            throw new EventNotFoundException();
        }
        return event;

    }

    @Override
    public Event getEventById(String eventId) throws EventNotFoundException {
        if(eventRepository.findByEventId(eventId)==null){
            throw new EventNotFoundException();
        }
        return eventRepository.findByEventId(eventId);
    }

    @Override
    public boolean deleteEvent(String eventId) throws EventNotFoundException {
        boolean result=false;
        if(eventRepository.findById(eventId).isEmpty()){
            throw new EventNotFoundException();
        }else{
            eventRepository.deleteById(eventId);
            return true;
        }
    }

    @Override
    public Event addEvent(Event event)throws EventAlreadyFoundException {
        if (eventRepository.findById(event.getEventId()).isPresent()){
            throw new EventAlreadyFoundException();
        }
        return eventRepository.save(event);
    }

    @Override
    public Event updateEventDetails(String eventId, Event event) {
        Optional<Event> optionalEvent=eventRepository.findById(eventId);
        if(optionalEvent.isEmpty()){
            return null;
        }
        Event existingEvent=optionalEvent.get();
        if (event.getEmail()!=null){
            existingEvent.setEmail(event.getEmail());
        }if (event.getEventName()!=null){
            existingEvent.setEventName(event.getEventName());
        }if (event.getOrganizerName()!=null){
            existingEvent.setOrganizerName(event.getOrganizerName());
        }if (event.getDate()!=null){
            existingEvent.setDate(event.getDate());
        }if (event.getTime()!=null){
            existingEvent.setTime(event.getTime());
        }if (event.getVenue()!=null){
            existingEvent.setVenue(event.getVenue());
        }if (event.getTotalSeat()!=-1){
            existingEvent.setTotalSeat(event.getTotalSeat());
        }
        return eventRepository.save(existingEvent);
    }

    @Override
    public List <Event> findByEventType(String eventType) {
        if(eventType.equals("movie")){
            return eventRepository.findAllByEventType("movie");
        }
        return eventRepository.findAllByEventType("event");
    }
}
