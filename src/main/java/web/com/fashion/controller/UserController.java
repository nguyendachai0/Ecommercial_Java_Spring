package web.com.fashion.controller;



import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.com.fashion.model.User;
import web.com.fashion.repository.UserRepository;

import java.util.List;

// UserController.java
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/list")
    public String userList(Model model) {
        List<User> users = userRepository.findAll();

        return "user/list";
    }
    @GetMapping
    public String userPage(Model model) {
        // Add logic or data if needed
        return "user/index"; // Change "index" to the desired view name
    }
    // Add other user-related methods
}
