package edu.fontys.chatapp.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String room;
    private List<String> chatMessages = new ArrayList<>();

    public String getUsername() {
        return username;
    }
}