package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.service.ActivityTypeService;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.entity.ActivityType;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ActivityTypeServiceImpl implements ActivityTypeService{
     @Autowired ActivityTypeRepository ActType;
     
          @Override
          public ActivityType createType(ActivityType stu){
               return ActType.save(stu);
          }
          @Override
          public List<ActivityType> getTypesByCategory(){
               return ActType.findAll();
          }
          
          @Override
          public ActivityType getType(Long id){
               return ActType.findById(id).orElse(null);
          }
}


