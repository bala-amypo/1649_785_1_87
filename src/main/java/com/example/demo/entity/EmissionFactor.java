package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmissionFactor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ActivityType activityType;
    private Double factorValue;
    private String unit;
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist() { if(createdAt==null) createdAt=LocalDateTime.now(); }
}
