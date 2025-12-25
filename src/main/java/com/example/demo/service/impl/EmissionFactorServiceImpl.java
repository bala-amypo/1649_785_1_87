package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    @Autowired
    private EmissionFactorRepository repository;

    @Override
    public List<EmissionFactor> getFactorByType(Long typeId) {
        return repository.findByTypeId(typeId);
    }
}
