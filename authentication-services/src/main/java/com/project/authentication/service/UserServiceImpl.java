package com.project.authentication.service;

import com.project.authentication.model.User;
import com.project.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//used to mark the class as a service provider. So overall @Service annotation is used with classes that provide some business functionalities.
public class UserServiceImpl implements UserService {
    @Autowired
    //declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans.
    //marks a Constructor, Setter method, Properties and Config() method as to be autowired that is ‘injecting beans'(Objects) at runtime by Spring Dependency Injection mechanism
    private UserRepository userRepository;
    @Override
    public List<User> getUser(){
        return userRepository.findAll();
    }
    @Override
    public User addUser(User user) {
        user.setRole("USER_ROLE");
        return userRepository.save(user);
    }

    @Override
    public User authCheck(String email, String pass) {
        if(userRepository.findById(email).isPresent()){
            User user = userRepository.findById(email).get();
            if(user.getPassword().equals(pass)){
                return user;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}
