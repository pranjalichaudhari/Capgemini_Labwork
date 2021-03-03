package com.cg.hsm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class will create patientHistory table in database and get all patient
 * history details
 * 
 * @author samyuktha
 *
 */
@Entity
@Table(name = "patientcase")
public class PatientCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * id of the patientCaseId
	 */
	private int patientCaseId;
	/**
	 * AssociatedDoctorName for Patient
	 */
	@Column(name = "associatedDoctorName", nullable = false)
	@NotBlank(message = "associatedDoctorName is required")
	private String associatedDoctorName;
	/**
	 * Medicine for Patient
	 */
	private String medicines;
	/**
	 * cost of the medicine
	 */
	private float medicineFee;
	/**
	 * reports of patient
	 */
	private String reports;
	/**
	 * current treatment given to patient
	 */

	private String currentTreatment;
	/**
	 * Detail description of disease
	 */
	
	private String diseaseDescription;
	// OnetoOne mapping with patient
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_patientId", nullable = false)
	@JsonIgnore
	private Patient patients;
	
	@Column(updatable = false)
	private String patientIdentifier;
     @JsonBackReference
	public Patient getPatient() {
		return patients;
	}
      
	public void setPatient(Patient patient) {
		this.patients = patient;
	}

	public String getPatientIdentifier() {
		return patientIdentifier;
	}

	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}

	public String getDiseaseDescription() {
		return diseaseDescription;
	}

	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}

	public String getAssociatedDoctorName() {
		return associatedDoctorName;
	}

	public void setAssociatedDoctorName(String associatedDoctorName) {
		this.associatedDoctorName = associatedDoctorName;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public float getMedicineFee() {
		return medicineFee;
	}

	public void setMedicineFee(float medicineFee) {
		this.medicineFee = medicineFee;
	}

	public String getReports() {
		return reports;
	}

	public void setReports(String reports) {
		this.reports = reports;
	}

	public String getCurrentTreatment() {
		return currentTreatment;
	}

	public void setCurrentTreatment(String currentTreatment) {
		this.currentTreatment = currentTreatment;
	}

	public int getPatientCaseId() {
		return patientCaseId;
	}

	public void setPatientCaseId(int patientCaseId) {
		this.patientCaseId = patientCaseId;
	}

}
