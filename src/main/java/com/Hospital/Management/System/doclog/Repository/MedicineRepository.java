package com.Hospital.Management.System.doclog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.doclog.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {

}
