package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Data
    @NoArgsConstructor
    @AllArgsConstructor
public class ActivityLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne private ActivityType activityType;
    @ManyToOne private User user;
    private Double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;
    @PrePersist
    public void prePersist() { if(loggedAt==null) loggedAt=LocalDateTime.now(); }
}
