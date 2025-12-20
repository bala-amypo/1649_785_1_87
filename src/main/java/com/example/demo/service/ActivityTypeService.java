package com.example.demo.service;
import com.example.demo.entity.ActivityType;
import java.util.*;
public interface ActivityTypeService{
    ActivityType createType(ActivityType stu);
    List<ActivityType> getTypesByCategory(Long categoryId);
    ActivityType getType(Long id);
}