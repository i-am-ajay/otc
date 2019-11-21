package com.filix.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Immutable
@Table(name="XXFILIX_CONSULTANT_MASTER_HDRS")
@FilterDef(name="consultant_dependent_filter",parameters= {
		@ParamDef(name="status", type="boolean")
})
public class ConsultantMaster {
	@Id
	@GeneratedValue(generator="consultant_master_seq")
	private int id;
	@Column(name="consultant_code")
	private String consultantCode;
	
	@Column(name="consultant_name")
	private String consultantName;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="designation")
	private int designation;
	
	@Column(name="department")
	private int department;
	
	@Column(name="unit")
	private int unit;
	
	@Column(name="doj")
	private LocalDate doj;
	
	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@OneToMany(mappedBy="masterMapping", fetch = FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	@Cascade(value= {CascadeType.SAVE_UPDATE})
	@Filter(name="consultant_dependent_filter", condition="dependentStatus = :status")
	private List<ConsultantDependent> consultantDependets = new ArrayList<>();
	
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getDesignation() {
		return designation;
	}

	public void setDesignation(int designation) {
		this.designation = designation;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public int getId() {
		return id;
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

	public List<ConsultantDependent> getConsultantDependets() {
		return consultantDependets;
	}

	public void setConsultantDependets(List<ConsultantDependent> consultantDependets) {
		this.consultantDependets = consultantDependets;
	}

	public ConsultantMaster(String consultantCode, String consultantName, char gender, int designation,
			int department, int unit, LocalDate doj, LocalDate dob, boolean active) {
		super();
		this.consultantCode = consultantCode;
		this.consultantName = consultantName;
		this.gender = gender;
		this.designation = designation;
		this.department = department;
		this.unit = unit;
		this.doj = doj;
		this.dob = dob;
		this.active = active;
		this.startDate = LocalDate.now();
	}
	
	public ConsultantMaster() {}
	
	
	
}
