// com/example/demo/repository/EmissionFactorRepository.java
package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;

import java.util.Optional;

public interface EmissionFactorRepository {
    EmissionFactor save(EmissionFactor emissionFactor);
    Optional<EmissionFactor> findByActivityType_Id(Long typeId);
}
