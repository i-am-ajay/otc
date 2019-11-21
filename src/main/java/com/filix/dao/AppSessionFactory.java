package com.filix.dao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@ManagedBean
@ApplicationScoped
public class AppSessionFactory {
	private SessionFactory factory;
	
	@PostConstruct
	public void init() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		PopulateMasters.populateLookupMaster(factory);
		PopulateMasters.createItems(factory);
		PopulateMasters.createEmps(factory);
		PopulateMasters.createConsultants(factory);
		PopulateMasters.createPatients(factory);
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	
}
