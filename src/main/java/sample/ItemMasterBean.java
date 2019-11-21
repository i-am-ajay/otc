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

import com.filix.dao.ItemMasterDAO;
import com.filix.entities.ItemMaster;
import com.filix.entities.ItemSubstitute;

@SuppressWarnings("deprecation")
@ManagedBean(name="itemBean")
@SessionScoped

public class ItemMasterBean {

	private String itemCode;
	private String itemName;
	private List<ItemMaster> items;
	private List<ItemSubstitute> substituteList;
	
	private List<ItemMaster> oldItems;
	private int oldMin;
	private int oldMax;
	
	@Inject
	private ApplicationBean appBean;
	private ItemMaster selectedItem;
	

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
	
	public void getItemFromDb(){
		items = appBean.getMasterDao().getItems(itemCode, itemName);
		substituteList = null;
	}
	
	public List<ItemMaster> getItems(){
		return items;
	}
	
	public void saveItems() {
		substituteList = null;
		List<ItemMaster> listOfModifiedItems = new ArrayList<>();
		for(ItemMaster item: items) {
			if(item.getItemChanged()) {
				listOfModifiedItems.add(item);
			}
		}
		appBean.getMasterDao().saveItems(listOfModifiedItems, "ajay");
		getItemFromDb();
	}
	
	public void setSubstituteTable(SelectEvent event) {
		ItemMaster itemM = (ItemMaster)event.getObject();
		if(itemM != null) {
			substituteList = itemM.getListSubstitutes();
		}
	}
	
	public List<ItemSubstitute> getSubstituteList() {
		return this.substituteList;
	}
	public void setSubstituteList(List<ItemSubstitute> substituteList) {
		this.substituteList = substituteList;
	}
	
	public void clearSubstituteTable(UnselectEvent event) {
		substituteList = null;
	}
	
	public void setSelectedItem(ItemMaster master) {
		this.selectedItem = master;
	}
	public ItemMaster getSelectedItem() {
		return selectedItem;
	}
}