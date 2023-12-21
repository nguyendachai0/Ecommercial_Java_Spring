package web.com.fashion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import web.com.fashion.model.User;

import java.util.Optional;

// UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

// ProductRepository.java
