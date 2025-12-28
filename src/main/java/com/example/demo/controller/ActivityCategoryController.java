package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    @Autowired
    private ActivityCategoryService categoryService;

    @PostMapping
    public ResponseEntity<ActivityCategory> create(@RequestBody ActivityCategory category) {
        ActivityCategory created = categoryService.createCategory(category);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityCategory> getCategory(@PathVariable Long id) {
        ActivityCategory category = categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }
}
