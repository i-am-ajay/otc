package com.filix.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="XXFILIX_LOOKUP_DTL")
public class LookupDetails {
	@Id
	@GeneratedValue(generator="lookup_seq")
	private int id;
	
	private String lookupCode;
	private String value1;
	private String value2;
	private String vlaue3;
	private String value4;
	private String value5;
	
	@CreationTimestamp
	@Column(name="Start_Date")
	private LocalDate startDate;
	@Column(name="End_Date")
	private LocalDate endDate;
	
	@Column(name="CREATED_BY")
	private Integer createdBy;
	@Column(name="UPDATED_BY")
	private Integer updatedBy;
	
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate lastUpdateDate;
	
	@ManyToOne
	@JoinColumn(name="lookup_master_id_fk")
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.REFRESH, CascadeType.DETACH })
	private LookupMaster lookupMaster;

	public String getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getVlaue3() {
		return vlaue3;
	}

	public void setVlaue3(String vlaue3) {
		this.vlaue3 = vlaue3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
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

	public LookupMaster getLookupMaster() {
		return lookupMaster;
	}

	public void setLookupMaster(LookupMaster lookupMaster) {
		this.lookupMaster = lookupMaster;
	}

	public int getId() {
		return id;
	}

	public LookupDetails(String value1) {
		super();
		this.value1 = value1;
	}
	public LookupDetails() {
		
	}
	
	public LookupDetails(String value1, String value2) {
		super();
		this.value1 = value1;
		this.value2 = value2;
	}
	
}
