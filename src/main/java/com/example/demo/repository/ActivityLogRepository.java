// com/example/demo/repository/ActivityLogRepository.java
package com.example.demo.repository;

import com.example.demo.entity.ActivityLog;

import java.time.LocalDate;
import java.util.List;

public interface ActivityLogRepository {
    ActivityLog save(ActivityLog log);
    List<ActivityLog> findByUser_Id(Long userId);
    List<ActivityLog> findByUser_IdAndActivityDateBetween(Long userId,
                                                          LocalDate start,
                                                          LocalDate end);
}
