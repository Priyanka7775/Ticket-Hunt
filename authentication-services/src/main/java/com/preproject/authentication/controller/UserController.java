package com.preproject.authentication.controller;
//In Spring MVC, controller methods are the final destination point that a web request can reach.
// After being invoked, the controller method starts to process the web request by interacting with the service layer to complete the work that needs to be done.
// Usually, the service layer executes some business operations on domain objects and calls the persistence layer to update the domain objects.
// After the processing has been completed by the service layer object, the controller is responsible for updating and building up the model object and chooses a view for the user to see next as a response.

import com.preproject.authentication.model.User;
import com.preproject.authentication.service.UserSecurityTokenGenerator;
import com.preproject.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
//enables cross-origin resource sharing only for this specific method
@RestController
//This annotation is used at the class level and allows the class to handle the requests made by the client.
@RequestMapping("/niit/auth")
//This annotation can be applied to class-level and/or method-level in a controller.
//The class-level annotation maps a specific request path or pattern onto a controller.
//You can then apply additional method-level annotations to make mappings more specific to handler methods.
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserSecurityTokenGenerator userSecurityTokenGenerator;

    @GetMapping("/get")
    public ResponseEntity<?>getAllUser(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<?>insertUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?>userAuth(@RequestBody User user){
        User userObj = userService.authCheck(user.getEmail(),user.getPassword());

        if(userObj!=null){
            Map<String,String> key = userSecurityTokenGenerator.tokenGenerator(user);
            return new ResponseEntity<>(key,HttpStatus.OK);
        }else{

            return new ResponseEntity<>("User not authorized",HttpStatus.NOT_FOUND);
        }
    }
}
