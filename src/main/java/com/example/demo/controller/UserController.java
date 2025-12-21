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
        return serviceUser.getAllUsers();
    }
    @GetMapping("/api/users/{id}")
    public User FindVal(@PathVariable int id){
        return serviceUser.getUser(id);
    }  
    @GetMapping("/api/users/{email}")
    public User UpdateData(@PathVariable String email){
            return serviceUser.getByEmail(email);
    }

}