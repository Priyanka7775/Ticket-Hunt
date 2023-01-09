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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

           responseEntity=new ResponseEntity<>( eventService.deleteEvent(eventId),HttpStatus.OK);
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

    @GetMapping("getEvent1/{eventId}")
    public ResponseEntity<?>getEventByEventId(@PathVariable String eventId)throws EventNotFoundException{
        ResponseEntity responseEntity=null;
        try{
            responseEntity=new ResponseEntity<>(eventService.getEventById(eventId),HttpStatus.OK);

        }catch (EventNotFoundException eventNotFoundException){
            throw new EventNotFoundException();
        }catch (Exception exception){
            responseEntity=new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping("push")
    public ResponseEntity<Void> saveEvent(@RequestParam("eventId") String eventId,
                                          @RequestParam("email") String email,
                                          @RequestParam("eventName") String eventName,
                                          @RequestParam("organizerName") String organizerName,
                                          @RequestParam("date")String date,
                                          @RequestParam("time")String time,
                                          @RequestParam("venue")String venue,
                                          @RequestParam("image") MultipartFile image,
                                          @RequestParam("totalSeat") int totalSeat,
                                          @RequestParam("eventType") String eventType) {
        try {
            Event event = new Event();
            event.setEventId(eventId);
            event.setEmail(email);
            event.setEventName(eventName);
            event.setOrganizerName(organizerName);
            event.setDate(date);
            event.setTime(time);
            event.setVenue(venue);
            event.setImage(image.getBytes());
            event.setTotalSeat(totalSeat);
            event.setEventType(eventType);
            eventService.saveImage(event);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            // Handle exception
        }
        return null;
    }

//    @PostMapping("image")
//    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
//        String uploadImage = eventService.uploadImage(file);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(uploadImage);
//    }
}
