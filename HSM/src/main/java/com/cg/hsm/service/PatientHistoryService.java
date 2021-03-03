package com.cg.hsm.service;

import java.util.List;


import com.cg.hsm.domain.PatientHistory;

public interface PatientHistoryService {
	public PatientHistory addPatientHistory( String patientIdentifier,PatientHistory patientHistory);
	
	 public List<PatientHistory> findPatientHistoryByPatientIdentifier(String patientIdentifier);
	 public PatientHistory findPatientHistoryByPatientHistoryId(int patientHistoryId);
	 public Iterable<PatientHistory> getAllPatientHistories();
	
}
