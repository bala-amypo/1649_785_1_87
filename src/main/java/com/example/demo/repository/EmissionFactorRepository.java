package com.example.demo.repository;
import com.example.demo.entity.EmissionFactor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EmissionFactorRepository extends JpaRepository<EmissionFactor,Long>{

}