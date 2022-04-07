package edu.fontys.chatapp.controller;

import edu.fontys.chatapp.model.User;
import edu.fontys.chatapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MessageMapping("/user.input")
    @SendTo("/topic/user")
    public String UserModel(User userModel) {
        return userModel.getUsername();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}