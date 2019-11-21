package com.filix.dao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
import com.filix.entities.ItemSubstitute;

@Named
public class ItemMasterDAO {
	@Inject
	private AppSessionFactory factoryCreator;
	
	public List<ItemMaster> getItems(String itemCode, String itemName) {
		List<Predicate> predicateList = new ArrayList<>();
		List<ItemMaster> itemLists = null;
		Session session = factoryCreator.getFactory().openSession();
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
			Session session = factoryCreator.getFactory().openSession();
			session.beginTransaction();
			ItemMaster originalItem = session.get(ItemMaster.class, item.getId());
			originalItem.setEndDate(LocalDate.now());
			session.update(originalItem);
			session.getTransaction().commit();
			session.close();
			
			
			session = factoryCreator.getFactory().openSession();
			
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
	
	// get item code list
		public List<String> itemCodeList(){
			Session session = factoryCreator.getFactory().openSession();
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
			Session session = factoryCreator.getFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> itemCodeQuery = builder.createQuery(String.class);
			Root<ItemMaster> itemRoot = itemCodeQuery.from(ItemMaster.class);
			itemCodeQuery.multiselect((itemRoot.get("itemName"))).where(builder.equal(itemRoot.get("status"),true));
			
			TypedQuery<String> query = session.createQuery(itemCodeQuery);
			List<String> nameList = query.getResultList();
			session.close();
			return nameList;
		}
		
		// find item code of selected item on basis of name
		public String selectedItemCode(String itemName) {
			Session session = factoryCreator.getFactory().openSession();
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
			Session session = factoryCreator.getFactory().openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> codeQuery = builder.createQuery(String.class);
			Root<ItemMaster> masterRoot = codeQuery.from(ItemMaster.class);
			codeQuery.multiselect(masterRoot.get("itemName")).where(builder.and(builder.equal(masterRoot.get("itemCode"), itemCode ),builder.equal(masterRoot.get("status"), true)));
			
			TypedQuery<String> query = session.createQuery(codeQuery);
			String name = query.getSingleResult();
			session.close();
			return name;
		}
}
