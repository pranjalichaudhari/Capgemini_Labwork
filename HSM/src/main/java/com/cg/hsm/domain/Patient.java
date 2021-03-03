package com.cg.hsm.domain;
/**
 *  this table has the information regarding patient with their case and history
 *  @ Jyothi , Samyuktha , Diparna , Ramya
 */
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Patient{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long patientId;
	
	
	@NotBlank(message = "Patient name is required")
	@Column(name = "Patient_Name", unique = true , updatable = false, nullable = false )
	private String patientName;	
	/**
	 * age of the patient
	 */
	@Column(name ="Patient_Age")
	private int patientAge;
	/**
	 * contact of the patient
	 */
	
	@Column(name = "Patient_Contact", nullable = false, length = 10)
	@NotNull(message = "Patient phone number is required")
	private long patientContact;
	/**
	 * address of the patient
	 */
	
	private String address;
	/**
	 *  symptoms of the patient
	 */
	
	private String symptoms;
	/**
	 * fee for the patient admission fee
	 */
	
	@Column(name = "Admission_Fee", nullable = false)
	@NotNull(message = "Patient admission Fee is required")
	private int admissionFee;
	
	/**
	 * time stamp of table
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_At;
	
	private String patientIdentifier;
	
	//one to one mapping with insurance policy
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
	@JoinColumn(name ="insurance_policy_id")
	private InsurancePolicy insurancepolicy;
	
	
	// getters and setters , to string , constructors
	public InsurancePolicy getInsurancepolicy() {
		return insurancepolicy;
	}
	public void setInsurancepolicy(InsurancePolicy insurancepolicy) {
		this.insurancepolicy = insurancepolicy;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public long getPatientContact() {
		return patientContact;
	}
	public void setPatientContact(long patientContact) {
		this.patientContact = patientContact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public int getAdmissionFee() {
		return admissionFee;
	}
	public void setAdmissionFee(int admissionFee) {
		this.admissionFee = admissionFee;
	}
	public Date getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	public Date getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	public String getPatientIdentifier() {
		return patientIdentifier;
	}
	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	@PrePersist
	public void onCreate() {
		this.created_At=new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updated_At=new Date();
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientContact=" + patientContact + ", address=" + address + ", symptoms=" + symptoms
				+ ", admissionFee=" + admissionFee + ", created_At=" + created_At + ", updated_At=" + updated_At
				+ ", patientIdentifier=" + patientIdentifier + ", insurancepolicy=" + insurancepolicy + "]";
	}
	public Patient(Long patientId, @NotBlank(message = "Patient name is required") String patientName,
			int patientAge, @NotNull(message = "Patient phone number is required") long patientContact, String address,
			String symptoms, @NotNull(message = "Patient admission Fee is required") int admissionFee, Date created_At,
			Date updated_At, String patientIdentifier, InsurancePolicy insurancepolicy) {
		super();
		
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientContact = patientContact;
		this.address = address;
		this.symptoms = symptoms;
		this.admissionFee = admissionFee;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.patientIdentifier = patientIdentifier;
		this.insurancepolicy = insurancepolicy;
	}
	public void setPatientHistories(List<PatientHistory> findByPatientIdentifier) {
		// TODO Auto-generated method stub
		
	}
	public void setPatientCases(PatientCase findByPatientIdentifier) {
		// TODO Auto-generated method stub
		
	}
	
	
}