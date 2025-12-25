// com/example/demo/repository/ActivityCategoryRepository.java
package com.example.demo.repository;

import com.example.demo.entity.ActivityCategory;

import java.util.List;
import java.util.Optional;

public interface ActivityCategoryRepository {
    boolean existsByCategoryName(String name);
    ActivityCategory save(ActivityCategory category);
    List<ActivityCategory> findAll();
    Optional<ActivityCategory> findById(Long id);
}
