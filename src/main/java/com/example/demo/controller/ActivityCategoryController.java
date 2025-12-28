// src/main/java/com/example/demo/controller/ActivityCategoryController.java
package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Activity Categories")
@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {
    
    @Autowired
    private ActivityCategoryService categoryService;

    @Operation(summary = "Create new category")
    @PostMapping
    public ResponseEntity<ActivityCategory> createCategory(@RequestBody ActivityCategory category) {
        ActivityCategory created = categoryService.createCategory(category);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Get all categories")
    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAllCategories() {
        List<ActivityCategory> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @Operation(summary = "Get category by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ActivityCategory> getCategory(@PathVariable Long id) {
        ActivityCategory category = categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }
}
