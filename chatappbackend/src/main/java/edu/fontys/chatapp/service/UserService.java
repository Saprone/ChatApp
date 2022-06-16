package edu.fontys.chatapp.service;

import edu.fontys.chatapp.model.Role;
import edu.fontys.chatapp.model.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();
}