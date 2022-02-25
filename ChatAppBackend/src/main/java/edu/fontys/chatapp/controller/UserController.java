package edu.fontys.chatapp.controller;

import edu.fontys.chatapp.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @MessageMapping("/user.input")
    @SendTo("/topic/user")
    public String UserModel(User userModel) throws Exception {
        return userModel.getUsername();
    }
}