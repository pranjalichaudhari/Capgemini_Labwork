package com.cg.hsm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.Patient;
import com.cg.hsm.domain.PatientCase;

import com.cg.hsm.exception.HSMException;
import com.cg.hsm.repository.PatientCaseRepository;
import com.cg.hsm.repository.PatientRepository;
import com.cg.hsm.service.PatientCaseService;



@Service
public class PatientCaseServiceImpl implements PatientCaseService {
	
	@Autowired
	private  PatientCaseRepository patientCaseRepository;
	@Autowired
	private PatientRepository patientRepositary;
	
	public  PatientCase addPatientCase(String patientIdentifier,PatientCase patientcase) {
		Patient patient=patientRepositary.findByPatientIdentifier( patientIdentifier);
		patientcase.setPatient(patient);
		patientcase.setPatientIdentifier(patientIdentifier);
		
		return patientCaseRepository.save(patientcase);
		
	}
   
     public List<PatientCase> getAllPatientCases(){
    	
    	 return (List<PatientCase>) patientCaseRepository.findAll();
     }
     public List<PatientCase> getAllPatientDetailByDisease(String diseaseDescription){
    	 
    	 return (List<PatientCase>) patientCaseRepository.findPatientByDiseaseDescription( diseaseDescription);
     }
     
	@Override
	public PatientCase findPatientByPatientId(String patientIdentifier) {
		PatientCase patientCase=patientCaseRepository.findByPatientIdentifier(patientIdentifier);
		if(patientCase==null) {
			throw new HSMException("Patient Case not found");
		}

		return  patientCaseRepository.findByPatientIdentifier(patientIdentifier);

	}

	

	
	

}