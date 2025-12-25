package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> {

    // Fix: traverse the relation with '_id'
    List<EmissionFactor> findByType_Id(Long typeId);
}
