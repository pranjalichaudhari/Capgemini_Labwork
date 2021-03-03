package com.cg.hsm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.Patient;
import com.cg.hsm.domain.PatientHistory;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.PatientHistoryRepository;
import com.cg.hsm.repository.PatientRepository;
import com.cg.hsm.service.PatientHistoryService;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService{
	@Autowired
	private PatientHistoryRepository patientHistoryRepositary;
	@Autowired
	private PatientRepository patientRepositary;

	public PatientHistory addPatientHistory( String patientIdentifier,PatientHistory patientHistory) {
		Patient patient=patientRepositary.findByPatientIdentifier(patientIdentifier);
		patientHistory.setPatient(patient);
		patientHistory.setPatientIdentifier(patientIdentifier);

		return patientHistoryRepositary.save(patientHistory);

	}
	public PatientHistory findPatientHistoryByPatientHistoryId(int patientHistoryId) {
		
		PatientHistory patientHistory=patientHistoryRepositary.findByPatientHistoryId(patientHistoryId);
		if(patientHistory==null) {
			throw new HSMException("Patient History not found");
		}
		return patientHistory;
	}

	public List<PatientHistory> findPatientHistoryByPatientIdentifier(String patientIdentifier) {
		
			List<PatientHistory>patientHistory=(List<PatientHistory>)patientHistoryRepositary.findByPatientIdentifier(patientIdentifier);
		if(patientHistory==null) {
			throw new HSMException("Patient History not found");
		}

		return (List<PatientHistory>) patientHistoryRepositary.findByPatientIdentifier(patientIdentifier);

	}

	public Iterable<PatientHistory> getAllPatientHistories() {

		return patientHistoryRepositary.findAll();
	}
	
	

}
