package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityCategoryRepository categoryRepository;
    private final ActivityTypeRepository typeRepository;

    public ActivityTypeServiceImpl(ActivityCategoryRepository categoryRepository,
                                   ActivityTypeRepository typeRepository) {
        this.categoryRepository = categoryRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public ActivityType createType(Long categoryId, String typeName, String unit) {
        ActivityCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        ActivityType type = new ActivityType();
        type.setTypeName(typeName);
        type.setUnit(unit);
        type.setCategory(category);

        return typeRepository.save(type);
    }
}
