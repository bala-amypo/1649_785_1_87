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
    @PostMapping("/api/Factors/register")
    public EmissionFactor sendData1(@RequestBody EmissionFactor stu){
        return serviceEF.createFactor(stu);
    }
    @GetMapping("/api/Factors/all")
    public List<EmissionFactor> geAllData1(){
        return serviceEF.getAllFactors();
    }
    @GetMapping("/api/Factors/{id}")
    public EmissionFactor FindVal1(@PathVariable Long id){
        return serviceEF.getFactor(id);
    }  
    // @GetMapping("/api/Factors/{email}")
    // public EmissionFactor UpdateData1(@PathVariable String email){
    //         return serviceEF.getByEmail(email);
    // }

}