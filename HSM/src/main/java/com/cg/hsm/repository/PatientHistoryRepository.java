package com.cg.hsm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.domain.PatientHistory;

@Repository
public interface PatientHistoryRepository extends CrudRepository<PatientHistory, Integer> {
	List<PatientHistory> findByPatientIdentifier(String patientIdentifier);

	PatientHistory findByPatientHistoryId(int patientHistoryId);

}