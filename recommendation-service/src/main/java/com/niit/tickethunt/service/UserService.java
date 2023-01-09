package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Booking;
import com.niit.tickethunt.domain.User;
import com.niit.tickethunt.exception.UserNotFoundException;
import com.niit.tickethunt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IGlobalService<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById((long) id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    public User addBooking(Booking booking, int eventId, int userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById((long) userId);
        List<Booking> bookings = new ArrayList<>();
        new User();
        User userUpdate;
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else {
            bookings.add(booking);
            user.get().setBooking(bookings);
            userUpdate = user.get();
            userRepository.addBooking(booking, eventId, userId);
        }
        return userRepository.save(userUpdate);
    }
}
