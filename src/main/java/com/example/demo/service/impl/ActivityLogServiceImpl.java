package com.example.demo.service.impl;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.*;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ActivityTypeRepository typeRepository;
    
    @Autowired
    private EmissionFactorRepository factorRepository;
    
    @Autowired
    private ActivityLogRepository logRepository;

    @Override
    public ActivityLog logActivity(Long userId, Long activityTypeId, ActivityLogRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        ActivityType type = typeRepository.findById(activityTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));
        
        if (request.getActivityDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Activity date cannot be in the future");
        }
        
        EmissionFactor factor = factorRepository.findByActivityType_Id(activityTypeId)
                .orElseThrow(() -> new ValidationException("No emission factor configured for this activity type"));
        
        ActivityLog log = new ActivityLog();
        log.setUser(user);
        log.setActivityType(type);
        log.setQuantity(request.getQuantity());
        log.setActivityDate(request.getActivityDate());
        log.setEstimatedEmission(request.getQuantity() * factor.getFactorValue());
        log.prePersist();
        
        return logRepository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate startDate, LocalDate endDate) {
        return logRepository.findByUser_IdAndActivityDateBetween(userId, startDate, endDate);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return logRepository.findByUser_Id(userId);
    }
}
