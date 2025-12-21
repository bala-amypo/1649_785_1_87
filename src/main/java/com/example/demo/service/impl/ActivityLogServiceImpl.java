package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.service.ActivityLogService;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.entity.ActivityLog;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ActivityLogServiceImpl implements ActivityLogService{
     @Autowired ActivityLogRepository student;
     
          @Override
          public ActivityLog registerActivityLog(ActivityLog stu){
               return student.save(stu);
          }
          @Override
          public List<ActivityLog> getAllActivityLogs(){
               return student.findAll();
          }
          
          @Override
          public ActivityLog getActivityLog(Long id){
               return student.findById(id).orElse(null);
          }
          @Override
          public ActivityLog getByEmail(String email){
               return student.findByEmail().orElse(null);
          }
}


