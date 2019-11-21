package com.filix.dao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.filix.entities.ItemMaster;
import com.filix.entities.ItemStoreMapping;
import com.filix.entities.ItemSubstitute;
import com.filix.entities.LookupDetails;
import com.filix.entities.LookupMaster;

@Named
public class ItemMappingDAO {
	
	@Inject
	AppSessionFactory factoryCreator;
	
	/*
	public List<ItemMaster> getItems(String itemCode, String itemName) {
		List<Predicate> predicateList = new ArrayList<>();
		List<ItemMaster> itemLists = null;
		Session session = factory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemMaster> criteriaQuery = builder.createQuery(ItemMaster.class);
		Root<ItemMaster> root = criteriaQuery.from(ItemMaster.class);
		itemCode = itemCode.trim();
		itemName = itemName.trim();
		if(itemCode != null && itemCode.length()>0) {
			predicateList.add(builder.equal(root.get("itemCode"), itemCode));
		}
		if(itemName != null && itemName.length() > 0) {
			predicateList.add(builder.like(root.get("itemName"), "%".concat(itemName).concat("%")));
		}
		// check if list has some predicate.
		if(predicateList.size() > 0) {
			session.beginTransaction();
			criteriaQuery.select(root).where(builder.and(predicateList.toArray(new Predicate[predicateList.size()])));
			Query<ItemMaster> itemQuery = session.createQuery(criteriaQuery);
			itemLists = itemQuery.getResultList();
			//System.out.println("Size of result set "+itemLists.size());
		}
		session.close();
		return itemLists;
	}
	
	public void saveItems(List<ItemMaster> items, String user) {
		for(ItemMaster item : items) {
			int newMin = item.getMinQty();
			int newMax = item.getMaxQty();
			Session session = factory.openSession();
			session.beginTransaction();
			ItemMaster originalItem = session.get(ItemMaster.class, item.getId());
			originalItem.setEndDate(LocalDate.now());
			session.update(originalItem);
			session.getTransaction().commit();
			session.close();
			
			session = factory.openSession();
			session.beginTransaction();
			session.detach(item);
			item.setMinQty(newMin);
			item.setMaxQty(newMax);
			item.reinitializeItem(user);
			session.save(item);
			session.getTransaction().commit();
			session.close();
		}
	}
	*/
	public void saveUpdate(ItemStoreMapping mapping) {
		Session session = factoryCreator.getFactory().openSession();
		session.beginTransaction();
		TypedQuery<ItemStoreMapping> query = session.createQuery("FROM ItemStoreMapping ism WHERE "
				+ "ism.itemName = :itemName AND ism.itemCode = :itemCode AND ism.storeCode = :storeCode AND ism.storeName = :storeName AND ism.endDate IS NULL",ItemStoreMapping.class);
		query.setParameter("itemName", mapping.getItemName());
		query.setParameter("itemCode", mapping.getItemCode());
		query.setParameter("storeCode", mapping.getStoreCode());
		query.setParameter("storeName", mapping.getStoreName());
		int recordSetSize = query.getResultList().size();
		session.clear();
		if(!(recordSetSize>0)) {
			session.save(mapping);
			session.getTransaction().commit();
		}
		else {
			if(mapping.getId() !=null && mapping.getEndDate() != null) {
				session.update(mapping);
				session.getTransaction().commit();
			}
		}
		session.close();
	}
	/*
	// get item code list
	public List<String> itemCodeList(){
		Session session = factory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> itemCodeQuery = builder.createQuery(String.class);
		Root<ItemMaster> itemRoot = itemCodeQuery.from(ItemMaster.class);
		itemCodeQuery.multiselect((itemRoot.get("itemCode"))).where(builder.equal(itemRoot.get("status"),true));
		
		TypedQuery<String> query = session.createQuery(itemCodeQuery);
		List<String> codeList = query.getResultList();
		System.out.println("$$$$$ code size"+codeList.size());
		session.close();
		return codeList;
	}
	
	public List<String> itemNameList(){
		Session session = factory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> itemCodeQuery = builder.createQuery(String.class);
		Root<ItemMaster> itemRoot = itemCodeQuery.from(ItemMaster.class);
		itemCodeQuery.multiselect((itemRoot.get("itemName"))).where(builder.equal(itemRoot.get("status"),true));
		
		TypedQuery<String> query = session.createQuery(itemCodeQuery);
		List<String> nameList = query.getResultList();
		session.close();
		return nameList;
	} */
	
