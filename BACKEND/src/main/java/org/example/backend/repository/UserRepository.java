package org.example.backend.repository;

import org.example.backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByEmail(String email);
    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
}
