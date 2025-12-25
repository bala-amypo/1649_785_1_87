package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor
@Entity
@Data
    @NoArgsConstructor
    @AllArgsConstructo
public class EmissionFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ActivityType activityType;
    private Double factorValue;
    private String unit;
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist() { if(createdAt==null) createdAt=LocalDateTime.now(); }
}
