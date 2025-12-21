package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.service.EmissionFactorService;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.entity.EmissionFactor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class EmissionFactorServiceImpl implements EmissionFactorService{
     @Autowired EmissionFactorRepository student;
     
          @Override
          public EmissionFactor createFactor(EmissionFactor stu){
               return student.save(stu);
          }
          @Override
          public List<EmissionFactor> getAllFactors(){
               return student.findAll();
          }
          
          @Override
          public EmissionFactor getFactor(Long id){
               return student.findById(id).orElse(null);
          }
          @Override
          public EmissionFactor getByEmail(String email){
               return student.findByEmail().orElse(null);
          }
}


