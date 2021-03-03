package com.cg.hsm.domain;
/*
 * This Class(table) consists of Insurance Policy details of a patient*
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.*;

@Entity  
@Table(name = "insurance")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, 
        allowGetters = true)
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private Long policyId;
	/*
	 * this is the policy name
	 */
	@Column(name = "Policy_Name")
	@NotBlank(message = "Policy Name cannot be Blank")
	private String policyName;
	/*
	 * this is the time stamp of creation or update
	 */
	@Column(name = "Created_At")
	@Temporal(TemporalType.DATE)
    @CreatedDate
	private Date createdate;
	/*
	//one to one mapping with patient
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "insurancepolicy")
	@JoinColumn(name="patient_id")
	private Patient patient;*/
	
	// Getter Setters , constructors and to string methods

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	/*public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", createdate=" + createdate
				+ ", patient=" + patient + "]";
	}*/

	public InsurancePolicy(@NotNull Long policyId, @NotBlank(message = "Policy Name cannot be Blank") String policyName,
			Date createdate, Patient patient) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.createdate = createdate;
		//this.patient = patient;
	}

	public InsurancePolicy() {
		super();
		
	}
	


	
	
}