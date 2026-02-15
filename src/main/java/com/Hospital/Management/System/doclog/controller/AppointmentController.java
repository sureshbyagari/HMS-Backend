package com.Hospital.Management.System.doclog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.Hospital.Management.System.doclog.Repository.AppointmentRepository;
import com.Hospital.Management.System.doclog.entity.Appointment;

@RestController
@RequestMapping("/api/Appointment")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
	@Autowired
	private AppointmentRepository appointmentRepository;
	@PostMapping("/CreateAppointment")    // http://localhost:8080/api/Appointment/CreateAppointment
	public Appointment CreateAppointment(@RequestBody Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	@GetMapping("/allAppointments")  //http://localhost:8080/api/Appointment/allAppointments
	public List<Appointment> getallAppointment(){
		return appointmentRepository.findAll();
	}
	@DeleteMapping("/DeleteAppointment/{id}")   //http://localhost:8080/api/Appointment/DeleteAppointment/
	public ResponseEntity<Map<String,Boolean>> DeleteAppointment(@PathVariable long id) throws AttributeNotFoundException{
		Appointment appointment=appointmentRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException(
		                "Appointment not exist with id : " + id));
		appointmentRepository.delete(appointment);
		
		 Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", true);
	        return ResponseEntity.ok(response);
	}
	@GetMapping("/getAppointmentById/{id}")  //http://localhost:8080/api/Appointment/getAppointmentById/
	private ResponseEntity<Appointment> getAppointmentById(@PathVariable long id) throws AttributeNotFoundException{
		Appointment appointment=appointmentRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException(
		                "Appointment not exist with id : " + id));
		return ResponseEntity.ok(appointment);
	}
	@PutMapping("/updateMedicine/{id}")  //http://localhost:8080/api/Appointment/updateMedicine/
	private ResponseEntity<Appointment> updateAppointment(@PathVariable long id,@RequestBody Appointment appointmentDetails) throws AttributeNotFoundException{
		Appointment appointment=appointmentRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException(
		                "Appointment not exist with id : " + id));
		appointment.setName(appointmentDetails.getName());
		appointment.setAge(appointmentDetails.getAge());
		appointment.setNumber(appointmentDetails.getNumber());
		appointment.setSymptoms(appointmentDetails.getSymptoms());
		Appointment updatedAppointment=appointmentRepository.save(appointment);
		return ResponseEntity.ok(updatedAppointment);
	}
	

}
