package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class UserServiceImpl implements UserService{
     @Autowired UserRepository student;
     
          @Override
          public User registerUser(User stu){
               return student.save(stu);
          }
          @Override
          public List<User> getAllUsers(){
               return student.findAll();
          }
          
          @Override
          public User getUser(Long id){
               return student.findById(id).orElse(null);
          }
          @Override
          public User getByEmail(String email){
               return student.findByEmail().orElse(null);
          }
}


