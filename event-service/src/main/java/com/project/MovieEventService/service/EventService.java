package com.project.MovieEventService.service;

import com.project.MovieEventService.domain.Event;
import com.project.MovieEventService.domain.Movie;
import com.project.MovieEventService.exception.EventAlreadyFoundException;
import com.project.MovieEventService.exception.EventNotFoundException;

import java.util.List;

public interface EventService {
    public Movie addMovie(Movie movie);
    public List<Movie> viewAllMovie();
    public List<Event> viewAllEvents();
    public Event getAllEventOfUser(String email) throws EventNotFoundException;
    //public Event getAllEventOfUser(String email) ;
    public boolean deleteEvent(String eventId) throws EventNotFoundException;
    public Event addEvent(Event event)throws EventAlreadyFoundException;
    public Event updateEventDetails(String eventId,Event event);


}
