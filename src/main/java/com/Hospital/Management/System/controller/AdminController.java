package com.Hospital.Management.System.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome Admin!";
    }
}