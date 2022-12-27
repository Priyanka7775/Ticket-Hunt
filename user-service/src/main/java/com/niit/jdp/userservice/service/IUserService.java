package com.niit.jdp.userservice.service;

import com.niit.jdp.userservice.domain.User;

import java.util.List;

public interface IUserService {

    User addBooking(User user) ;

    List<User> getAllUser();

    User findByEmail(String email);



}
