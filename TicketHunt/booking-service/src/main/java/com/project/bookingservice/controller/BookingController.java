package com.project.bookingservice.controller;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.exceptions.EventAlreadyExistException;
import com.project.bookingservice.repository.BookingRepository;
import com.project.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
