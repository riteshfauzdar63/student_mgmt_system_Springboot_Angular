package com.ritesh.my_first_app;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="Course is required")
    private String course;

    @NotBlank(message = "Name is required")
    private String name;

    public Student(){}

    public Student(Integer id, String course, String name) {
        this.id = id;
        this.course = course;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
