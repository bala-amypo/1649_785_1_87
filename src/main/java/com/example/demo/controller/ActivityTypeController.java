package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityTypeController {

    @Autowired
    private ActivityTypeService typeService;

    // POST: Create new ActivityType
    @PostMapping
    public ResponseEntity<ActivityType> createType(@RequestBody ActivityType type) {
        ActivityType created = typeService.createType(type);
        return ResponseEntity.ok(created);
    }

    // GET: All types by Category ID (matches your test t43)
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(@PathVariable Long categoryId) {
        List<ActivityType> types = typeService.getTypesByCategory(categoryId);
        return ResponseEntity.ok(types);
    }
}
