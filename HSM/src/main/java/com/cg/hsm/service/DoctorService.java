package com.cg.hsm.service;

import javax.validation.Valid;

import com.cg.hsm.domain.Doctor;

public interface DoctorService {
	
public Doctor saveDoctor(@Valid Doctor doctor);
	
	public Doctor findByDoctorId(int doctorId);
	
	public Iterable<Doctor> getAllDoctors();
	
	public void deleteByDoctorId(int doctorId);
	
	public void updateDoctor(int doctorId,Doctor doctor);


}
