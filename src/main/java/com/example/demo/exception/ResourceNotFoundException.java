package com.example.demo.exception;
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Static helper methods (recommended for clarity)

    public static ResourceNotFoundException userNotFound() {
        return new ResourceNotFoundException("User not found");
    }

    public static ResourceNotFoundException profileNotFound() {
        return new ResourceNotFoundException("Financial profile not found");
    }

    public static ResourceNotFoundException requestNotFound() {
        return new ResourceNotFoundException("Loan request not found");
    }

    public static ResourceNotFoundException resultNotFound() {
        return new ResourceNotFoundException("Eligibility result not found");
    }
}