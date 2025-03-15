package org.example.springsecuritydemo.controller;


import org.example.springsecuritydemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "satyajit", 26, 199),
            new Student(2, "vivek", 31, 223),
            new Student(3, "sakshi", 27, 233),
            new Student(4, "anurag", 23, 235)
    ));

    @GetMapping("/students")
    public List<Student> getUsers() {
        return students;
    }

}
