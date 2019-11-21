package com.filix.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="XXFILIX_Patient_OTC")
public class PatientOtc {
	@Id
	@GeneratedValue(generator="patient_master_seq")
	private int id;
	
	@Column(name="registration_id")
	private String registrationId;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="consultant_code")
	private String consultantCode;
	
	@Column(name="consultant_name")
	private String consultantName;
	
	@Column(name="episode_number")
	private String episodeNumber;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="created_by")
	private Integer createdBy;
	
	@Column(name="updated_by")
	private Integer updatedBy;
	
	@CreationTimestamp
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="last_update_date")
	private LocalDate lastUpdateDate;

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getConsultantCode() {
		return consultantCode;
	}

	public void setConsultantCode(String consultantCode) {
		this.consultantCode = consultantCode;
	}

	public String getConsultantName() {
		return consultantName;
	}

	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}

	public String getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(String episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getId() {
		return id;
	}

	public PatientOtc(String registrationId, String patientName, char gender, String consultantCode,
			String consultantName, String episodeNumber) {
		super();
		this.registrationId = registrationId;
		this.patientName = patientName;
		this.gender = gender;
		this.consultantCode = consultantCode;
		this.consultantName = consultantName;
		this.episodeNumber = episodeNumber;
		this.startDate = LocalDate.now();
	}
	
	public PatientOtc() {}
	
	
	
	
	
}
