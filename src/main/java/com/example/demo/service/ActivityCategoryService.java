package com.example.demo.service;
import com.example.demo.entity.ActivityCategory;
import java.util.*;
public interface ActivityCategoryService{
    ActivityCategory createCategory(ActivityCategory stu);
    List<ActivityCategory> getAllCategories();
    ActivityCategory getCategory(Long id);
}