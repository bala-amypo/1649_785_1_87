package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import java.util.*;
public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> { Optional<EmissionFactor> findByActivityType_Id(Long typeId); }

