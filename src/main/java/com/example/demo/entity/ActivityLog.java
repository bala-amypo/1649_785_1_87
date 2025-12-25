package com.example.demo.entity;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    private Long id;
    private ActivityType activityType;
    private User user;
    private Double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }
}
