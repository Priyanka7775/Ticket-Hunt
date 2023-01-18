package com.project.authentication.service;

import com.project.authentication.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUser();

    User addUser(User user);

<<<<<<< HEAD
    public User authCheck(String email, String pass);


=======
    User authCheck(String email, String pass);

    String findRoleUsingEmail(String email);
>>>>>>> f7f5fbac61702cd8d05441885990c25b291b471b
}
