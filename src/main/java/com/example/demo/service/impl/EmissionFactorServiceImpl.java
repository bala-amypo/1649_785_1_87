package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository repository;

    public EmissionFactorServiceImpl(EmissionFactorRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmissionFactor getFactor(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public EmissionFactor getFactorByType(Long typeId) {
        return repository.findByTypeId(typeId);
    }
}
