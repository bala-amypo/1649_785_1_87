package com.example.demo.service;
import com.example.demo.entity.ActivityLog;
import java.util.*;
public interface ActivityLogService{
    ActivityLog registerActivityLog(ActivityLog stu);
    List<ActivityLog> getAllActivityLogs();
    ActivityLog getActivityLog(Long id);
    ActivityLog getByEmail(String email);
}