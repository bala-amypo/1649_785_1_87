package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class ActivityLogServiceImpl {

    private final UserRepository userRepository;
    private final ActivityTypeRepository activityTypeRepository;
    private final EmissionFactorRepository emissionFactorRepository;
    private final ActivityLogRepository activityLogRepository;

    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {

        if (log.getActivityDate().isAfter(LocalDate.now())) {
            throw new ValidationException("cannot be in the future");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ActivityType type = activityTypeRepository.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Type not found"));

        EmissionFactor factor = emissionFactorRepository.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ValidationException("No emission factor configured"));

        log.setUser(user);
        log.setActivityType(type);
        log.setEstimatedEmission(log.getQuantity() * factor.getFactorValue());

        return activityLogRepository.save(log);
    }

    public List<ActivityLog> getLogsByUser(Long userId) {
        return activityLogRepository.findByUser_Id(userId);
    }

    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {
        return activityLogRepository.findByUser_IdAndActivityDateBetween(userId, start, end);
    }
}
