package com.niit.tickethunt.controller;

import com.niit.tickethunt.domain.Booking;
import com.niit.tickethunt.domain.Event;
import com.niit.tickethunt.domain.User;
import com.niit.tickethunt.exception.UserNotFoundException;
import com.niit.tickethunt.service.BookingService;
import com.niit.tickethunt.service.EventService;
import com.niit.tickethunt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v4/")
public class GlobalController {
    private final EventService eventService;
    private final UserService userService;

    private final BookingService bookingService;

    @Autowired
    public GlobalController(EventService eventService, UserService userService, BookingService bookingService) {
        this.eventService = eventService;
        this.userService = userService;
        this.bookingService = bookingService;
    }

    /* Event CRUD related APIs */
    @GetMapping("events")
    public ResponseEntity<?> getAllEvents() {
        return new ResponseEntity<>(eventService.getAll(), HttpStatus.OK);
    }

    @PostMapping("event/save")
    public ResponseEntity<?> saveEvent(@RequestBody Event event) {
        try {
            return new ResponseEntity<>(eventService.save(event), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage());
            return new ResponseEntity<>("failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("event/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK);
    }


    /*  User CURD related APIs */

    @GetMapping("users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("user/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    /* Booking CRUD related APIs */

    @PostMapping("booking/{user}")
    public ResponseEntity<?> saveBooking(@RequestBody Booking booking, @PathVariable String user) throws UserNotFoundException {
        int userId = 1;
        if (Integer.parseInt(String.valueOf(user).split("")[0]) == 0) {
            userId = 0;
        }
        int bookingId = Integer.parseInt(String.valueOf(user).split("")[1]);
        bookingService.addRelation(bookingId, userId);
        return new ResponseEntity<>(bookingService.save(booking), HttpStatus.CREATED);
    }

    @GetMapping("bookings")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }
}
