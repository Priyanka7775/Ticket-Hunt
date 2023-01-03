package com.niit.jdp.userservice.service;

import com.niit.jdp.userservice.domain.User;
import com.niit.jdp.userservice.exception.UserAlreadyExistsException;
import com.niit.jdp.userservice.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {

    User addUser(User user) throws UserAlreadyExistsException;

    List<User> getAllUser();

    User findByEmail(String email) throws UserNotFoundException;
     boolean deleteByEmail(String email, User user) throws UserNotFoundException;
     User updateUser(String email , User user) throws UserNotFoundException;



}
