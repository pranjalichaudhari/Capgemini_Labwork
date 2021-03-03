package com.cg.hsm.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.domain.Patient;


@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>
{

	
	
	Patient findByPatientIdentifier(String patientIdentifier);
	Patient findByPatientId(Long patientId);
	
}
