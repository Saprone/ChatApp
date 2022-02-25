package edu.fontys.chatapp.controller;

import edu.fontys.chatapp.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    @Operation(summary = "Get user", responses = {
            @ApiResponse(description = "Get user success", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(description = "User not found", responseCode = "409", content = @Content)
    })
    public ResponseEntity<User> getUser(int id) {
        if (1 == id) {
            User user = new User();
            user.setId(1);
            user.setUsername("User1");

            return ResponseEntity.ok(user);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public ResponseEntity<Void> updateUser(User user) {
        return ResponseEntity.ok().build();
    }
}