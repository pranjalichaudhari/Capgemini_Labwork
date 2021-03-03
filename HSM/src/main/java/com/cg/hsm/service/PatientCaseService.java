package com.cg.hsm.service;

import java.util.List;

import com.cg.hsm.domain.PatientCase;



public interface PatientCaseService {
	public  PatientCase addPatientCase(String patientidentifier,PatientCase patientcase);
	 public List<PatientCase> getAllPatientCases();
	public PatientCase findPatientByPatientId(String patientIdentifier);
	 public List<PatientCase>getAllPatientDetailByDisease(String diseaseDescription);
	//public PatientCase findPatientCaseByPatientIdentifier(String patientIdentifier);
	 
}

