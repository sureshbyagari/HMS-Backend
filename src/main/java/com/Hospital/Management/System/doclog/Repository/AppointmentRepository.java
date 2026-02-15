package com.Hospital.Management.System.doclog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.Management.System.doclog.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
