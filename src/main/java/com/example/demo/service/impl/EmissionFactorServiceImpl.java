package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmissionFactorServiceImpl {
    
    @Autowired
    private ActivityTypeRepository typeRepository;
    
    @Autowired
    private EmissionFactorRepository factorRepository;

    public EmissionFactor getFactorByType(Long activityTypeId) {
        return factorRepository.findByActivityType_Id(activityTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found for activity type: " + activityTypeId));
    }
}
