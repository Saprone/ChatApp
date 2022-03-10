package edu.fontys.chatapp.controller;

import edu.fontys.chatapp.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.UUID;

@RestController
@Tag(name = "User")
public class UserController {

    @MessageMapping("/user.input")
    @SendTo("/topic/user")
    public String UserModel(User userModel) throws Exception {
        return userModel.getUsername();
    }

    //@Autowired
    //UserService userService;

    @GetMapping("/user/get/{id}")
    @Operation(summary = "get user with specified id")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        if (id != null) {
            User user = new User();
            user.setId(id);
            user.setUsername("User"+id);
            user.setRoom("DefaultRoom");

            return ResponseEntity.ok(user);
            //return userService.getUserById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }

    @DeleteMapping("/user/delete/{id}")
    @Operation(summary = "delete user with specified id")
    public void deleteUser(@PathVariable UUID id) {
        if (id != null) {
            //userService.delete(id);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }
}