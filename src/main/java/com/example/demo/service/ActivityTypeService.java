package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import java.util.List;

public interface ActivityTypeService {
    ActivityType getType(Long id);
    List<ActivityType> findByCategoryId(Long categoryId);
}
