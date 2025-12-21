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

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
@RestController
public class UserController{
    @Autowired UserService serviceUser;
    @PostMapping("/api/users/register")
    public User sendData(@RequestBody User stu){
        return serviceUser.registerUser(stu);
    }
    @GetMapping("/api/users/all")
    public List<User> geAllData(){
        return serviceUser.getData();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteVal(@PathVariable int id){
        return serviceUser.deleteData(id);
    }
    @GetMapping("/getData/{id}")
    public User FindVal(@PathVariable int id){
        return serviceUser.findData(id);
    }  
    @PutMapping("/put/{id}")
    public User UpdateData(@PathVariable int id,@RequestBody User stu){
            return serviceUser.updateData(id,stu);
    }

}