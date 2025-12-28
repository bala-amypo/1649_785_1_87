package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                                  @RequestBody ActivityLogRequest request) {  // ✅ ActivityLogRequest
        ActivityLog log = logService.logActivity(userId, typeId, request);  // ✅ Pass request
        return ResponseEntity.ok(log);
    }

    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<ActivityLog>> getLogsByUserAndDate(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<ActivityLog> logs = logService.getLogsByUserAndDate(userId, start, end);
        return ResponseEntity.ok(logs);
    }
}
