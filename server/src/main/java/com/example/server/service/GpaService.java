package com.example.server.service;

import com.example.server.model.Gpa;
import org.springframework.http.HttpStatus;

public interface GpaService {
    Iterable<Gpa> getGpas();
    Gpa createGpa();
    Gpa updateGpa();
    HttpStatus deleteGpa();
}
