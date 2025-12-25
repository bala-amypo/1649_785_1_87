// com/example/demo/entity/ActivityType.java
package com.example.demo.entity;

import java.time.LocalDateTime;

public class ActivityType {
    private Long id;
    private String typeName;
    private ActivityCategory category;
    private String unit;
    private LocalDateTime createdAt;

    public ActivityType() {}

    public ActivityType(Long id, String typeName, ActivityCategory category,
                        String unit, LocalDateTime createdAt) {
        this.id = id;
        this.typeName = typeName;
        this.category = category;
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

    public String getTypeName() { return typeName; }

    public void setTypeName(String typeName) { this.typeName = typeName; }

    public ActivityCategory getCategory() { return category; }

    public void setCategory(ActivityCategory category) { this.category = category; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
