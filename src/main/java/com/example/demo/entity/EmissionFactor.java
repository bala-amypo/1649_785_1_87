package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
public class EmissionFactor{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private ActivityType activityType;
    private Double factorValue;
    private String unit;
    @PrePersist
    private LocalDateTime createdAt;
    public void PrePersist() {
        this.createdAt = LocalDateTime.now();
    }
}