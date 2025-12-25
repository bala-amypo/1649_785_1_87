package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService categoryService;

    public ActivityCategoryController(ActivityCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ActivityCategory> createCategory(@RequestBody ActivityCategory category) {
        ActivityCategory created = categoryService.createCategory(category);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAllCategories() {
        List<ActivityCategory> list = categoryService.getAllCategories();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityCategory> getCategory(@PathVariable Long id) {
        ActivityCategory category = categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }
}
