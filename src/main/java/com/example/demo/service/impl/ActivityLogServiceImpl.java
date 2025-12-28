package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.*;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final UserRepository userRepository;
    private final ActivityTypeRepository typeRepository;
    private final EmissionFactorRepository factorRepository;
    private final ActivityLogRepository logRepository;

    public ActivityLogServiceImpl(UserRepository userRepository, ActivityTypeRepository typeRepository,
                                  EmissionFactorRepository factorRepository, ActivityLogRepository logRepository) {
        this.userRepository = userRepository;
        this.typeRepository
