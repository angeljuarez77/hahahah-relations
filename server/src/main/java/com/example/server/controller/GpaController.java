package com.example.server.controller;

import com.example.server.service.GpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpas")
public class GpaController {
    @Autowired
    GpaService gpaService;
}
