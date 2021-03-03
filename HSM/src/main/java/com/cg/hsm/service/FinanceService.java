package com.cg.hsm.service;
/**
 * This interface is used to perform Crud operations in Database
 * @author kethu_greeshma
 */
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.cg.hsm.domain.Finance;

public interface FinanceService{

	Finance saveOrUpdate(String patientIdentifier,Finance finance);
	Finance findByPatientId(String patientIdentifier);
	Iterable<Finance> findAllFinanceDetails();
	ResponseEntity<?> deleteFinanceByFinanceId(String patientIdentifier);
	List<String> getPatientFinanceDetails(String patientIdentifier);
}
