package com.project.authentication.service;

import com.project.authentication.domain.User;

import java.util.List;

public interface UserService {
    public List<User> getUser();

    public User addUser(User user);

    public User authCheck(String email, String pass);


}
