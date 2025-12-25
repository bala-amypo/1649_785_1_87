package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    private final ActivityLogService logService;

    public ActivityLogController(ActivityLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/user/{userId}/type/{typeId}")
    public ResponseEntity<ActivityLog> logActivity(@PathVariable Long userId,
                                                   @PathVariable Long typeId,
                                                   @RequestBody ActivityLog log) {
        ActivityLog created = logService.logActivity(userId, typeId, log);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getLogsByUser(@PathVariable Long userId) {
        List<ActivityLog> list = logService.getLogsByUser(userId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<ActivityLog>> getLogsByUserAndDate(@PathVariable Long userId,
                                                                  @RequestParam("start") String start,
                                                                  @RequestParam("end") String end) {
        List<ActivityLog> list = logService.getLogsByUserAndDate(userId,
                LocalDate.parse(start), LocalDate.parse(end));
        return ResponseEntity.ok(list);
    }
}
