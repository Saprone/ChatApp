package edu.fontys.chatapp.controller;

import edu.fontys.chatapp.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

@RestController
@Tag(name = "User")
public class UserController {

    @MessageMapping("/user.input")
    @SendTo("/topic/user")
    public String UserModel(User userModel) throws Exception {
        return userModel.getUsername();
    }
}