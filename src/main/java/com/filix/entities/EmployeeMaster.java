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

@FilterDef(name="emp_dependent_filter", parameters = @ParamDef(name="status", type="boolean"))
@Entity
@Table(name="XXFILIX_EMPLOYEE_MASTER_HDRS")
public class EmployeeMaster {
	@Id
	@GeneratedValue(generator="emp_master_seq")
	private int id;
	
	@Column(name="empoloyee_code")
	private String employeeCode;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="gender")
	private char gender;
	
	@Column(name="designation")
	private int designation;
	
	@Column(name="department")
	private int department;
	
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}

	@Column(name="dob")
	private LocalDate dob;
	
	@Column(name="doj")
	private LocalDate doj;
	
	@Column(name="dateOfLeaving")
	private LocalDate dateOfLeaving;
	
	@Column(name="active")
	private boolean active;
	
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
	
	@OneToMany(mappedBy="empMasterLink", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@Fetch(value=FetchMode.SUBSELECT)
	@Filter(name = "emp_dependent_filter", condition="dependentStatus = :status")
	private List<EmployeeDependent> listOfDependent = new ArrayList<>();
	
	public List<EmployeeDependent> getListOfDependent() {
		return listOfDependent;
	}
	public void setListOfDependent(List<EmployeeDependent> listOfDependent) {
		this.listOfDependent = listOfDependent;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public LocalDate getDateOfLeaving() {
		return dateOfLeaving;
	}
	public void setDateOfLeaving(LocalDate dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
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
	public EmployeeMaster(String employeeCode, String employeeName, char gender, int designation,int department, LocalDate dob,
			LocalDate doj, LocalDate dateOfLeaving, boolean active) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.gender = gender;
		this.designation = designation;
		this.department = department;
		this.dob = dob;
		this.doj = doj;
		this.dateOfLeaving = dateOfLeaving;
		this.active = active;
		this.startDate = LocalDate.now();
	}
	
	public EmployeeMaster() {}
	
	
}
