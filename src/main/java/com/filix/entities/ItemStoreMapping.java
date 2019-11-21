package com.filix.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "XXFILIX_ITEM_ASSIGNMENT")
public class ItemStoreMapping {
	@Id
	@GeneratedValue(generator="item_assignment_seq")
	private Integer id;
	@Column(name="ITEM_NAME")
	private String itemName;
	@Column(name="ITEM_CODE")
	private String itemCode;
	@Column(name="STORE_CODE")
	private String storeCode;
	@Column(name="STORE_NAME")
	private String storeName;
	@Column
	private boolean stauts;
	
	@Transient
	private boolean changedStatus;
	
	@CreationTimestamp
	@Column(name="START_DATE")
	private LocalDate startDate;
	@Column(name="END_DATE")
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public Integer getId() {
		return id;
	}

	public boolean isChangedStatus() {
		return changedStatus;
	}

	public void setChangedStatus(boolean changedStatus) {
		this.changedStatus = changedStatus;
	}

	public boolean isStauts() {
		return stauts;
	}
	public void setStauts(boolean stauts) {
		this.stauts = stauts;
	}
}
