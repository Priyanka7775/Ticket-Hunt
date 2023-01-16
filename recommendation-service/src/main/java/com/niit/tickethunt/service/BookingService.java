package com.niit.tickethunt.service;

import com.niit.tickethunt.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IGlobalService<Booking> {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(int id) {
        return bookingRepository.findById((long) id);
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    public String addRelation(int bookingId, int userId){
        if(findById(bookingId).isEmpty()){
            return "Invalid booking id";
        }
        bookingRepository.addBooking(bookingId, userId);
        return "Added";
    }

    public Booking findByEmail(String email){
        return bookingRepository.findByEmail(email);
    }
}

