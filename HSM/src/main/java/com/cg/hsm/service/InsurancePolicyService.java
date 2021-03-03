package com.cg.hsm.service;

import java.util.List;

import javax.validation.Valid;

import com.cg.hsm.domain.InsurancePolicy;

public interface InsurancePolicyService {
	List<InsurancePolicy> getAllPolicies();
	InsurancePolicy getPolicyById(Long id);

	InsurancePolicy createPolicy(InsurancePolicy policy);
	InsurancePolicy updatePolicy(Long policyId, @Valid InsurancePolicy policyDetails);
	void deletePolicyById(Long policyId);
}
