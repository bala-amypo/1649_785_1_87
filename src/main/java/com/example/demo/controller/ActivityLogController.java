package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.exception.ResourceNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService logService;

    @PostMapping("/user/{userId}/type/{typeId}")
    public ResponseEntity<ActivityLog> logActivity(@PathVariable Long userId, 
                                                  @PathVariable Long typeId,
                                                  @RequestBody ActivityLog log) {
        ActivityLog created = logService.logActivity(userId, typeId, log);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(logService.getLogsByUser(userId));
    }

    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<ActivityLog>> getLogsByUserAndDate(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(logService.getLogsByUserAndDate(userId, start, end));
    }
    
@GetMapping("/{id}")
public ResponseEntity<ActivityLog> getLogById(@PathVariable Long id) {
    ActivityLog log = logService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ActivityLog not found: " + id));
    return ResponseEntity.ok(log);
}

}
