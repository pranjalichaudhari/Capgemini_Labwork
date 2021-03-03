package com.cg.hsm;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.hsm.exception.RecordNotFoundException;
import com.cg.hsm.domain.InsurancePolicy;
import com.cg.hsm.repository.InsurancePolicyRepository;
import com.cg.hsm.service.InsurancePolicyService;

 
@RunWith(SpringRunner.class)
@SpringBootTest

public class InsurancePolicyServiceTest {
	
	@Autowired
	private InsurancePolicyService insurancepolicyservice;
	
	@MockBean
	 private InsurancePolicyRepository insurancepolicyRepository;
	
	@Test
	public void createpolicyTest() throws RecordNotFoundException {
		InsurancePolicy insurancepolicy = new InsurancePolicy();
		insurancepolicy.setPolicyId((long) 3);
		insurancepolicy.setPolicyName("New Star Health");
		when(InsurancePolicyRepository.createPolicy(insurancepolicy)).thenReturn(insurancepolicy);
		assertEquals(insurancepolicy,insurancepolicyservice.createPolicy(insurancepolicy));	
}
}
