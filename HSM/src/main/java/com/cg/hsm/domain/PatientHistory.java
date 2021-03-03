package com.cg.hsm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class will create patientHistory table in database and get all patient
 * history details
 * 
 * @author Y.K Sai Ramya
 *
 */

@Entity
@Table(name = "patienthistory")
public class PatientHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int patientHistoryId;

	private String diseaseName;

	@NotNull(message = "Patient blood group is required")
	@Column(nullable = false)

	private String bloodGroup;

	private String dietAdvised;

	private String treatmentStatus;

	private String histoyReports;

	// ManytoOne Mapping with patientCase

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)

	@JoinColumn(name = "patient_patientId", updatable = false, nullable = false)

	@JsonIgnore
	private Patient patients;

	@Column(updatable = false)

	private String patientIdentifier;

	// Getters and Setters

	public void setPatient(Patient patients) {
		this.patients = patients;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public int getPatientHistoryId() {
		return patientHistoryId;
	}

	public void setPatientHistoryId(int patientHistoryId) {
		this.patientHistoryId = patientHistoryId;
	}

	public String getPatientIdentifier() {
		return patientIdentifier;
	}

	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	@JsonBackReference
	public Patient getPatient() {
		return patients;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDietAdvised() {
		return dietAdvised;
	}

	public void setDietAdvised(String dietAdvised) {
		this.dietAdvised = dietAdvised;
	}

	public String getTreatmentStatus() {
		return treatmentStatus;
	}

	public void setTreatmentStatus(String treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}

	public String getHistoryReports() {
		return histoyReports;
	}

	public void setHistoryReports(String reports) {
		this.histoyReports = reports;
	}

}
