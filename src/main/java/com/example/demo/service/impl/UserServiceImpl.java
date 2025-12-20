package com.example.demo.service.impl;
import java.util.*;
import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepo;
import com.example.demo.entity.StudentEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Override;
@Service
public class StudentServiceImpl implements StudentService{
     @Autowired StudentRepo student;
     
          @Override
          public StudentEntity postData(StudentEntity stu){
               return student.save(stu);
          }
          @Override
          public List<StudentEntity> getData(){
               return student.findAll();
          }
          @Override
          public String deleteData(int id){
               student.deleteById(id);
               return "Delete Successfully!";
          }
          @Override
          public StudentEntity findData(int id){
               return student.findById(id).orElse(null);
          }
          @Override
          public StudentEntity updateData(int id,StudentEntity s){
               if(student.existsById(id)){
                    s.setId(id);
                    return student.save(s);
               }
               else{
                    return null;
               }
          }
}
package com.example.demo.repository;
import com.example.demo.entity.StudentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer>{

}
package com.example.demo.service;
import com.example.demo.entity.StudentEntity;
import java.util.*;
public interface StudentService{
    StudentEntity postData(StudentEntity stu);
    List<StudentEntity> getData();
    String deleteData(int id);
    StudentEntity findData(int id);
    StudentEntity updateData(int id,StudentEntity s);
}
