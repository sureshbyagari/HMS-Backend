package com.Hospital.Management.System.doclog.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    @GetMapping("/dashboard")
    public String doctorDashboard() {
        return "Welcome Doctor!";
    }
}