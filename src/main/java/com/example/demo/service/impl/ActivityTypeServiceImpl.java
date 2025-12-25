package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository repository;

    public ActivityTypeServiceImpl(ActivityTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ActivityType> findByCategoryId(Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }

    @Override
    public ActivityType getType(Long id) {
        return repository.findById(id).orElse(null);
    }
}
