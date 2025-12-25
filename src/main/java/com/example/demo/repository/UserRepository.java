// com/example/demo/repository/UserRepository.java
package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean existsByEmail(String email);
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
