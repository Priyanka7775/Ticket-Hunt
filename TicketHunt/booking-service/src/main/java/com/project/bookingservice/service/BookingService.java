package com.project.bookingservice.service;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.domain.Seats;
import com.project.bookingservice.exceptions.EventAlreadyExistException;
import com.project.bookingservice.exceptions.EventNotFoundException;
import com.project.bookingservice.exceptions.SeatAlreadyBookedException;
import com.project.bookingservice.exceptions.UserNotFoundException;

public interface BookingService {

    Booking addBooking(Booking booking) throws EventAlreadyExistException;

    Booking bookSeats(String eventId, String email, Seats seats) throws EventNotFoundException, UserNotFoundException, SeatAlreadyBookedException;




}
