package edu.fontys.chatapp.controller;

import edu.fontys.chatapp.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "User")
public class UserController {

    //private final UserService userService;

    @MessageMapping("/user.input")
    @SendTo("/topic/user")
    public String UserModel(User userModel) throws Exception {
        return userModel.getUsername();
    }

    @GetMapping("/user/get/{id}")
    @Operation(summary = "get user with specified id")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
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
            //userService.deleteUser(id);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }

    @PostMapping("/user/register")
    @Operation(summary = "register user with specified name, password and room")
    public void registerUser(@RequestBody User user) {
        if (user != null) {
            //userService.registerUser(user);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }

    @PostMapping("/user/login")
    @Operation(summary = "login user with specified name, password and room")
    public void loginUser(@RequestBody User user) {
        if (user != null) {
            //userService.loginUser(user);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }

    @PutMapping("/user/update")
    @Operation(summary = "update user with specified name, password")
    public void updateUser(@RequestBody User user) {
        if (user != null) {
            //userService.updateUser(user);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }

    @GetMapping("/users/all")
    @Operation(summary = "get all users")
    public List<User> getUsers() {
        List<User> products = new ArrayList<>();

        User user1 = new User();
        user1.setUsername("User1");
        products.add(user1);

        User user2 = new User();
        user2.setUsername("User2");
        products.add(user2);

        return products;
        //return userService.getUsers();
    }
}