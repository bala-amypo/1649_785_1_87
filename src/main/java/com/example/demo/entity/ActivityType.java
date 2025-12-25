package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Entity
@Data
    @NoArgsConstructor
    @AllArgsConstructor
public class ActivityType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    @ManyToOne
    private ActivityCategory category;
    private String unit;
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist() { if(createdAt==null) createdAt=LocalDateTime.now(); }
}
