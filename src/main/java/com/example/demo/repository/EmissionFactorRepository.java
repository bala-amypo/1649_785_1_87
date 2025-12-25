package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import java.util.Optional;

public interface EmissionFactorRepository {
    Optional<EmissionFactor> findByActivityType_Id(Long typeId);
}
