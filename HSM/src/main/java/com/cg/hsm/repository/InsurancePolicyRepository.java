package com.cg.hsm.repository;


/*
 * This interface creates a Insurance Policy repository of a patient
 * @author Diparna Biswas
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.hsm.domain.InsurancePolicy;

@Repository
public interface InsurancePolicyRepository extends CrudRepository<InsurancePolicy, Long> {

	static Object createPolicy(InsurancePolicy insurancepolicy) {
		// TODO Auto-generated method stub
		return null;
	}
	
}