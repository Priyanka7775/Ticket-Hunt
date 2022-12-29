package com.preproject.authentication.service;

import com.preproject.authentication.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUser();
    public User addUser(User user);
    public User authCheck(String email, String pass);
}
