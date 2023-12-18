package web.com.fashion.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// AdminController.java
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String index(Model model) {
        // Add logic or data if needed
        return "admin/index"; // Change "index" to the desired view name
    }

    // Other admin-related methods
}
