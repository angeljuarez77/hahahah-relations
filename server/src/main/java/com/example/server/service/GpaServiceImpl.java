package com.example.server.service;

import com.example.server.model.Gpa;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GpaServiceImpl implements GpaService {
    @Override
    public Iterable<Gpa> getGpas() {
        return null;
    }

    @Override
    public Gpa createGpa() {
        return null;
    }

    @Override
    public Gpa updateGpa() {
        return null;
    }

    @Override
    public HttpStatus deleteGpa() {
        return null;
    }
}
