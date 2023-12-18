package web.com.fashion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import web.com.fashion.model.User;

// UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom queries if needed
}

// ProductRepository.java
