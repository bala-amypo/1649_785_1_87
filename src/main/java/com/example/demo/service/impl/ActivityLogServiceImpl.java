// com/example/demo/service/impl/ActivityLogServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.entity.User;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ActivityLogService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ActivityLogServiceImpl implements ActivityLogService {

    private final UserRepository userRepository;
    private final ActivityTypeRepository typeRepository;
    private final EmissionFactorRepository factorRepository;
    private final ActivityLogRepository logRepository;

    public ActivityLogServiceImpl(UserRepository userRepository,
                                  ActivityTypeRepository typeRepository,
                                  EmissionFactorRepository factorRepository,
                                  ActivityLogRepository logRepository) {
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.factorRepository = factorRepository;
        this.logRepository = logRepository;
    }

    @Override
    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {
        User user = userRepository.findById(userId).orElseThrow();
        ActivityType type = typeRepository.findById(typeId).orElse(null);

        if (log.getActivityDate() != null && log.getActivityDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Activity date cannot be in the future");
        }

        EmissionFactor factor = factorRepository.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ValidationException("No emission factor configured"));

        double estimated = (log.getQuantity() != null ? log.getQuantity() : 0.0) * factor.getFactorValue();

        log.setUser(user);
        log.setActivityType(type);
        log.setEstimatedEmission(estimated);
        if (log.getLoggedAt() == null) {
            log.setLoggedAt(LocalDateTime.now());
        }

        return logRepository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {
        return logRepository.findByUser_IdAndActivityDateBetween(userId, start, end);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return logRepository.findByUser_Id(userId);
    }
}
