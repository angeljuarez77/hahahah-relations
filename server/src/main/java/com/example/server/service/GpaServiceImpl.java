package com.example.server.service;

import com.example.server.model.Gpa;
import com.example.server.model.Student;
import com.example.server.repository.GpaRepository;
import com.example.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GpaServiceImpl implements GpaService {

    @Autowired
    StudentService studentService;

    @Autowired
    GpaRepository gpaRepository;

    @Override
    public Iterable<Gpa> getGpas() {
        return gpaRepository.findAll();
    }

    @Override
    public Gpa createGpa(Long id, Gpa gpa) {
        Student student = studentService.getStudentById(id);
        student.setGpa(gpa);
        return studentService.updateStudent(student).getGpa();
    }

    @Override
    public Gpa updateGpa(Gpa gpa) {
        return gpaRepository.save(gpa);
    }

    @Override
    public HttpStatus deleteGpa(Long id) {
        gpaRepository.deleteById(id);
        return HttpStatus.OK;
    }

}
