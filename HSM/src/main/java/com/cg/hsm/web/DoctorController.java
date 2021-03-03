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

import com.cg.hsm.domain.Doctor;
import com.cg.hsm.serviceimpl.DoctorServiceImpl;
import com.cg.hsm.service.MapValidationErrorService;

@RestController 
@RequestMapping("/api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorServiceImpl doctorServiceImpl;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@PostMapping("/add")
	   public ResponseEntity<?> createNewDoctor(@Valid @RequestBody Doctor doctor,BindingResult result)
	   {
		   ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		   if(errorMap != null)
			   return errorMap;
		   Doctor doc= doctorServiceImpl.saveDoctor(doctor);
		   return new ResponseEntity<Doctor>(doc,HttpStatus.OK);
	   }
	
	@GetMapping("/{doctorId}")
	public ResponseEntity<?> getProjectById(@PathVariable int doctorId){
		Doctor doctor = doctorServiceImpl.findByDoctorId(doctorId);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	@DeleteMapping("/{doctorId}")
	public ResponseEntity<?> deleteDoctor(@PathVariable int doctorId) {
		   doctorServiceImpl.deleteByDoctorId(doctorId);
		return new ResponseEntity<String>("Doctor with : "+doctorId+" deleted successfully.",HttpStatus.OK);
	}
	
	@PutMapping("/{doctorId}")
	public void updateByDoctorId(@Valid @RequestBody Doctor doctor ,@PathVariable int doctorId)
	{
		doctorServiceImpl.updateDoctor(doctorId,doctor);
	}
}


