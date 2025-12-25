package com.example.demo.service;

import com.example.demo.entity.ActivityLog;

import java.time.LocalDate;
import java.util.List;

public interface ActivityLogService {
    ActivityLog logActivity(Long userId, Long typeId, ActivityLog log); // return ActivityLog
    List<ActivityLog> getLogsByUser(Long userId);
    List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end);
    ActivityLog getActivityLog(Long id); // implement this in ActivityLogServiceImpl
}
