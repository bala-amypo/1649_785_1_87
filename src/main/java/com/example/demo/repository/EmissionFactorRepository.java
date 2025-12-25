package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EmissionFactor;
import java.util.*;
public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> { 
    Optional<EmissionFactor> findByActivityType_Id(Long typeId); 
}

