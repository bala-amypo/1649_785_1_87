package com.example.demo.controller;
import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
@RestController
public class EmissionFactorController{
    @Autowired EmissionFactorService serviceEF;
    @PostMapping("/api/EmissionFactors/register")
    public EmissionFactor sendData(@RequestBody EmissionFactor stu){
        return serviceEmissionFactor.registerEmissionFactor(stu);
    }
    @GetMapping("/api/EmissionFactors/all")
    public List<EmissionFactor> geAllData(){
        return serviceEmissionFactor.getAllEmissionFactors();
    }
    @GetMapping("/api/EmissionFactors/{id}")
    public EmissionFactor FindVal(@PathVariable int id){
        return serviceEmissionFactor.getEmissionFactor(id);
    }  
    @GetMapping("/api/EmissionFactors/{email}")
    public EmissionFactor UpdateData(@PathVariable String email){
            return serviceEmissionFactor.getByEmail(email);
    }

}