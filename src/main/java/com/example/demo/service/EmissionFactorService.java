package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
public interface EmissionFactorService {

    EmissionFactor getFactorByType(Long activityTypeId);

    EmissionFactor createFactor(Long activityTypeId, Double factor, String unit);
}

