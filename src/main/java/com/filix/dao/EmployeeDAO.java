package com.filix.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.Session;


import com.filix.entities.EmployeeMaster;
@Named
public class EmployeeDAO {
	@Inject
	private AppSessionFactory factoryCreator;
	
	public List<EmployeeMaster> getEmployee(String employeeCode, String employeeName) {
		Session session = factoryCreator.getFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<EmployeeMaster> query = builder.createQuery(EmployeeMaster.class);
		Root<EmployeeMaster> employeeRoot = query.from(EmployeeMaster.class);
		List<Predicate> listOfPredicates = new ArrayList<>();
		if(employeeCode != null && employeeCode.length() > 0) {
			listOfPredicates.add(builder.equal(employeeRoot.get("employeeCode"),employeeCode ));
		}
		if(employeeName != null && employeeName.length()>0) {
			listOfPredicates.add(builder.like(employeeRoot.get("employeeName"), "%"+employeeName+"%"));
		}
		if( listOfPredicates.size()==0) {
			return null;
		}
		Filter filter = session.enableFilter("emp_dependent_filter");
		filter.setParameter("status", true);
		query.select(employeeRoot).where(builder.and(listOfPredicates.toArray(new Predicate[listOfPredicates.size()])));
		TypedQuery<EmployeeMaster> employeeQuery = session.createQuery(query);
		return employeeQuery.getResultList();
	}
}
