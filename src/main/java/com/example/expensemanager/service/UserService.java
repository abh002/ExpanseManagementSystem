package com.example.expensemanager.service;

import com.example.expensemanager.model.User;
import com.example.expensemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to register a new user
    public User registerUser(String username, String email, String password) {
        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("User already exists with email: " + email);
        }
        User user = new User(username, email, password);
        return userRepository.save(user);
    }

    // Method to find a user by email
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
