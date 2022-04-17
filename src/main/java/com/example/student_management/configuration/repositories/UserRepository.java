package com.example.student_management.configuration.repositories;

import com.example.student_management.configuration.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User getUserByUserName(String name);
}
