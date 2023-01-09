package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Booking;
import com.niit.tickethunt.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
}
