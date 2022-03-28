package com.mishcma.springdemo.rest;

import com.mishcma.springdemo.entity.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Poornima", "Patel"));
        students.add(new Student("Maksym", "Mishchenko"));
        students.add(new Student("Artem", "Kozhokaru"));
        return students;
    }
}
