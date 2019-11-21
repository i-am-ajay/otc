package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.event.AbstractAjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.filix.dao.ItemMappingDAO;
import com.filix.entities.ItemMaster;
import com.filix.entities.ItemStoreMapping;
import com.filix.entities.ItemSubstitute;

@SuppressWarnings("deprecation")
@ManagedBean(name = "itemMapping")
@SessionScoped

public class ItemMappingBean {

	private String itemCode;
	private String itemName;
	private String storeCode;
	private String storeName;
	
	@Inject
	private ApplicationBean appBean;
	
	private List<ItemStoreMapping> itemStoreMappingList = new ArrayList<>();
	
	// getter setters
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
	
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreCode() {
		return this.storeCode;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreName() {
		return this.storeName;
	}
	
	public List<ItemStoreMapping> getItemStoreMappingList() {
		return itemStoreMappingList;
	}
	public void setItemStoreMappingList(List<ItemStoreMapping> itemStoreMappingList) {
		this.itemStoreMappingList = itemStoreMappingList;
	}
	
	
	// find selected store time mapping
	public void addItemToMappingList() {
		if(this.itemCode != null && this.itemName != null && this.storeCode != null && this.storeName != null) {
			ItemStoreMapping mapping = new ItemStoreMapping();
			mapping.setItemCode(itemCode);
			mapping.setItemName(itemName);
			mapping.setStoreCode(storeCode);
			mapping.setStoreName(storeName);
			mapping.setStartDate(LocalDate.now());
			mapping.setChangedStatus(true);
			this.itemStoreMappingList.add(mapping);
		}
		itemCode = null;
		itemName = null;
		storeName = null;
		storeCode = null;
	}
	
	public void searchItemStoreMapping() {
		this.itemStoreMappingList = this.appBean.getMappingDao().itemStoreMapping(this.itemCode, this.itemName, this.storeCode, this.storeName);
		itemCode = null;
		itemName = null;
		storeCode = null;
		storeName = null;
	}
	
	public void saveUpdateItemStoreMapping() {
		for(ItemStoreMapping mapping : itemStoreMappingList) {
			if(mapping.isChangedStatus()) {
				if(mapping.getId() != null) {
					mapping.setUpdatedBy(1);
				}
				else {
					mapping.setCreatedBy(1);
				}
				this.appBean.getMappingDao().saveUpdate(mapping);
			}
			mapping.setChangedStatus(false);
		}
	}
	// get list of all active item codes
	public List<String> itemCodesList() {
		return this.appBean.getMasterDao().itemCodeList();
	}
	public List<String> itemNameList(){
		return this.appBean.getMasterDao().itemNameList();
	}
	// get selected item desc or code
	public void selectedItemDesc() {
		this.itemName = this.appBean.getMasterDao().selectedItemName(itemCode);
	}
	public void selectedItemCode() {
		this.itemCode = this.appBean.getMasterDao().selectedItemCode(itemName);
	}
	
	// store lookup
	public void selectedStoreCode() {
		this.storeCode = this.appBean.getMappingDao().selectedStoreCode(storeName);
	}
	public void selectedStoreName() {
		this.storeName = this.appBean.getMappingDao().selectedStoreName(storeCode);
	}
	
	public List<String> storeCodeList() {
		return this.appBean.getMappingDao().storeCodeList();
	}
	public List<String> storeNameList() {
		return this.appBean.getMappingDao().storeNameList();
	}
	
	
	/*
	public Converter convertToLocalDate() {
		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context, UIComponent component, String value) {
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate date = LocalDate.parse(value,formatter);
				return date;
			}

			@Override
			public String getAsString(FacesContext context, UIComponent component, Object date) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = (LocalDate)date;
				return localDate.format(formatter);
			}
			
		};
		
	} */
}