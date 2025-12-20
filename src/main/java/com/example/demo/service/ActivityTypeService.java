package com.example.demo.service;
import com.example.demo.entity.ActivityType;
import java.util.*;
public interface ActivityTypeService{
    ActivityType registerActivityType(ActivityType stu);
    List<ActivityType> getAllActivityTypes();
    ActivityType getActivityType(Long id);
    ActivityType getByEmail(String email);
}