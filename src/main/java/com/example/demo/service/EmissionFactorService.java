package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import java.util.List;

public interface EmissionFactorService {
    List<EmissionFactor> getFactorByType(Long typeId); // must match impl
}
