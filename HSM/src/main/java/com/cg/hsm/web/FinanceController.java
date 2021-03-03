package com.cg.hsm.web;
/**
 * This controller is used to perform operations between UI and Database
 * @author kethu_greeshma
 */
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hsm.domain.Finance;
import com.cg.hsm.service.FinanceService;
import com.cg.hsm.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

	@Autowired
	private FinanceService financeService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
   @PostMapping("/{patientIdentifier}")
   public ResponseEntity<?> createNewFinance(@PathVariable String patientIdentifier,@Valid @RequestBody Finance finance, BindingResult result) {
	   ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
	   Finance finan = financeService.saveOrUpdate(patientIdentifier, finance);
	   return new ResponseEntity<Finance>(finan, HttpStatus.OK);
	   
   }
   
   @GetMapping("/{patientIdentifier}")
	public ResponseEntity<?> getFinanceById(@PathVariable String patientIdentifier){
		Finance project = financeService.findByPatientId(patientIdentifier);
		return new ResponseEntity<Finance>(project, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Finance> getAllFinanceDetails(){
		return financeService.findAllFinanceDetails();
	}
	
	@DeleteMapping("/{patientIdentifier}")
	public ResponseEntity<?> deleteProject(@PathVariable String patientIdentifier) {
		financeService.deleteFinanceByFinanceId(patientIdentifier);
		return new ResponseEntity<String>("finance with id : "+patientIdentifier+" deleted successfully.",HttpStatus.OK);
	}
	
	@GetMapping("/getReport/{patientIdentifier}")
	public ResponseEntity<?> getPatientFinanceReport(@PathVariable String patientIdentifier) {
		List<String> report = financeService.getPatientFinanceDetails(patientIdentifier);
		return new ResponseEntity<List<String>>(report,HttpStatus.OK);
	}
	
}
