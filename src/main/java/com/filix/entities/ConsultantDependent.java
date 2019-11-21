package com.filix.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Immutable
@Table(name="XXFILIX_CONSULTANT_DEPENDENT_DTLS")
public class ConsultantDependent {
	@Id
	@GeneratedValue(generator = "consultant_master_seq")
	private int id;
	private String dependentName;
	private char gender;
	private String relationship;
	private LocalDate dependentDob;
	private boolean dependentStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Column(name="CREATED_BY")
	private Integer createdBy;
	@Column(name="UPDATED_BY")
	private Integer updatedBy;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name="LAST_UPDATE_DATE")
	private LocalDate lastUpdateDate;
	
	@ManyToOne
	@JoinColumn(name="consultant_master_mapping")
	private ConsultantMaster masterMapping;

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public LocalDate getDependentDob() {
		return dependentDob;
	}

	public void setDependentDob(LocalDate dependentDob) {
		this.dependentDob = dependentDob;
	}

	public boolean isDependentStatus() {
		return dependentStatus;
	}

	public void setdependentStatus(boolean dependentStatus) {
		this.dependentStatus = dependentStatus;
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

	public ConsultantMaster getMasterMapping() {
		return masterMapping;
	}

	public void setMasterMapping(ConsultantMaster masterMapping) {
		this.masterMapping = masterMapping;
	}

	public int getId() {
		return id;
	}

	public ConsultantDependent(String dependentName, char gender, String relationship, LocalDate dependentDob,
			boolean dependentStatus) {
		super();
		this.dependentName = dependentName;
		this.gender = gender;
		this.relationship = relationship;
		this.dependentDob = dependentDob;
		this.dependentStatus = dependentStatus;
		this.startDate = LocalDate.now();
	}
	public ConsultantDependent() {}
	
}
