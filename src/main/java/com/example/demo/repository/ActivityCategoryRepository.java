package com.example.demo.repository;

import com.example.demo.entity.ActivityCategory;
import java.util.*;

public interface ActivityCategoryRepository {
    boolean existsByCategoryName(String name);
    ActivityCategory save(ActivityCategory category);
    Optional<ActivityCategory> findById(Long id);
    List<ActivityCategory> findAll();
}
