package com.example.server.service;

import com.example.server.model.Student;
import org.springframework.http.HttpStatus;

public interface StudentService {
    Iterable<Student> getStudents();
    Student createStudent(Student student);
    Student updateStudent(Student student);
    HttpStatus deleteStudent(Long id);
}
