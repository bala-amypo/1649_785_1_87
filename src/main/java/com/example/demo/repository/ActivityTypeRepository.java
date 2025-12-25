package com.example.demo.repository;
import jakarta.persistence.*;
import com.example.demo.entity.ActivityType;
import java.util.*;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> { 
    List<ActivityType> findByCategory_Id(Long id); 
    }

