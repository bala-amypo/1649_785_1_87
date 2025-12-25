package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository repository;

    public ActivityTypeServiceImpl(ActivityTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityType getType(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ActivityType> findByCategory_Id(Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }
}
