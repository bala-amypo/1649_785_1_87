package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Activity Types", description = "Activity type management APIs")
@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    @Autowired
    private ActivityTypeRepository typeRepository;

    @Operation(summary = "Get types by category ID")
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(@PathVariable Long categoryId) {
        List<ActivityType> types = typeRepository.findByCategory_Id(categoryId);
        return ResponseEntity.ok(types);
    }

    @Operation(summary = "Get all activity types")
    @GetMapping
    public ResponseEntity<List<ActivityType>> getAllTypes() {
        List<ActivityType> types = typeRepository.findAll();
        return ResponseEntity.ok(types);
    }
}
