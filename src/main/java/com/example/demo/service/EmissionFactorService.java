package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {
    EmissionFactor getFactor(Long id);
    EmissionFactor getFactorByType(Long typeId);
}
