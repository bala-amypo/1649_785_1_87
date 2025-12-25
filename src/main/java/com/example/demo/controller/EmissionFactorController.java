package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/emission-factors")
public class EmissionFactorController {

    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping("/{typeId}")
    public List<EmissionFactor> getFactors(@PathVariable Long typeId) {
        return factorService.getFactorByType(typeId); // must be List
    }
}
