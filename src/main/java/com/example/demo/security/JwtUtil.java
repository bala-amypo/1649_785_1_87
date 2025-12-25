package com.example.demo.security;

import com.example.demo.entity.User;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final Map<String, Map<String, Object>> tokenStore = new HashMap<>();

    public String generateToken(Map<String, Object> claims, String subject) {
        String token = Base64.getEncoder()
                .encodeToString((subject + System.nanoTime()).getBytes());
        tokenStore.put(token, claims);
        return token;
    }

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());
        return generateToken(claims, user.getEmail());
    }

    public String extractUsername(String token) {
        return (String) parseToken(token).getPayload().get("email");
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getPayload().get("role");
    }

    public Long extractUserId(String token) {
        return (Long) parseToken(token).getPayload().get("userId");
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }

    public ParsedToken parseToken(String token) {
        if (!tokenStore.containsKey(token)) {
            throw new RuntimeException("Invalid token");
        }
        return new ParsedToken(tokenStore.get(token));
    }

    // helper class
    public static class ParsedToken {
        private final Map<String, Object> payload;

        public ParsedToken(Map<String, Object> payload) {
            this.payload = payload;
        }

        public Map<String, Object> getPayload() {
            return payload;
        }
    }
}
