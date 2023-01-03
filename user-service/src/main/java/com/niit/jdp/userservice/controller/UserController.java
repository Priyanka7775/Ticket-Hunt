/*
 * Author Name: Mohini
 * Date: 12/27/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.userservice.controller;

import com.niit.jdp.userservice.domain.User;
import com.niit.jdp.userservice.exception.UserAlreadyExistsException;
import com.niit.jdp.userservice.exception.UserNotFoundException;
import com.niit.jdp.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userdata/")
@CrossOrigin("*")
public class UserController {
    private IUserService iUserService;
@Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }
    @PostMapping("/adduser")
    public ResponseEntity<?> add(@RequestBody User user) throws UserAlreadyExistsException {
            ResponseEntity responseEntity = null;
            try{
                responseEntity = new ResponseEntity<>(iUserService.addUser(user), HttpStatus.CREATED);
            }catch(UserAlreadyExistsException e){
                throw new UserAlreadyExistsException();
            }catch(Exception e){
                responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }
    @GetMapping("/alluser")
    public ResponseEntity<?> fetchAllUser(){
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity(iUserService.getAllUser(), HttpStatus.OK);
        }catch (Exception exception){
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<?> fetchUserByEmail(@PathVariable String email) throws UserNotFoundException {
            ResponseEntity responseEntity = null;
            try{
                responseEntity = new ResponseEntity(iUserService.findByEmail(email),HttpStatus.NOT_FOUND);
            }catch(UserNotFoundException exception){
                throw new UserNotFoundException();}
            catch(Exception e){
                responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }
        @DeleteMapping("/delete/{email}")
        public ResponseEntity<?> deleteUserByEmail(@PathVariable String email, User user) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
            try{
        responseEntity = new ResponseEntity(iUserService.deleteByEmail(email, user),HttpStatus.NOT_FOUND);
    }catch(UserNotFoundException exception){
        throw new UserNotFoundException();}
            catch(Exception e){
        responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
            return responseEntity;
}

    }


