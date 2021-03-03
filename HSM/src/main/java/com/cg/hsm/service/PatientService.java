package com.cg.hsm.service;

import javax.validation.Valid;

import com.cg.hsm.domain.Patient;



public interface PatientService {
	
	public Patient addPatient(@Valid Patient patient);
	
	public Patient findPatientById(Long patientId);
	
	public Iterable<Patient> getAllPatients();
	
	public void deletePatientById(Long patientId);
	
	public Patient updatePatient(Patient patient1,Long patientId);
	
}
