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
    public StudentDTO getStudent(@PathVariable int id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        return new StudentDTO(student.getId(), student.getName(), student.getCourse());
    }

//    Post - create
    @PostMapping("/students")
    public StudentDTO addStudent(@Valid @RequestBody StudentDTO dto){
        Student student = new Student(null, dto.getName(), dto.getCourse());
        Student save = studentRepository.save(student);
        return new StudentDTO(save.getId(), save.getName(), save.getCourse());
    }

//    Put- Update
    @PutMapping("/students/{id}")
    public StudentDTO updateStudent(@PathVariable int id, @Valid @RequestBody StudentDTO updated){
        Student existing = studentRepository.findById(id).orElse(null);
        if(existing != null){
           existing.setName(updated.getName());
           existing.setCourse(updated.getCourse());
           Student saved = studentRepository.save(existing);
           return new StudentDTO(saved.getId(), saved.getName(), saved.getCourse());
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
