// src/main/java/com/example/demo/controller/ActivityLogController.java
package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Activity Logs")
@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {
    
    @Autowired
    private ActivityLogService logService;

    @Operation(summary = "Log new activity")
    @PostMapping("/user/{userId}/type/{typeId}")
public ResponseEntity<ActivityLog> logActivity(@PathVariable Long userId, 
                                              @PathVariable Long typeId,
                                              @RequestBody ActivityLogRequest request) {  // ✅ Keep ActivityLogRequest
    ActivityLog log = logService.logActivity(userId, typeId, request);  // ✅ Pass request directly
    return ResponseEntity.ok(log);
}


    @Operation(summary = "Get logs by user")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getLogsByUser(@PathVariable Long userId) {
        List<ActivityLog> logs = logService.getLogsByUser(userId);
        return ResponseEntity.ok(logs);
    }

    @Operation(summary = "Get logs by user and date range")
    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<ActivityLog>> getLogsByUserAndDate(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<ActivityLog> logs = logService.getLogsByUserAndDate(userId, start, end);
        return ResponseEntity.ok(logs);
    }
}
