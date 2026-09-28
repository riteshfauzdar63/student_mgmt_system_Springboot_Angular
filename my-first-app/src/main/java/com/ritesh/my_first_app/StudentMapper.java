package com.ritesh.my_first_app;

import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student requestMapping(StudentDTO dto){
        Student student = new Student();
        student.setName(dto.getName());
        student.setCourse(dto.getCourse());
        return student;
    }

    public StudentResponseDTO responseMapping(Student student){
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setCourse(student.getCourse());
        return dto;
    }
}
