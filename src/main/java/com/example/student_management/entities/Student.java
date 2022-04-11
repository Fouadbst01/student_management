package com.example.student_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String firstNamesutuatio;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50,unique = true,nullable = false)
    private String Email;
    private Date birthDay;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private boolean situation;

    private enum Gender {
        MALE,FEMALE
    }
}
