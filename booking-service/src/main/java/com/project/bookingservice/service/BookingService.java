package com.project.bookingservice.service;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.domain.Seats;
import com.project.bookingservice.exceptions.*;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    Booking addBooking(Booking booking) throws EventAlreadyExistException;

    Booking bookSeats(String eventId, String email, Seats seats) throws EventNotFoundException, UserNotFoundException, SeatAlreadyBookedException;

    Booking cancelTickets(String eventId, String email, String seats) throws EventNotFoundException, SeatNotFoundException, UserNotFoundException;

    List<Booking> getAllBookings();

    List<Booking> findByEmail(String email);

    List<Booking> findByEventId(String evenId);

}
