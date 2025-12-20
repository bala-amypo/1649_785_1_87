package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Override;
@Service
public class UserServiceImpl implements UserService{
     @Autowired UserRepository student;
     
          @Override
          public User postData(User stu){
               return student.save(stu);
          }
          @Override
          public List<User> getData(){
               return student.findAll();
          }
          @Override
          public String deleteData(int id){
               student.deleteById(id);
               return "Delete Successfully!";
          }
          @Override
          public User findData(int id){
               return student.findById(id).orElse(null);
          }
          @Override
          public User updateData(int id,User s){
               if(student.existsById(id)){
                    s.setId(id);
                    return student.save(s);
               }
               else{
                    return null;
               }
          }
}


