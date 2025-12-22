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
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
@RestController
public class ActivityLogController{
    @Autowired ActivityLogService serviceActLog;
    @PostMapping("/api/logs/register")
    public ActivityLog sendData(@RequestBody ActivityLog stu){
        return serviceActLog.registerActivityLog(stu);
    }
    @GetMapping("/api/logs/all")
    public List<ActivityLog> geAllData(){
        return serviceActLog.getAllActivityLogs();
    }
    @GetMapping("/api/logs/{id}")
    public ActivityLog FindVal(@PathVariable Long id){
        return serviceActLog.getActivityLog(id);
    }  
    // @GetMapping("/api/logs/{email}")
    // public ActivityLog UpdateData(@PathVariable String email){
    //         return serviceActLog.getByEmail(email);
    // }

}