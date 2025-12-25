package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import java.util.*;

public interface EmissionFactorRepository {

    EmissionFactor save(EmissionFactor factor);

    List<EmissionFactor> findAll();

    Optional<EmissionFactor> findById(Long id);

    Optional<EmissionFactor> findByActivityType_Id(Long typeId);
}
