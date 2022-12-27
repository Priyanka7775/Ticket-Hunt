package com.project.MovieEventService.controller;

import com.project.MovieEventService.domain.Event;
//import com.project.MovieEventService.domain.Movie;
import com.project.MovieEventService.exception.EventAlreadyFoundException;
import com.project.MovieEventService.exception.EventNotFoundException;
import com.project.MovieEventService.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("eventdata/")
@CrossOrigin("*")
public class EventController {
    private EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

//    @PostMapping("addMovie")
//    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
//        return new ResponseEntity<>(eventService.addMovie(movie), HttpStatus.CREATED);
//    }
//    @GetMapping("movie")
//    public ResponseEntity<?> getAllMovie(){
//        return new ResponseEntity<>(eventService.viewAllMovie(),HttpStatus.OK);
//    }

    @PostMapping("addEvent")
    public ResponseEntity<?> addEvent(@RequestBody Event event) throws EventAlreadyFoundException {
      ResponseEntity responseEntity=null;
       try{
           responseEntity=new ResponseEntity<>(eventService.addEvent(event), HttpStatus.CREATED);
       }catch (EventAlreadyFoundException eventAlreadyFoundException){
           throw new EventAlreadyFoundException();
       }catch (Exception exception){
           responseEntity= new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
        return responseEntity ;

    }
    @GetMapping("event")
    public ResponseEntity<?> getAllEvent(){
        return new ResponseEntity<>(eventService.viewAllEvents(),HttpStatus.OK);
    }

    @DeleteMapping("delete/{eventId}")
    public ResponseEntity<?>deleteEvent(@PathVariable String eventId) throws EventNotFoundException {
       ResponseEntity responseEntity=null;
       try{
           eventService.deleteEvent(eventId);
           responseEntity=new ResponseEntity<>("Succesfully Deleted",HttpStatus.OK);
       }catch (EventNotFoundException eventNotFoundException){
           throw new EventNotFoundException();
       }catch (Exception exception){
           responseEntity= new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
        return responseEntity ;
    }

    @GetMapping("event/{email}")
    public ResponseEntity<?> getAllEventByEmail(@PathVariable String email)throws EventNotFoundException{
       ResponseEntity responseEntity=null;
       try{
           responseEntity=new ResponseEntity<>(eventService.getAllEventOfUser(email),HttpStatus.OK);
       }catch (EventNotFoundException eventNotFoundException){
           throw new EventNotFoundException();
       }catch (Exception exception){
           responseEntity= new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
        return responseEntity ;

    }

    @PutMapping("updateEvent/{eventId}")
    public ResponseEntity<?>updateTrack(@RequestBody Event event, @PathVariable String eventId){
        return new ResponseEntity<>(eventService.updateEventDetails(eventId,event),HttpStatus.OK);
    }

    @GetMapping("getEvent/{eventType}")
    public List<Event> getAllByEventType(@PathVariable String eventType){
        return eventService.findByEventType(eventType);
    }
}
