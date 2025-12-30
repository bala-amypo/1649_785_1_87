package com.example.demo.service;

import com.example.demo.entity.ActivityType;

public interface ActivityTypeService {
    ActivityType createType(Long categoryId, String typeName, String unit);
}
