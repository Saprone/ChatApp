package edu.fontys.chatapp.repositorys;

import edu.fontys.chatapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}