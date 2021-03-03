package com.cg.hsm.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hsm.domain.Patient;
import com.cg.hsm.service.MapValidationErrorService;
import com.cg.hsm.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/patients")
	public ResponseEntity<?> createNewPatient(@Valid @RequestBody Patient patient ,  BindingResult result ) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Patient p= patientService.addPatient(patient); 
		return new ResponseEntity<Patient>(p,HttpStatus.CREATED);
	}
	@GetMapping("/patients/{patientId}")
	public Patient getPatientById(@PathVariable Long patientId){
		return patientService.findPatientById(patientId);
		//return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@GetMapping("/patients")
	public Iterable<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@DeleteMapping("/patients/{patientId}")
	public ResponseEntity<?> deletePatient(@PathVariable Long patientId) {
		patientService.deletePatientById(patientId);
		return new ResponseEntity<String>("Project with id : "+patientId+" deleted successfully.",HttpStatus.OK);
	}
	@PutMapping("/patients/{patientId}")
	public Patient updatePatientById(@PathVariable Long patientId){
		Patient patient1 = patientService.findPatientById(patientId);
		return patientService.updatePatient(patient1,patientId);
		//return new ResponseEntity<String>("Project with id : "+patientId+" Updated successfully.",HttpStatus.OK);
	}
}