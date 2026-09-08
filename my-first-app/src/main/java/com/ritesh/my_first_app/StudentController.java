package com.ritesh.my_first_app;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

//    private final List<Student> students = new ArrayList<>();

//    get all
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

//    Get one by id
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

//    Post - create
    @PostMapping("/students")
    public Student addStudent(@Valid @RequestBody Student student){
        return studentRepository.save(student);
    }

//    Put- Update
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updated){
        Student existing = studentRepository.findById(id).orElse(null);
        if(existing != null){
           existing.setName(updated.getName());
           existing.setCourse(updated.getCourse());
           return studentRepository.save(existing);
        }

        return null;
    }

//    delete student
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentRepository.deleteById(id);
        return "Deleted student with id " + id ;
    }
}
