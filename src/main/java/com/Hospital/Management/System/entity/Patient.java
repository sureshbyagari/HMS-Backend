package com.Hospital.Management.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
/*
 * @Data
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 */
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String blood;
    private String prescription;
    private String dose;
    private double fees;
    private String urgency;
    
	
	  
	  public long getId() { return id; }
	  
	  public void setId(long id) { this.id = id; }
	  
	  public String getName() { return name; }	  
	  
	  public void setName(String name) { this.name = name; }
	  
	  public int getAge() { return age; }
	   
	  public void setAge(int age) { this.age = age; }
	  
	  public String getBlood() { return blood; }
	  
	  public void setBlood(String blood) { this.blood = blood; }

	  public String getPrescription() { return prescription; }

	  public void setPrescription(String prescription) { this.prescription =
	  prescription; }

	  public String getDose() { return dose; }

	  public void setDose(String dose) { this.dose = dose; }
	  
	  
	  
	  public double getFees() { return fees; }
	  
	  
	  
	  public void setFees(double fees) { this.fees = fees; }
	  
	  
	  
	  public String getUrgency() { return urgency; }
	  
	  public void setUrgency(String urgency) { this.urgency = urgency; } public
	  Patient(String name, int age, String blood, String prescription, String dose,
	  double fees, String urgency) { this.name = name; this.age = age; this.blood =
	  blood; this.prescription = prescription; this.dose = dose; this.fees = fees;
	  this.urgency = urgency; }
	  
	  
	  public Patient() {}
	 

   
}
