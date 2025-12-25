package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.User;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityTypeRepository typeRepository;

    @Override
    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        ActivityType type = typeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("ActivityType not found"));

        log.setUser(user);
        log.setType(type);

        return repository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {
        return repository.findByUserIdAndDateBetween(userId, start, end);
    }
}
