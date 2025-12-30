package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import com.example.demo.dto.ActivityTypeRequest;
import com.example.demo.repository.ActivityTypeRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {
    private final ActivityTypeRepository typeRepository;
    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeRepository typeRepository, ActivityTypeService typeService) {
        this.typeRepository = typeRepository;
        this.typeService = typeService;
    }

    @GetMapping("/category/{categoryId}")
    public List<ActivityType> getTypesByCategory(@PathVariable Long categoryId) {
        return typeRepository.findByCategory_Id(categoryId);
    }

    @PostMapping("/category/{categoryId}")
    public ActivityType createType(
            @PathVariable Long categoryId,
            @RequestBody ActivityTypeRequest request) {

        return typeService.createType(
                categoryId,
                request.getTypeName(),
                request.getUnit()
        );
    }
}

}
