package com.example.student_management.web;

import com.example.student_management.entities.Student;
import com.example.student_management.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentRepository studentRepository;
    @GetMapping
    String studentView(Model model,
                       @RequestParam(name="page", defaultValue = "0") int page,
                       @RequestParam(name="size",defaultValue = "5") int size){
        Page<Student> pageStudent = studentRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("pages",new int[pageStudent.getTotalPages()]);
        model.addAttribute("curentPage",page);
        model.addAttribute("studentList",pageStudent.getContent());
        return "students";
    }
}
