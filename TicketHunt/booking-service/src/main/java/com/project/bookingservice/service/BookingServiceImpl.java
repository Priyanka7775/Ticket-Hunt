package com.project.bookingservice.service;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.domain.Seats;
import com.project.bookingservice.exceptions.*;
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


    @Override
    public Booking cancelTickets(String eventId, String email, String seatNo) throws EventNotFoundException, SeatNotFoundException, UserNotFoundException {

        boolean flag = false;
        if (bookingRepository.findById(eventId).isEmpty()) {
            throw new EventNotFoundException();
        }


        Booking booking = bookingRepository.findByEventId(eventId);
        List<Seats> seatsList = booking.getSeatList();
        flag = seatsList.removeIf(x -> x.getSeatNumber().equals(seatNo));
        if (!flag) {
            throw new SeatNotFoundException();
        }

        booking.setSeatList(seatsList);
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }


    @Override
    public Booking findByEmail(String email) {
        return bookingRepository.findByEmail(email);
    }


    @Override
    public double totalCost(String eventId, String email) {

        double cost = 0;
        Booking booking = bookingRepository.findByEventIdAndEmail(eventId,  email);
        List<Seats> seatsList = booking.getSeatList();

        for (Seats var : seatsList) {

            cost = cost + var.getPrice();

        }

        System.out.println(cost);
        return cost;
    }
}
