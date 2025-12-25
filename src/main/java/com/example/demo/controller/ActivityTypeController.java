package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(@PathVariable Long categoryId) {
        List<ActivityType> list = typeService.findByCategory_Id(categoryId);
        return ResponseEntity.ok(list);
    }
}
