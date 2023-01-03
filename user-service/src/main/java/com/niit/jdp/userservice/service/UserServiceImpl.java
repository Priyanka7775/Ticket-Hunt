/*
 * Author Name: Mohini
 * Date: 12/27/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.userservice.service;

import com.niit.jdp.userservice.domain.User;
import com.niit.jdp.userservice.exception.UserAlreadyExistsException;
import com.niit.jdp.userservice.exception.UserNotFoundException;
import com.niit.jdp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User findByEmail(String email) throws UserNotFoundException {
        User user =userRepository.findByEmail(email);
        if(user== null){
            throw new UserNotFoundException();
        }
        return user;
}

    @Override
    public boolean deleteByEmail(String email,User user) throws UserNotFoundException {
        boolean result=false;
        if(userRepository.findById(user.getEmail()).isEmpty()){
            throw new UserNotFoundException();
        }else{
            userRepository.deleteById(email);
            return true;
        }
    }

    @Override
    public User updateUser(String email, User user) throws UserNotFoundException {
        Optional<User> optionalUser=userRepository.findById(email);
        if(optionalUser.isEmpty()){
            return null;
        }
        User existingUser=optionalUser.get();
        if (user.getEmail()!=null){
            existingUser.setEmail(user.getEmail());
        }if (user.getName()!=null){
            existingUser.setName(user.getName());
        }if (user.getPassword()!=null){
            existingUser.setPassword(user.getPassword());
        }if (user.getCity()!=null){
            existingUser.setCity(user.getCity());
        }if (user.getRole()!=null){
            existingUser.setRole(user.getRole());
        }if (user.getInterest()!=null){
            existingUser.setInterest(user.getInterest());
        }if (user.getPhone()!=0){
            existingUser.setPhone(user.getPhone());
        }
        return userRepository.save(existingUser);
    }
}
