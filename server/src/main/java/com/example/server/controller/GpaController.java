package com.example.server.controller;

import com.example.server.model.Gpa;
import com.example.server.service.GpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpas")
public class GpaController {
    @Autowired
    GpaService gpaService;

    @GetMapping
    public Iterable<Gpa> getGpas() {
        return gpaService.getGpas();
    }

    @PostMapping
    public Gpa createGpa(Gpa gpa) {
        return gpaService.createGpa(gpa);
    }
}
