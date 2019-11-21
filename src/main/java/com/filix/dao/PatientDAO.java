package com.filix.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.filix.entities.PatientOtc;

public class PatientDAO {
	@Inject
	private AppSessionFactory factoryCreator;
	
	public List<PatientOtc> getPatientList(String registrationId, String patientName, String consultantCode, 
			String consultantName, String episodeNumber){
		Session session = factoryCreator.getFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PatientOtc> criteriaQuery = builder.createQuery(PatientOtc.class);
		Root<PatientOtc> patientRoot = criteriaQuery.from(PatientOtc.class);
		
		List<Predicate> predicateList = new ArrayList<>();
		if(registrationId != null && registrationId.length() > 0) {
			predicateList.add(builder.equal(patientRoot.get("registrationId"), registrationId));
		}
		if(patientName != null && patientName.length() > 0) {
			predicateList.add(builder.like(patientRoot.get("patientName"), "%"+patientName+"%"));
		}
		if(consultantCode != null && consultantCode.length() > 0) {
			predicateList.add(builder.equal(patientRoot.get("consultantCode"), consultantCode));
		}
		if(consultantName != null && consultantName.length() > 0) {
			predicateList.add(builder.like(patientRoot.get("consultantName"),"%"+consultantName+"%"));
		}
		if(episodeNumber != null && episodeNumber.length() > 0) {
			predicateList.add(builder.equal(patientRoot.get("episodeNumber"), episodeNumber));
		}
		if(predicateList.size() == 0) {
			return null;
		}
		
		criteriaQuery.select(patientRoot).where(builder.and(predicateList.toArray(new Predicate[predicateList.size()])));
		
		TypedQuery<PatientOtc> patientQuery = session.createQuery(criteriaQuery);
		return patientQuery.getResultList();
		
	}
}
