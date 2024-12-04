package com.example.expensemanager.Controller;

import com.example.expensemanager.model.User;
import com.example.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint for user registration
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getEmail(), user.getPassword());
    }

    // Endpoint for user login
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        User foundUser = userService.findUserByEmail(user.getEmail());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser; // In a real-world scenario, use JWT or OAuth here
        }
        throw new RuntimeException("Invalid credentials");
    }
}