	// return list of item store mapping
	public List<ItemStoreMapping> itemStoreMapping(String itemCode, String itemName, String storeCode, String storeName){
		List<Predicate> predicatesList = new ArrayList<>();
		Session session = factoryCreator.getFactory().openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ItemStoreMapping> mappingQuery = builder.createQuery(ItemStoreMapping.class);
		Root<ItemStoreMapping> mappingRoot = mappingQuery.from(ItemStoreMapping.class);
		boolean changedStatus = false;
		
		if(itemCode != null && itemCode.length()>0) {
			predicatesList.add(builder.equal(mappingRoot.get("itemCode"),itemCode ));

		}
		if(itemName != null && itemName.length()>0) {
			predicatesList.add(builder.equal(mappingRoot.get("itemName"), itemName));
		}
		if(storeCode != null && storeCode.length()>0) {
			predicatesList.add(builder.equal(mappingRoot.get("storeCode"), storeCode));
		}
		if(storeName != null && storeName.length()>0) {
			predicatesList.add(builder.equal(mappingRoot.get("storeName"),storeName));
		}
		List<ItemStoreMapping> listOfMapping = null;
		if(predicatesList.size() > 0) {
			Predicate [] itemStoreMappingArray = predicatesList.toArray(new Predicate[predicatesList.size()]);
			mappingQuery.select(mappingRoot).where(builder.and(itemStoreMappingArray));
			//session.beginTransaction();
			TypedQuery<ItemStoreMapping> mappingList = session.createQuery(mappingQuery);
			listOfMapping = mappingList.getResultList();
			session.close();
		}
		return listOfMapping;
	}
	/*
	// find item code of selected item on basis of name
	public String selectedItemCode(String itemName) {
		Session session = factory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> codeQuery = builder.createQuery(String.class);
		Root<ItemMaster> masterRoot = codeQuery.from(ItemMaster.class);
		codeQuery.multiselect(masterRoot.get("itemCode")).where(builder.and(builder.equal(masterRoot.get("itemName"), itemName ),builder.equal(masterRoot.get("status"), true)));
		
		TypedQuery<String> query = session.createQuery(codeQuery);
		String code = query.getSingleResult();
		session.close();
		return code;
	}
	// find item name of selected item on basis of code
	public String selectedItemName(String itemCode) {
		Session session = factory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> codeQuery = builder.createQuery(String.class);
		Root<ItemMaster> masterRoot = codeQuery.from(ItemMaster.class);
		codeQuery.multiselect(masterRoot.get("itemName")).where(builder.and(builder.equal(masterRoot.get("itemCode"), itemCode ),builder.equal(masterRoot.get("status"), true)));
		
		TypedQuery<String> query = session.createQuery(codeQuery);
		String name = query.getSingleResult();
		session.close();
		return name;
	}
	*/
	// Get store lookup related info
	// get item code list
		public List<String> storeCodeList(){
			List<String> codeList = new ArrayList<>();
			Session session = factoryCreator.getFactory().openSession();
			LookupMaster master = session.get(LookupMaster.class, 13);
			session.close();
			for(LookupDetails details: master.getLookupDetails()) {
				codeList.add(details.getValue1());
			}
			return codeList;
		}
		
		public List<String> storeNameList(){
			List<String> nameList = new ArrayList<>();
			Session session = factoryCreator.getFactory().openSession();
			LookupMaster master = session.get(LookupMaster.class, 13);
			session.close();
			for(LookupDetails details: master.getLookupDetails()) {
				nameList.add(details.getValue2());
			}
			return nameList;
			
		}
		
		// find code of selected store on the basis of storeName
		public String selectedStoreCode(String storeName) {
			Session session = factoryCreator.getFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> codeQuery = builder.createQuery(String.class);
			Root<LookupDetails> detailsRoot = codeQuery.from(LookupDetails.class);
			codeQuery.multiselect(detailsRoot.get("value1")).where(builder.and(builder.equal(detailsRoot.get("value2"), storeName ))); // builder.equal(masterRoot.get("status"), true)
			TypedQuery<String> query = session.createQuery(codeQuery);
			String code = query.getSingleResult();
			session.close();
			return code;
		}
		// find name of selected store on the basis of code.
		public String selectedStoreName(String storeCode) {
			Session session = factoryCreator.getFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> codeQuery = builder.createQuery(String.class);
			Root<LookupDetails> masterRoot = codeQuery.from(LookupDetails.class);
			codeQuery.multiselect(masterRoot.get("value2")).where(builder.and(builder.equal(masterRoot.get("value1"), storeCode))); //,builder.equal(masterRoot.get("status"), true)
			
			TypedQuery<String> query = session.createQuery(codeQuery);
			String name = query.getSingleResult();
			session.close();
			return name;
		}

		public AppSessionFactory getFactoryCreator() {
			return factoryCreator;
		}

		public void setFactoryCreator(AppSessionFactory factoryCreator) {
			this.factoryCreator = factoryCreator;
		}
}
