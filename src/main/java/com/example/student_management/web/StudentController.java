package com.example.student_management.web;

import com.example.student_management.entities.Student;
import com.example.student_management.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentRepository studentRepository;
    @GetMapping
    String studentView(){
        return "students";
    }
}
