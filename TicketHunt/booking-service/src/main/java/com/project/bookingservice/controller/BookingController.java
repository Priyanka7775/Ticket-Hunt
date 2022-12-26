package com.project.bookingservice.controller;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.domain.Seats;
import com.project.bookingservice.exceptions.EventAlreadyExistException;
import com.project.bookingservice.exceptions.SeatAlreadyBookedException;
import com.project.bookingservice.repository.BookingRepository;
import com.project.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    private BookingRepository bookingRepository;

    private ResponseEntity responseEntity;

    @PostMapping("/addBooking")
    public ResponseEntity<?> insertBooking(@RequestBody Booking booking) throws EventAlreadyExistException {

        try {
            booking.setSeatList(new ArrayList<>());
            return new ResponseEntity<>(bookingService.addBooking(booking), HttpStatus.OK);
        } catch (EventAlreadyExistException e) {
            throw new EventAlreadyExistException();
        }
    }

    @PostMapping("/book/{eventId}/{email}")
    public  ResponseEntity<?> bookSeats(@PathVariable String eventId, @PathVariable String email, @RequestBody Seats seats) throws SeatAlreadyBookedException {

        try {
            return new ResponseEntity<>(bookingService.bookSeats(eventId, email, seats), HttpStatus.OK);

        } catch (Exception e) {
            throw new SeatAlreadyBookedException();
        }

    }


}
