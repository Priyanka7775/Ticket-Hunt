package com.project.bookingservice.service;

import com.project.bookingservice.domain.Booking;
import com.project.bookingservice.domain.Seats;
import com.project.bookingservice.exceptions.*;
import com.project.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private ResponseEntity responseEntity;
    private BookingRepository bookingRepository;
    private JavaMailSender javaMailSender;
    @Autowired
    private BookingServiceImpl(BookingRepository bookingRepository, JavaMailSender javaMailSender) {
        this.bookingRepository = bookingRepository;
        this.javaMailSender = javaMailSender;

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

        if (bookingRepository.findByEventIdAndEmail(eventId, email) == null) {
            throw new EventNotFoundException();
        }
        System.out.println(seats);
        Booking booking = bookingRepository.findByEventIdAndEmail(eventId, email);
        if(!booking.getEmail().equals(email)){
            throw new UserNotFoundException();
        }
        if (booking.getSeatList() == null) {
            booking.setSeatList(Arrays.asList(seats));
        } else {
            List<Seats> seatsList = booking.getSeatList();
            seatsList.add(seats);
            booking.setSeatList(seatsList);
        }

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Booking Details");
        msg.setText("You have successfully booked your seat!!!!.");
        javaMailSender.send(msg);


        return bookingRepository.save(booking);
    }


    @Override
    public Booking cancelTickets(String eventId, String email, String seatNo) throws EventNotFoundException, SeatNotFoundException, UserNotFoundException {

        boolean flag = false;
        if ( bookingRepository.findByEventIdAndEmail(eventId, email) == null) {
            throw new EventNotFoundException();
        }

        Booking booking = bookingRepository.findByEventIdAndEmail(eventId, email);
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
    public List<Booking> findByEmail(String email) {
        return bookingRepository.findByEmail(email);
    }

    @Override
    public  List<Booking> findByEventId(String evenId) {
        return bookingRepository.findByEventId(evenId);
    }
}
