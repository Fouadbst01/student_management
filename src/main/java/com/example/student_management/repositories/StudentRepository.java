package com.example.student_management.repositories;

import com.example.student_management.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //List<Student> findByFirstNamesutuatioIsLike(String Name);
}
