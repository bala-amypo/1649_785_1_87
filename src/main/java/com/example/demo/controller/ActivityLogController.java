package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/activity-log")
public class ActivityLogController {

    @Autowired
    private ActivityLogService logService;

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog logActivity(@PathVariable Long userId,
                                   @PathVariable Long typeId,
                                   @RequestBody ActivityLog log) {
        return logService.logActivity(userId, typeId, log);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> getLogsByUser(@PathVariable Long userId) {
        return logService.getLogsByUser(userId);
    }

    @GetMapping("/user/{userId}/between")
    public List<ActivityLog> getLogsByUserAndDate(@PathVariable Long userId,
                                                  @RequestParam String start,
                                                  @RequestParam String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return logService.getLogsByUserAndDate(userId, startDate, endDate);
    }
}
