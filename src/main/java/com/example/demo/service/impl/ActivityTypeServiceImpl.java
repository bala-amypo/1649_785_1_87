package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityTypeServiceImpl {
    
    @Autowired
    private ActivityCategoryRepository categoryRepository;
    
    @Autowired
    private ActivityTypeRepository typeRepository;
}
