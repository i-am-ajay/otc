package com.filix.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "XXFILIX_ITEM_SUBSTITUTE_DTLS")
public class ItemSubstitute {
	@Id
	@GeneratedValue(generator = "item_id_seq")
	@Column(name="Substitue_Item_id")
	private Integer sId;
	
	@Column(name="Substitute_Item_Code")
	private String sItemCode;
	@Column(name="Substitute_Item_Name")
	private String sItemName;
	@Column(name="Substitute_Item_Uom")
	private String sItemUom;
	
	@CreationTimestamp
	@Column(name="Substitute_start_date")
	private LocalDate sStartDate;
	
	@Column(name="substitute_end_date")
	private LocalDate sEndDate;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumns(value = { @JoinColumn(name="substitue_for_item") })
	private ItemMaster itemMasterLink;
	
	
	private String createdBy;
	
	private String updatedBy;
	
	@UpdateTimestamp
	private LocalDate lastUpdateDate;
	
	@CreationTimestamp
	private LocalDate creationDate;

	public String getsItemCode() {
		return sItemCode;
	}

	public void setsItemCode(String sItemCode) {
		this.sItemCode = sItemCode;
	}

	public String getsItemName() {
		return sItemName;
	}

	public void setsItemName(String sItemName) {
		this.sItemName = sItemName;
	}

	public String getsItemUom() {
		return sItemUom;
	}

	public void setsItemUom(String sItemUom) {
		this.sItemUom = sItemUom;
	}

	public LocalDate getsStartDate() {
		return sStartDate;
	}

	public void setsStartDate(LocalDate sStartDate) {
		this.sStartDate = sStartDate;
	}

	public LocalDate getsEndDate() {
		return sEndDate;
	}

	public void setsEndDate(LocalDate sEndDate) {
		this.sEndDate = sEndDate;
	}

	public ItemMaster getItemMasterLink() {
		return itemMasterLink;
	}

	public void setItemMasterLink(ItemMaster itemMasterLink) {
		this.itemMasterLink = itemMasterLink;
	}


	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public int getsId() {
		return sId;
	}
	
	public void reinitializeSubstitute(String user) {
		this.sId = null;
		this.creationDate = null;
		this.sStartDate = null;
		this.createdBy = user;
		this.sEndDate = null;
		this.lastUpdateDate = null;
	}
}
