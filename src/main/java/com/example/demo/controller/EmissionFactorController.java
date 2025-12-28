// src/main/java/com/example/demo/controller/EmissionFactorController.java
package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Emission Factors")
@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {
    
    @Autowired
    private EmissionFactorService factorService;

    @Operation(summary = "Get emission factor by activity type")
    @GetMapping("/{activityTypeId}")
    public ResponseEntity<EmissionFactor> getFactorByType(@PathVariable Long activityTypeId) {
        EmissionFactor factor = factorService.getFactorByType(activityTypeId);
        return ResponseEntity.ok(factor);
    }
}
