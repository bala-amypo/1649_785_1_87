package com.example.demo.dto;

public class RegisterRequest {
    private String name, email, password;
    public RegisterRequest() {}
    public RegisterRequest(String name, String email, String password) { this.name=name; this.email=email; this.password=password; }
    // Getters/Setters
}
