package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import java.util.*;

public interface ActivityTypeRepository {

    ActivityType save(ActivityType type);

    List<ActivityType> findAll();

    Optional<ActivityType> findById(Long id);

    List<ActivityType> findByCategory_Id(Long categoryId);
}
