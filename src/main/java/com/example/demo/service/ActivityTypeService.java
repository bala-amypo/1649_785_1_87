// com/example/demo/service/ActivityTypeService.java
package com.example.demo.service;

import com.example.demo.entity.ActivityType;

import java.util.List;

public interface ActivityTypeService {
    ActivityType createType(ActivityType type);
    List<ActivityType> getTypesByCategory(Long categoryId);
}
