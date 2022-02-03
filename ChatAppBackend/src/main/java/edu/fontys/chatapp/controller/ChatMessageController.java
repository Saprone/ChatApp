package edu.fontys.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    @MessageMapping("/chat.send")
    @SendTo("/topic/chatmessage")
    public String sendChatMessage() {
        return "This is a test message.";
    }
}