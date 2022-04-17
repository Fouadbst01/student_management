package com.example.student_management.web;

import com.example.student_management.entities.Student;
import com.example.student_management.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.LogRecord;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentRepository studentRepository;
    @GetMapping
    String studentView(Model model,
                       @RequestParam(name="page", defaultValue = "0") int page,
                       @RequestParam(name="size",defaultValue = "5") int size,
                       @RequestParam(name="keyword",defaultValue = "")String keyword){
        Page<Student> pageStudent = studentRepository.findByFirstNameStartingWith(keyword,PageRequest.of(page,size));
        model.addAttribute("pages",new int[pageStudent.getTotalPages()]);
        model.addAttribute("curentPage",page);
        model.addAttribute("studentList",pageStudent.getContent());
        model.addAttribute("keyword",keyword);
        return "students";
    }

    @GetMapping ("/add")
    String addStudentView(Model model){
        model.addAttribute("student",new Student());
        return "addStudent";
    }
    @PostMapping
    String addStudent(Student student){
        studentRepository.save(student);
        return "redirect:/students";
    }
}
