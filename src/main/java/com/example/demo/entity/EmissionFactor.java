// com/example/demo/entity/EmissionFactor.java
package com.example.demo.entity;

import java.time.LocalDateTime;

public class EmissionFactor {
    private Long id;
    private ActivityType activityType;
    private Double factorValue;
    private String unit;
    private LocalDateTime createdAt;

    public EmissionFactor() {}

    public EmissionFactor(Long id, ActivityType activityType,
                          Double factorValue, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.activityType = activityType;
        this.factorValue = factorValue;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public ActivityType getActivityType() { return activityType; }

    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }

    public Double getFactorValue() { return factorValue; }

    public void setFactorValue(Double factorValue) { this.factorValue = factorValue; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
