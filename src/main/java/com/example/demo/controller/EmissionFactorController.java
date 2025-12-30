package com.example.demo.controller;

import com.example.demo.dto.EmissionFactorRequest;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    // ✅ POST /api/factors/{activityTypeId}
    @PostMapping("/{activityTypeId}")
    public EmissionFactor createFactor(
            @PathVariable Long activityTypeId,
            @RequestBody EmissionFactorRequest request) {

        return factorService.createFactor(activityTypeId, request.getFactor());
    }

    @GetMapping("/type/{typeId}")
    public EmissionFactor getFactorByType(@PathVariable Long typeId) {
        return factorService.getFactorByType(typeId);
    }
}
