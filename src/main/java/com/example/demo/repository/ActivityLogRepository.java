package com.example.demo.repository;
import com.example.demo.entity.ActivityLog;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog,Integer>{

}