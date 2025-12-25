package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One-to-many relationship with EmissionFactor
    @OneToMany(mappedBy = "activityType")
    private List<EmissionFactor> emissionFactors;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<EmissionFactor> getEmissionFactors() { return emissionFactors; }
    public void setEmissionFactors(List<EmissionFactor> emissionFactors) { this.emissionFactors = emissionFactors; }
}
