package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    @Autowired
    private EmissionFactorService factorService;

    @GetMapping("/type/{typeId}")
    public ResponseEntity<EmissionFactor> getFactorByType(@PathVariable Long typeId) {
        EmissionFactor factor = factorService.getFactorByType(typeId);
        return ResponseEntity.ok(factor);
    }
}
