package com.ritesh.my_first_app;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentMapper studentDataMapper;
    public StudentController(StudentRepository studentRepository, StudentMapper studentDataMapper){
        this.studentRepository = studentRepository;
        this.studentDataMapper = studentDataMapper;
    }

//    private final List<Student> students = new ArrayList<>();

//    get all
    @GetMapping("/students")
    public List<StudentDTO> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List <StudentDTO> dtoList = new ArrayList<>();

        for(Student student : students){
            dtoList.add(new StudentDTO(student.getId(),student.getName(),student.getCourse()));
        }

        return dtoList;
    }

//    Get one by id
    @GetMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable int id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        return new StudentDTO(student.getId(), student.getName(), student.getCourse());
    }

//    Post - create
    @PostMapping("/students")
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentDTO dto){
//        Student student = new Student(null, dto.getName(), dto.getCourse());
        Student student = studentDataMapper.requestMapping(dto);
        Student save = studentRepository.save(student);
        return studentDataMapper.responseMapping(save);

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
