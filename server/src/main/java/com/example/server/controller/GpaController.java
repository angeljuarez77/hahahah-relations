package com.example.server.controller;

import com.example.server.model.Gpa;
import com.example.server.service.GpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Gpa createGpa(@RequestBody Gpa gpa) {
        return gpaService.createGpa(gpa);
    }

    @PatchMapping
    public Gpa updateGpa(@RequestBody Gpa gpa) {
        return gpaService.updateGpa(gpa);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteGpa(@PathVariable Long id) {
        return gpaService.deleteGpa(id);
    }
}
