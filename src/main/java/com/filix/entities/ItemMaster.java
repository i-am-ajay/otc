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
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name=" XXFILIX_ITEM_MASTER_HDRS")
public class ItemMaster {
	
	@Id
	@GeneratedValue(generator="item_id_seq")
	private Integer id;
	
	private String itemCode;
	private String itemName;
	private String uom;
	private String hsn;
	private String taxCategory;
	private int minQty;
	private int maxQty;
	@Column(name="status")
	private boolean status;
	
	@CreationTimestamp
	private LocalDate startDate;
	private LocalDate endDate;
	
	private String createdBy;
	
	private String updatedBy;
	
	@UpdateTimestamp
	private LocalDate lastUpdateDate;
	
	@Transient
	private boolean itemChanged = false;
	
	@OneToMany(mappedBy="itemMasterLink", fetch=FetchType.EAGER)
	@Cascade(value = {CascadeType.SAVE_UPDATE, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH })
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ItemSubstitute> listSubstitutes = new ArrayList<>();
	
	@CreationTimestamp
	private LocalDate creationDate;
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getHsn() {
		return hsn;
	}
	public void setHsn(String hsn) {
		this.hsn = hsn;
	}
	public String getTaxCategory() {
		return taxCategory;
	}
	public void setTaxCategory(String taxCategory) {
		this.taxCategory = taxCategory;
	}
	public int getMinQty() {
		return minQty;
	}
	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}
	public int getMaxQty() {
		return maxQty;
	}
	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
		for(ItemSubstitute sub: this.listSubstitutes) {
			sub.setsEndDate(endDate);
		}
		this.endDate = endDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(LocalDate lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public int getId() {
		return id;
	}
	public List<ItemSubstitute> getListSubstitutes() {
		return listSubstitutes;
	}
	public void setListSubstitutes(List<ItemSubstitute> listSubstitutes) {
		this.listSubstitutes = listSubstitutes;
	}
	
	public void setItemChanged(boolean flag) {
		itemChanged = flag;
	}
	
	public boolean getItemChanged() {
		return itemChanged;
	}
	
	public void reinitializeItem(String user) {
		for(ItemSubstitute sub : listSubstitutes) {
			sub.reinitializeSubstitute(user);
		}
		this.id = null;
		this.creationDate = null;
		this.createdBy = user;
		this.endDate = null;
		this.startDate = null;
		this.lastUpdateDate = null;
	}
	
}
