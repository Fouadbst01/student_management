package com.example.student_management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String firstNamesutuatio;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50,nullable = false)
    private String Email;
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private boolean situation;

    public enum Gender {
        MALE,FEMALE
    }
}
