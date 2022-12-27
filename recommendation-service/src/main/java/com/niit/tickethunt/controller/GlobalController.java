package com.niit.tickethunt.controller;

import com.niit.tickethunt.domain.Event;
import com.niit.tickethunt.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v4/")
public class GlobalController {
    private EventService eventService;
    @Autowired
    public GlobalController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("events")
    public ResponseEntity<?> getAllEvents(){
        return new ResponseEntity<>(eventService.getEvents(), HttpStatus.OK);
    }

    @PostMapping("event/save")
    public ResponseEntity<?> saveEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventService.save(event), HttpStatus.CREATED);
    }

    @GetMapping("event/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
    }
}
