package com.example.student_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String Email;
    private Date birthDay;
    private String Gender;
    private boolean situation;
}
