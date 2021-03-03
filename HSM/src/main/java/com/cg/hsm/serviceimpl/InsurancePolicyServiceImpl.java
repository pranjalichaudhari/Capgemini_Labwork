package com.cg.hsm.serviceimpl;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.hsm.exception.HSMException;
import com.cg.hsm.domain.InsurancePolicy;
import com.cg.hsm.repository.InsurancePolicyRepository;
import com.cg.hsm.service.InsurancePolicyService;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService  {
	
	@Autowired
    private InsurancePolicyRepository repository;
     
    public List<InsurancePolicy> getAllPolicies()
    {
        List<InsurancePolicy> policyList = (List<InsurancePolicy>) repository.findAll();
         
        if(policyList.size() > 0) {
            return policyList;
        } else {
            return null;
        }
    }
     
    public InsurancePolicy getPolicyById(Long id) throws HSMException 
    {
        Optional<InsurancePolicy> policy = repository.findById(id);
         
        if(policy.isPresent()) {
            return policy.get();
        } else {
            throw new HSMException("No employee record exist for given id");
        }
    }
     
    public InsurancePolicy createPolicy(InsurancePolicy policy) throws HSMException 
    {
    	return repository.save(policy);
    } 
     
    public void deletePolicyById(Long id) throws HSMException 
    {
        Optional<InsurancePolicy> policy = repository.findById(id);
         
        if(policy.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new HSMException("No employee record exist for given id");
        }
    }

	public InsurancePolicy updatePolicy(Long policyId, @Valid InsurancePolicy policyDetails)  throws HSMException {
		// TODO Auto-generated method stub
		Optional<InsurancePolicy> policy = repository.findById(policyId);
		
		if(policy.isPresent()) 
        {
            InsurancePolicy newEntity = policy.get();
            newEntity.setPolicyName(policyDetails.getPolicyName());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        }

		else {
			throw new HSMException("No employee record exist for given id");
		}
	}




}

