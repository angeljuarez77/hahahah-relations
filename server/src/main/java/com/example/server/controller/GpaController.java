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

    @PostMapping("/{studentId}")
    public Gpa createGpa(@PathVariable Long studentId, @RequestBody Gpa gpa) {
        return gpaService.createGpa(studentId, gpa);
    }

    @PatchMapping
    public Gpa updateGpa(@RequestBody Gpa gpa) {
        return gpaService.updateGpa(gpa);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteGpa(/* Nicole fixed this for me -> */ @PathVariable Long id) {
        return gpaService.deleteGpa(id);
    }
}
