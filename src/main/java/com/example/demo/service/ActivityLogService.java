package com.example.demo.service;

import com.example.demo.dto.ActivityLogRequest;  // ✅ Use DTO
import com.example.demo.entity.ActivityLog;
import java.time.LocalDate;
import java.util.List;

public interface ActivityLogService {
    ActivityLog logActivity(Long userId, Long activityTypeId, ActivityLogRequest request);  // ✅ ActivityLogRequest
    List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate startDate, LocalDate endDate);
    List<ActivityLog> getLogsByUser(Long userId);
}
