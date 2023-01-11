package com.project.MovieEventService.service;

import com.project.MovieEventService.domain.Event;
//import com.project.MovieEventService.domain.Movie;
import com.project.MovieEventService.exception.EventAlreadyFoundException;
import com.project.MovieEventService.exception.EventNotFoundException;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface EventService {

    Event registerEvent(Event event, MultipartFile file) throws EventAlreadyFoundException, IOException;

    List<Event> viewAllEvents();

    List<Event> getAllEventOfUser(String email) throws EventNotFoundException;

    Event getEventById(String eventId) throws EventNotFoundException;

    boolean deleteEvent(String eventId) throws EventNotFoundException;

    Event addEvent(Event event) throws EventAlreadyFoundException;

    Event updateEventDetails(String eventId, Event event);

    List<Event> findByEventType(String eventType);

    void saveImage(Event event);


//    String uploadImage(MultipartFile file)throws IOException;
}
