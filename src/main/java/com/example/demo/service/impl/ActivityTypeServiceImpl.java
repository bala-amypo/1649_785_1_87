package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepository;
    private final ActivityCategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository typeRepository,
                                   ActivityCategoryRepository categoryRepository) {
        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityType createType(ActivityType type) {
        type.prePersist();
        return typeRepository.save(type);
    }

    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepository.findByCategory_Id(categoryId);
    }
    @Override
    public ActivityType getTypeById(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ActivityType not found: " + id));
    }
}
