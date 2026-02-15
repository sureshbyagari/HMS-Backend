package com.Hospital.Management.System.doclog.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.doclog.Repository.MedicineRepository;
import com.Hospital.Management.System.doclog.entity.Medicine;

	
@RestController
@RequestMapping("api/Medicine")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {
	@Autowired
	private MedicineRepository medicineRepository;
	@PostMapping("/CreateMedicine")    //http://localhost:8080/api/Medicine/CreateMedicine
	public Medicine CreateMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	@GetMapping("/allMedicines")  //http://localhost:8080/api/Medicine/allMedicines
	public List<Medicine> getallMedicines(){
		return medicineRepository.findAll();
	}
	@GetMapping("/getMedicineById/{id}")  //http://localhost:8080/api/Medicine/getMedicineById/
	private ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException{
		Medicine medicine=medicineRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException(
		                "Patient not exist with id : " + id));	
		return ResponseEntity.ok(medicine);
		}
	@PutMapping("/updateMedicine/{id}") //  http://localhost:8080/api/Medicine/updateMedicine/
	private ResponseEntity<Medicine> updataMedicine(@PathVariable long id,@RequestBody Medicine medicineDetals) throws AttributeNotFoundException{
		Medicine medicine=medicineRepository.findById(id)
				.orElseThrow(()-> new AttributeNotFoundException(
						"medicine not exist with id :"+id));
		medicine.setDrugName(medicineDetals.getDrugName());
		medicine.setStock(medicineDetals.getStock());
		Medicine updatedMedicine=medicineRepository.save(medicine);
		return ResponseEntity.ok(updatedMedicine);
	}

}
