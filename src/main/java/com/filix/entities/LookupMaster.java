package com.filix.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="XXFILIX_LOOKUP_MAS")
public class LookupMaster {
	@Id
	@GeneratedValue(generator="lookup_seq")
	private int id;
	
	@Column(name="LOOKUP_CODE",length=10)
	private String lookupCode;
	@Column(name="LOOKUP_NAME",length=100)
	private String lookupName;
	@Column(name="LOOKUP_MEANING",length=100)
	private String lookupMeaning;
	
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

	@OneToMany(mappedBy="lookupMaster",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.REFRESH, CascadeType.DELETE })
	private List<LookupDetails> lookupDetails = new ArrayList<LookupDetails>();
	
	
	public String getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public String getLookupMeaning() {
		return lookupMeaning;
	}

	public void setLookupMeaning(String lookupMeaning) {
		this.lookupMeaning = lookupMeaning;
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
	
	

	public List<LookupDetails> getLookupDetails() {
		return lookupDetails;
	}

	public void setLookupDetails(List<LookupDetails> lookupDetails) {
		this.lookupDetails = lookupDetails;
	}

	public LookupMaster(String lookupCode, String lookupName, String lookupMeaning) {
		super();
		this.lookupCode = lookupCode;
		this.lookupName = lookupName;
		this.lookupMeaning = lookupMeaning;
	}
	
	public LookupMaster() {
		
	}
	
	
	
}
