package com.example.student_management.repositories;

import com.example.student_management.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstNamesutuatioIsLike(String Name);
}
