package com.example.server.service;

import com.example.server.model.Gpa;
import org.springframework.http.HttpStatus;

public interface GpaService {
    Iterable<Gpa> getGpas();
    Gpa createGpa(Long id, Gpa gpa);
    Gpa updateGpa(Gpa gpa);
    HttpStatus deleteGpa(Long id);
}
