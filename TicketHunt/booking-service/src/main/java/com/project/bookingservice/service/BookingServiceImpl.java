package com.project.bookingservice.service;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.domain.Seats;
import com.project.bookingservice.exceptions.EventAlreadyExistException;
import com.project.bookingservice.exceptions.EventNotFoundException;
import com.project.bookingservice.exceptions.SeatAlreadyBookedException;
import com.project.bookingservice.exceptions.UserNotFoundException;
import com.project.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    private ResponseEntity responseEntity;
    private BookingRepository bookingRepository;

    @Autowired
    private BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }




    @Override
    public Booking addBooking(Booking booking) throws EventAlreadyExistException {
        if (bookingRepository.findById(booking.getEventId()).isPresent()) {
            throw new EventAlreadyExistException();
        }

        Booking booking1 = bookingRepository.save(booking);

        return booking1;
    }


    @Override
    public Booking bookSeats(String eventId, String email, Seats seats) throws EventNotFoundException, UserNotFoundException, SeatAlreadyBookedException {

        if (bookingRepository.findById(eventId).isEmpty()) {
            throw new EventNotFoundException();
        }
        System.out.println(seats);
        Booking booking = bookingRepository.findByEventId(eventId);
        if (booking.getSeatList() == null) {
            booking.setSeatList(Arrays.asList(seats));
        } else {
            List<Seats> seatsList = booking.getSeatList();
            if (bookingRepository.findByEventIdAndSeatListSeatNumber(eventId, seats.getSeatNumber()) != null) {
                System.out.println(bookingRepository.findByEventIdAndSeatListSeatNumber(eventId, seats.getSeatNumber()));
                throw new SeatAlreadyBookedException();
            }
            seatsList.add(seats);
            booking.setSeatList(seatsList);
        }

        return bookingRepository.save(booking);
    }
}
