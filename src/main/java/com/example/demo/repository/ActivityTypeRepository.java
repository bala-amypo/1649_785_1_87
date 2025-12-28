package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    List<ActivityType> findByCategory_Id(Long categoryId);
}
