package com.filix.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.Session;

import com.filix.entities.ConsultantMaster;
import com.filix.entities.EmployeeMaster;

@ManagedBean
public class ConsultantDAO {
	@Inject
	private AppSessionFactory factoryCreator;
	
	public List<ConsultantMaster> getConsultant(String consultantCode, String consultantName) {
		Session session = factoryCreator.getFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ConsultantMaster> query = builder.createQuery(ConsultantMaster.class);
		Root<ConsultantMaster> consultantRoot = query.from(ConsultantMaster.class);
		List<Predicate> listOfPredicates = new ArrayList<>();
		if(consultantCode != null && consultantCode.length() > 0) {
			listOfPredicates.add(builder.equal(consultantRoot.get("consultantCode"),consultantCode ));
		}
		if(consultantName != null && consultantName.length()>0) {
			listOfPredicates.add(builder.like(consultantRoot.get("consultantName"), "%"+consultantName+"%"));
		}
		if( listOfPredicates.size()==0) {
			return null;
		}
		Filter filter = session.enableFilter("consultant_dependent_filter");
		filter.setParameter("status", true);
		query.select(consultantRoot).where(builder.and(listOfPredicates.toArray(new Predicate[listOfPredicates.size()])));
		TypedQuery<ConsultantMaster> employeeQuery = session.createQuery(query);
		return employeeQuery.getResultList();
	}
}
