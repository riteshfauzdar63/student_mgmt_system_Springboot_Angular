package com.ritesh.my_first_app;

public class StudentRequestDTO {
    private String name;
    private String course;

    public StudentRequestDTO(){

    }

    public StudentRequestDTO(String name, String course){
        this.name = name;
        this.course = course;
    }

    public String getName(){
        return name;
    }

    public String getCourse(){
        return course;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCourse(String course){
        this.course = course;
    }

}
