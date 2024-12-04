package com.example.expensemanager.model;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

/**
 * Represents a User entity stored in MongoDB.
 */
@Getter
@Document(collection = "users") // Links this class to the MongoDB "users" collection
public class User{

    // Getters and Setters for accessing fields
    @Id // Unique identifier for MongoDB
    private String id;

    private String name; // User's name
    private String email; // User's email
    private String password; // User's password (hashed for security)
    private Set<String> roles; // Roles (e.g., USER, ADMIN)

    // Default constructor (required by Spring Data)
    public User() {}

    // Constructor with fields
    public User(String id, String name, String email, String password, Set<String> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
