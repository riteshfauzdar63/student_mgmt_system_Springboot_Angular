package com.ritesh.my_first_app;

public class Student {
    private int id;
    private String course;
    private String name;

    public Student(int id, String course, String name) {
        this.id = id;
        this.course = course;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
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
