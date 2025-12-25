package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import java.util.*;

public interface ActivityTypeRepository {
    Optional<ActivityType> findById(Long id);
    List<ActivityType> findByCategory_Id(Long categoryId);
}
