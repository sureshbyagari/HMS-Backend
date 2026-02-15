package com.Hospital.Management.System.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	@PostMapping("/addPatient")    //   http://localhost:8080/api/patient/addPatient
	public Patient CreatePatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	@GetMapping("/allPatients")    //http://localhost:8080/api/patient/allPatients
	public List<Patient> listofPatients(){
		return patientRepository.findAll();
		
	}
	@DeleteMapping("/DeletePatient/{id}")  //http://localhost:8080/api/patient/DeletePatient/
	public ResponseEntity<Map<String,Boolean>> deletePatien(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient=patientRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException(
		                "Patient not exist with id : " + id));
		patientRepository.delete(patient);
		
		
		 Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", true);
	        return ResponseEntity.ok(response);
	}
	@GetMapping("/getPatientById/{id}")   //http://localhost:8080?api/patient/getPatientById/
	private ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient=patientRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException(
		                "Patient not exist with id : " + id));
		return ResponseEntity.ok(patient);
	}
	
	
	@PutMapping("/UpdatePatient/{id}")   //http://localhost:8080/api/patient/UpdatePatient/
	public ResponseEntity<Patient> UpdatePatientById(@PathVariable long id, @RequestBody Patient patientdetails) throws AttributeNotFoundException{
		Patient patient=patientRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException(
		                "Patient not exist with id : " + id));
		patient.setName(patientdetails.getName());
		patient.setAge(patientdetails.getAge());
		patient.setBlood(patientdetails.getBlood());
		patient.setPrescription(patientdetails.getPrescription());
		patient.setDose(patientdetails.getDose());
		patient.setFees(patientdetails.getFees());
		patient.setUrgency(patientdetails.getUrgency());
		//patient.setId(patientdetails.getId());
		
		Patient savedpatient=patientRepository.save(patient);
		
		return ResponseEntity.ok(savedpatient);
	}

}
