package com.project.authentication.rabbitmq;

import com.project.authentication.exception.UserAlreadyExistsException;
import com.project.authentication.model.User;
import com.project.authentication.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @Autowired
    private UserService userService;
    @RabbitListener(queues = "que")
    public void getDTOAndAddToDB(RegistrationDTO regDTO) throws UserAlreadyExistsException{
        User user =new User();
        user.setEmail(regDTO.getEmailID());
        user.setPassword(regDTO.getPassword());
        user.setRole(regDTO.getRole());
        User user1 =userService.addUser(user);
    }

}
