package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository repository;

    public ActivityLogServiceImpl(ActivityLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logActivity(Long userId, Long typeId, ActivityLog log) {
        log.setUserId(userId);
        log.setTypeId(typeId);
        repository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {
        return repository.findByUserIdAndDateBetween(userId, start, end);
    }

    @Override
    public ActivityLog getActivityLog(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
public void logActivity(Long userId, Long typeId, ActivityLog log) {
    User user = new User();
    user.setId(userId);
    log.setUser(user);

    ActivityType type = new ActivityType();
    type.setId(typeId);
    log.setType(type);

    repository.save(log);
}

}
