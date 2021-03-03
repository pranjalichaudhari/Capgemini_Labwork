package com.cg.hsm.serviceimpl;
/**
 * This class is used to implement crud operations in Finance Database
 * @author kethu_greeshma
 */
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.Doctor;
import com.cg.hsm.domain.Finance;
import com.cg.hsm.domain.Patient;
import com.cg.hsm.domain.PatientCase;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.DoctorRepository;
import com.cg.hsm.repository.FinanceRepository;
import com.cg.hsm.repository.PatientCaseRepository;
import com.cg.hsm.repository.PatientRepository;
import com.cg.hsm.service.FinanceService;

@Service
public class FinanceServiceImpl implements FinanceService{

	@Autowired
	private FinanceRepository financeRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private PatientCaseRepository patientCaseRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Finance saveOrUpdate(String patientIdentifier,Finance finance) {
		
		Patient patient=patientRepository.findByPatientIdentifier(patientIdentifier);
		PatientCase patientCase = patientCaseRepository.findByPatientIdentifier(patientIdentifier);
		String doctorName = patientCase.getAssociatedDoctorName();
		Doctor doctor = doctorRepository.findByUserName(doctorName);
		finance.setPatientName(patient.getPatientName());
		finance.setPatientIdentifier(patientIdentifier);
		finance.setRegistrationFee(patient.getAdmissionFee());
		finance.setMedicinesAmount(patientCase.getMedicineFee());
		finance.setDoctorFee(doctor.getDoctorFee());
		finance.setTotalFee(patient.getAdmissionFee()+patientCase.getMedicineFee()+doctor.getDoctorFee());
		try {
			return financeRepository.save(finance);
		}catch(Exception e) {
			throw new HSMException("Patient id :"+patientIdentifier+" already exists");
		}
	}
	
	
	public Finance findByPatientId(String patientIdentifier) {
		Finance finance = financeRepository.findByPatientIdentifier(patientIdentifier);
		if(finance==null) {
			throw new HSMException("Patient id :"+patientIdentifier +" not exists");
		}
		return finance;
	}

	public Iterable<Finance> findAllFinanceDetails() {
		return financeRepository.findAll();
	}

	public ResponseEntity<?> deleteFinanceByFinanceId(String patientIdentifier) {
		Finance finance = financeRepository.findByPatientIdentifier(patientIdentifier);
		financeRepository.delete(finance);
		return new ResponseEntity<String>("Finance details of patient with id : "+patientIdentifier+" is successfully deleted",HttpStatus.OK);
		
	}
	
	public List<String> getPatientFinanceDetails(String patientIdentifier) {
		Finance fin = financeRepository.findByPatientIdentifier(patientIdentifier);
		List<String> report = new ArrayList<>();
		report.add("Patient name is: "+fin.getPatientName());
		report.add("Patient Id is : "+fin.getPatientIdentifier());
		report.add("Admission Fee for the patient "+fin.getPatientName()+" is "+fin.getRegistrationFee());
		report.add("Doctor Fee for the patient "+fin.getPatientName()+" is "+fin.getDoctorFee());
		report.add("Medicines Amount for the patient "+fin.getPatientName()+" is "+fin.getMedicinesAmount());
		report.add("Total Fee for the patient "+fin.getPatientName()+" is "+fin.getTotalFee());
		return report;
		
	}
}
