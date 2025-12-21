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
    @Autowired UserService ser;
    @PostMapping("/post")
    public User sendData(@RequestBody User stu){
        return ser.postData(stu);
    }
    @GetMapping("/get")
    public List<User> geAllData(){
        return ser.getData();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteVal(@PathVariable int id){
        return ser.deleteData(id);
    }
    @GetMapping("/getData/{id}")
    public User FindVal(@PathVariable int id){
        return ser.findData(id);
    }  
    @PutMapping("/put/{id}")
    public User UpdateData(@PathVariable int id,@RequestBody User stu){
            return ser.updateData(id,stu);
    }

}