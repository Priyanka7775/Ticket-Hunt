package com.project.bookingservice.service;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.exceptions.EventAlreadyExistException;

public interface BookingService {

    Booking addBooking(Booking booking) throws EventAlreadyExistException;

}
