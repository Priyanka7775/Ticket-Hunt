/*
 * Author Name: Mohini
 * Date: 12/27/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.userservice.service;

import com.niit.jdp.userservice.domain.User;
import com.niit.jdp.userservice.exception.UserAlreadyExistsException;
import com.niit.jdp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
    if(userRepository.findById(user.getEmail()).isPresent()){
        throw new UserAlreadyExistsException();
    }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
