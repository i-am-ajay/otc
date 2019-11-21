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
@Table(name="XXFILIX_EMPLOYEE_DEPENDENT_DTLS")
public class EmployeeDependent {
	@Id
	@GeneratedValue(generator="emp_master_seq")
	private int dependentId;
	
	@Column(name="dependent_name")
	private String dependentName;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="relationship")
	private String relationship;
	
	@Column(name="dependentDob")
	private LocalDate dependentDob;
	
	@Column(name="dependentStatus")
	private boolean dependentStatus;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
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
	@JoinColumn(name="emp_master_link")
	private EmployeeMaster empMasterLink;

	public int getDependentId() {
		return dependentId;
	}

	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}

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

	public void setDependentStatus(boolean dependentStatus) {
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

	public EmployeeMaster getEmpMasterLink() {
		return empMasterLink;
	}

	public void setEmpMasterLink(EmployeeMaster empMasterLink) {
		this.empMasterLink = empMasterLink;
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

	public EmployeeDependent(String dependentName, char gender, String relationship, LocalDate dependentDob,
			boolean dependentStatus) {
		super();
		this.dependentName = dependentName;
		this.gender = gender;
		this.relationship = relationship;
		this.dependentDob = dependentDob;
		this.dependentStatus = dependentStatus;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public EmployeeDependent() {}
	
	
}
