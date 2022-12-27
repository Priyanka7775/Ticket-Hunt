package com.niit.tickethunt.service;

import com.niit.tickethunt.domain.Event;
import com.niit.tickethunt.domain.User;
import com.niit.tickethunt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService implements IGlobalService<User>{
    private UserRepository userRepository;

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
        return userRepository.findById((long)id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
