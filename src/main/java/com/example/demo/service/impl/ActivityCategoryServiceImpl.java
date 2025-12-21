package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.service.ActivityCategoryService;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.entity.ActivityCategory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService{
     @Autowired ActivityCategoryRepository ActCat;
     
          @Override
          public ActivityCategory createCategory(ActivityCategory stu){
               return ActCat.save(stu);
          }
          @Override
          public List<ActivityCategory> getAllCategories(){
               return ActCat.findAll();
          }
          
          @Override
          public ActivityCategory getCategory(Long id){
               return ActCat.findById(id).orElse(null);
          }
}


