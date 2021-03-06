package edu.fontys.chatapp.repository;

import edu.fontys.chatapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRolename(String rolename);
}