package com.example.demo.service;
import com.example.demo.entity.EmissionFactor;
import java.util.*;
public interface EmissionFactorService{
    EmissionFactor createFactor(EmissionFactor stu);
    List<EmissionFactor> getAllFactors();
    EmissionFactor getFactor(Long id);
    // EmissionFactor getByEmail(String email);
}