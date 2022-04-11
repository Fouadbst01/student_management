package com.example.student_management;

import com.example.student_management.entities.Student;
import com.example.student_management.repositories.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{
            Faker faker = new Faker(Locale.FRENCH);
            for(int i=0;i<100;i++){
                Student.Gender g;
                g=Student.Gender.values()[faker.random().nextInt(2)];
                boolean stat=(faker.random().nextInt(2)!=0);
                studentRepository.save(new Student(null,faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress(),faker.date().birthday(), g,stat));
            }

            //studentRepository.save(new Student(null,"fouad","elbssita","email",new Date(),Student.Gender.MALE,true));
        };
    }

}
