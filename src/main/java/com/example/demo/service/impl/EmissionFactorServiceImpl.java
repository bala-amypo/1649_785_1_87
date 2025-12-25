// com/example/demo/service/impl/EmissionFactorServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.EmissionFactorService;

public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final ActivityTypeRepository typeRepository;
    private final EmissionFactorRepository factorRepository;

    public EmissionFactorServiceImpl(ActivityTypeRepository typeRepository,
                                     EmissionFactorRepository factorRepository) {
        this.typeRepository = typeRepository;
        this.factorRepository = factorRepository;
    }

    @Override
    public EmissionFactor getFactorByType(Long typeId) {
        return factorRepository.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));
    }
}
