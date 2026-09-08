package com.ritesh.my_first_app;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int id) {
        super("student did not find with id: " +id);
    }
}
