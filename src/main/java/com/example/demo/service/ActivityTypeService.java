package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import java.util.List;

public interface ActivityTypeService {
    List<ActivityType> findByCategoryId(Long categoryId);
    ActivityType getType(Long id);
}
