package com.cg.hsm.serviceimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.Doctor;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.DoctorRepository;
import com.cg.hsm.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor findByUserName(String userName) {
		Doctor doctor = doctorRepository.findByUserName(userName.toUpperCase());
		if (doctor == null) {
			throw new HSMException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		return doctor;
	}


	@Override
	public Doctor saveDoctor(@Valid Doctor doctor) {
		return doctorRepository.save(doctor);
	}


	@Override
	public Doctor findByDoctorId(int doctorId) {
		Doctor doctor = doctorRepository.findByDoctorId(doctorId);
		if (doctor == null) {
			throw new HSMException("Doctor Id : " + doctorId + " does not exists");
		}
		return doctor;
	}


	@Override
	public Iterable<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}


	@Override
	public void deleteByDoctorId(int doctorId) {
		Doctor doctor = doctorRepository.findByDoctorId(doctorId);
		if (doctor == null) {
			throw new HSMException("User Name : " + doctorId + " does not exists");
		}
		doctorRepository.delete(doctor);
		
	}


	@Override
	public void updateDoctor(int doctorId, Doctor doctor) {
		doctorRepository.save(doctor);
	
	}

	
}
