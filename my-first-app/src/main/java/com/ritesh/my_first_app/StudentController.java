package com.ritesh.my_first_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class StudentController {

    private final List<Student> students = new ArrayList<>();

//    get all
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return students;
    }

//    Get one by id
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

//    Post - create

}
