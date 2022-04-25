package com.example.student_management.web;

import com.example.student_management.configuration.entities.User;
import com.example.student_management.configuration.repositories.UserRepository;
import com.example.student_management.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    UserRepository userRepository;

    @GetMapping
    String getALLUser(Model model,
                      @RequestParam(name="page", defaultValue = "0") int page,
                      @RequestParam(name="size",defaultValue = "5") int size,
                      @RequestParam(name="keyword",defaultValue = "")String keyword){
        Page<User> pageUser = userRepository.findUserByUserNameStartingWith(keyword, PageRequest.of(page,size));
        model.addAttribute("pages",new int[pageUser.getTotalPages()]);
        model.addAttribute("curentPage",page);
        model.addAttribute("users",pageUser.getContent());
        model.addAttribute("keyword",keyword);
        return "users";
    }

}
