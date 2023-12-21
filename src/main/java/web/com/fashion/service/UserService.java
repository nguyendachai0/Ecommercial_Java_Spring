package web.com.fashion.service;

import web.com.fashion.model.User;

import java.util.Optional;

public interface UserService {
    void registerUser(User user);

    Optional<User> findByUsername(String username);
}