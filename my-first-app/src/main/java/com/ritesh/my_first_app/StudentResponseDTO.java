package com.ritesh.my_first_app;

public class StudentResponseDTO {
    private Integer id;
    private String name;
    private String course;

    public StudentResponseDTO(){

    }

    public Integer getId(){
        return id;
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

    public void setId(Integer id){
        this.id = id;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public StudentResponseDTO(Integer id, String name, String course){
        this.id = id;
        this.name = name;
        this.course = course;
    }
}
