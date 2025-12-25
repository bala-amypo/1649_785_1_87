// com/example/demo/service/EmissionFactorService.java
package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {
    EmissionFactor getFactorByType(Long typeId);
}
