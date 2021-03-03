package com.cg.hsm.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hsm.domain.PatientHistory;
import com.cg.hsm.service.MapValidationErrorService;
import com.cg.hsm.service.PatientHistoryService;


@RestController
@RequestMapping("/api/patientHistory")

public class PatientHistoryController {
	@Autowired
	private PatientHistoryService patientHistoryService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("/{patientIdentifier}")
	public ResponseEntity<?> addPatientHistory( @PathVariable String patientIdentifier ,@Valid @RequestBody PatientHistory patientHistory,
			BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		PatientHistory patientHistory1 = patientHistoryService.addPatientHistory(patientIdentifier,patientHistory);
		return new ResponseEntity<PatientHistory>(patientHistory1, HttpStatus.OK);
	}

	@GetMapping("/getall/{patientIdentifier}")
	public ResponseEntity<List<PatientHistory>> getallPatientHistoryByIdentifier(
			@PathVariable String patientIdentifier) {
		List<PatientHistory> patientHistories = (List<PatientHistory>) patientHistoryService
				.findPatientHistoryByPatientIdentifier(patientIdentifier);
		return new ResponseEntity<List<PatientHistory>>(patientHistories, HttpStatus.OK);
	}
	@GetMapping("/get/{patientHistoryId}")
	public ResponseEntity<?> getPatientHistoryById(@PathVariable int patientHistoryId) {
				PatientHistory patientHistory1=patientHistoryService. findPatientHistoryByPatientHistoryId( patientHistoryId);
		return new ResponseEntity<PatientHistory>(patientHistory1, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<PatientHistory> getAllPatientHistoriess() {
		return patientHistoryService.getAllPatientHistories();
	}

}
