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
import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
@RestController
public class ActivityTypeController{
    @Autowired ActivityTypeService serviceActTyp;
    @PostMapping("/api/types/register")
    public ActivityType sendData(@RequestBody ActivityType stu){
        return serviceActTyp.createType(stu);
    }
    @GetMapping("/api/types/all")
    public List<ActivityType> geAllData(){
        return serviceActTyp.getTypesByCategory();
    }
    @GetMapping("/api/types/{id}")
    public ActivityType FindVal(@PathVariable Long id){
        return serviceActTyp.getType(id);
    }  

}