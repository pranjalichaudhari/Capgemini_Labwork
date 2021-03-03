package com.cg.hsm.web;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hsm.exception.RecordNotFoundException;
import com.cg.hsm.domain.InsurancePolicy;
import com.cg.hsm.service.InsurancePolicyService;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {

	@Autowired
	InsurancePolicyService service;
	
	@GetMapping("/policies")
	public List<InsurancePolicy> getAllPolicies() {
	    return service.getAllPolicies();
	}
	
	@PostMapping("/policies")
	public InsurancePolicy createPolicy(@Valid @RequestBody InsurancePolicy policy) throws RecordNotFoundException {
	    return service.createPolicy(policy);
	}
	
	@GetMapping("/policies/{id}")
	public InsurancePolicy getPolicyById(@PathVariable(value = "id") Long policyId) throws RecordNotFoundException {
	    return service.getPolicyById(policyId);
	}
	
	@PutMapping("/policies/{id}")
	public InsurancePolicy updatePolicy(@PathVariable(value = "id") Long policyId,
	                                        @Valid @RequestBody InsurancePolicy policyDetails) throws RecordNotFoundException {

	    return service.updatePolicy(policyId, policyDetails);
	}
	
	@DeleteMapping("/policies/{id}")
	public HttpStatus deletePolicy(@PathVariable(value = "id") Long policyId) throws RecordNotFoundException {
	  
		service.deletePolicyById(policyId);
        return HttpStatus.FORBIDDEN;
	}
}
