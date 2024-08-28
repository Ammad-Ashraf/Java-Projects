package Tayyab.Project.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import Tayyab.Project.entity.User;

import java.util.Optional;

// Persistence Layer
public interface UserDao extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
