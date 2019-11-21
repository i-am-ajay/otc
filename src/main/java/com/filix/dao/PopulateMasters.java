package com.filix.dao;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.filix.entities.ConsultantDependent;
import com.filix.entities.ConsultantMaster;
import com.filix.entities.EmployeeDependent;
import com.filix.entities.EmployeeMaster;
import com.filix.entities.ItemMaster;
import com.filix.entities.ItemSubstitute;
import com.filix.entities.LookupDetails;
import com.filix.entities.LookupMaster;
import com.filix.entities.PatientOtc;

public class PopulateMasters {
	public static void populateLookupMaster(SessionFactory factory) {
		LookupMaster master1 = new LookupMaster("D001","Department","Department"); 
		LookupMaster master2 = new LookupMaster("U001","Unit","Unit");
		LookupMaster master3 = new LookupMaster("G001","Designation","Designation");
		LookupMaster master4 = new LookupMaster("C001","Category","Category");
		LookupMaster master5 = new LookupMaster("DC01","Distribution Category","Distribution Category");
		LookupMaster master6 = new LookupMaster("SM01","Store Master","Store Master");
		LookupMaster master7 = new LookupMaster("LA01","Loan Advance Interest Rate","Loan Advance Interest Rate");
		LookupMaster master8 = new LookupMaster("LA02","Loan Advance FY","Loan Advance FY");
		
		LookupDetails details1 = new LookupDetails("Cardiac");
		LookupDetails details2 = new LookupDetails("Obs");
		
		LookupDetails details3 = new LookupDetails("HOD");
		LookupDetails details4 = new LookupDetails("Catg1");
		LookupDetails details5 = new LookupDetails("Points");
		LookupDetails details6 = new LookupDetails("10","Sir Ganga Ram Pharmacy");
		LookupDetails details7 = new LookupDetails("20","Consultant Pharmacy");
		LookupDetails details8 = new LookupDetails("30","Employee Dispensary");
		LookupDetails details9 = new LookupDetails("40","EWS Patient Dispensary");
		LookupDetails details10 = new LookupDetails("50","Donated Medicine Dispensary");
		LookupDetails details11 = new LookupDetails("8");
		LookupDetails details12 = new LookupDetails("2");
		LookupDetails details13 = new LookupDetails("Unit1");
		LookupDetails details14 = new LookupDetails("Unit2");
		
		//dept Mappings
		details1.setLookupMaster(master1);
		details2.setLookupMaster(master1);
		master1.getLookupDetails().add(details1);
		master1.getLookupDetails().add(details2);
		
		// desig mapping
		details3.setLookupMaster(master3);
		master3.getLookupDetails().add(details3);
		
		// Category Master
		details4.setLookupMaster(master4);
		master4.getLookupDetails().add(details4);
		
		details5.setLookupMaster(master5);
		master5.getLookupDetails().add(details5);
		
		// store mapping
		details6.setLookupMaster(master6);
		details7.setLookupMaster(master6);
		details8.setLookupMaster(master6);
		details9.setLookupMaster(master6);
		details10.setLookupMaster(master6);
		master6.getLookupDetails().add(details6);
		master6.getLookupDetails().add(details7);
		master6.getLookupDetails().add(details8);
		master6.getLookupDetails().add(details9);
		master6.getLookupDetails().add(details10);
		
		// Loans mapping
		details11.setLookupMaster(master7);
		master7.getLookupDetails().add(details11);
		
		details12.setLookupMaster(master8);
		master8.getLookupDetails().add(details12);
		
		// Unit mapping
		details13.setLookupMaster(master2);
		details14.setLookupMaster(master2);
		master2.getLookupDetails().add(details13);
		master2.getLookupDetails().add(details14);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(master1);
		session.save(master2);
		session.save(master3);
		session.save(master4);
		session.save(master5);
		session.save(master6);
		session.save(master7);
		session.save(master8);
		session.getTransaction().commit();
		session.close();
	}
	public static void createItems(SessionFactory factory) {
		ItemMaster master = new ItemMaster();
		master.setItemCode("MEDMEDCON1");
		master.setItemName("crocin tablet");
		master.setUom("piece");
		master.setHsn("36762837");
		master.setMinQty(14);
		master.setMaxQty(50);
		master.setTaxCategory("15%");
		master.setStartDate(LocalDate.of(2019, 1, 1));
		master.setStatus(true);
		
		ItemSubstitute i1s1 = new ItemSubstitute();
		i1s1.setsItemCode("Cro_Sub1");
		i1s1.setsItemName("Paracetamol 1");
		i1s1.setsItemUom("Tablet");
		i1s1.setCreatedBy("ajay");
		i1s1.setItemMasterLink(master);
		
		ItemSubstitute i1s2 = new ItemSubstitute();
		i1s2.setsItemCode("Cro_Sub2");
		i1s2.setsItemName("Paracetamol 2");
		i1s2.setsItemUom("Piece");
		i1s2.setCreatedBy("ajay");
		i1s2.setItemMasterLink(master);
		
		master.getListSubstitutes().add(i1s1);
		master.getListSubstitutes().add(i1s2);
		
		ItemMaster master1 = new ItemMaster();
		master1.setItemCode("MEDMEDCON2");
		master1.setItemName("Corex");
		master1.setUom("bottle");
		master1.setHsn("3423");
		master1.setMinQty(20);
		master1.setMaxQty(60);
		master1.setTaxCategory("15%");
		master1.setStartDate(LocalDate.of(2019, 1, 1));
		master1.setStatus(true);
		ItemSubstitute i2s1 = new ItemSubstitute();
		i2s1.setsItemCode("Cal_Sub1");
		i2s1.setsItemName("Cipcal");
		i2s1.setsItemUom("Bottle");
		i2s1.setCreatedBy("ajay");
		i2s1.setItemMasterLink(master1);
		
		ItemSubstitute i2s2 = new ItemSubstitute();
		i2s2.setsItemCode("Cor_Sub2");
		i2s2.setsItemName("Honytus");
		i2s2.setsItemUom("Bottle");
		i2s2.setCreatedBy("ajay");
		i2s2.setItemMasterLink(master1);
		
		master1.getListSubstitutes().add(i2s1);
		master1.getListSubstitutes().add(i2s2);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(master);
		session.save(master1);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void createEmps(SessionFactory factory) {
		/*String employeeCode, String employeeName, char gender, int designation, LocalDate dob,
		LocalDate doj, LocalDate dateOfLeaving, boolean active*/
		EmployeeMaster master1 = new EmployeeMaster("GAA0000","XYZ",'M',1,2,LocalDate.of(1950, 2, 20),LocalDate.of(1970, 3, 1),null,true);
		EmployeeMaster master2 = new EmployeeMaster("GAA0001","ABC",'F',2,5,LocalDate.of(1980, 1, 26),LocalDate.of(2000, 12,1 ),null,true);
		
		/*String dependentName, char gender, String relationship, LocalDate dependentDob,
			boolean dependentStatus */
		EmployeeDependent e1dependent1 = new EmployeeDependent("X",'F',"Wife",LocalDate.of(1955, 3, 15),true);
		EmployeeDependent e1dependent2 = new EmployeeDependent("Y",'F',"Daughter",LocalDate.of(1985, 2, 28),true);
		
		EmployeeDependent e2dependent1 = new EmployeeDependent("A",'M',"Husband",LocalDate.of(1978, 1, 15),true);
		EmployeeDependent e2dependent2 = new EmployeeDependent("X",'F',"Daughter",LocalDate.of(2000, 1, 28),true);
		
		
		// master1 dependent linking
		e1dependent1.setEmpMasterLink(master1);
		e1dependent2.setEmpMasterLink(master1);
		
		master1.getListOfDependent().add(e1dependent1);
		master1.getListOfDependent().add(e1dependent2);
		
		// master2 dependent linking
		e2dependent1.setEmpMasterLink(master2);
		e2dependent2.setEmpMasterLink(master2);
		master2.getListOfDependent().add(e2dependent1);
		master2.getListOfDependent().add(e2dependent2);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(master1);
		session.save(master2);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void createConsultants(SessionFactory factory) {
		/*String consultantCode, String consultantName, char gender, String designation,
			String department, String unit, LocalDate doj, LocalDate dob, boolean active*/
		ConsultantMaster master1 = new ConsultantMaster("GAA0000","XYZ",'M',1,2,3,LocalDate.of(1950, 2, 20),LocalDate.of(1970, 3, 1),true);
		ConsultantMaster master2 = new ConsultantMaster("GAA0001","ABC",'F',2,5,4,LocalDate.of(1980, 1, 26),LocalDate.of(2000, 12,1 ),true);
		
		/*String dependentName, char gender, String relationship, LocalDate dependentDob,
			boolean dependentStatus */
		ConsultantDependent e1dependent1 = new ConsultantDependent("X",'F',"Wife",LocalDate.of(1955, 3, 15),true);
		ConsultantDependent e1dependent2 = new ConsultantDependent("Y",'F',"Daughter",LocalDate.of(1985, 2, 28),true);
		
		ConsultantDependent e2dependent1 = new ConsultantDependent("A",'M',"Husband",LocalDate.of(1978, 1, 15),true);
		ConsultantDependent e2dependent2 = new ConsultantDependent("X",'F',"Daughter",LocalDate.of(2000, 1, 28),true);
		
		
		// master1 dependent linking
		e1dependent1.setMasterMapping(master1);
		e1dependent2.setMasterMapping(master1);
		
		master1.getConsultantDependets().add(e1dependent1);
		master1.getConsultantDependets().add(e1dependent2);
		
		// master2 dependent linking
		e2dependent1.setMasterMapping(master2);
		e2dependent2.setMasterMapping(master2);
		master2.getConsultantDependets().add(e2dependent1);
		master2.getConsultantDependets().add(e2dependent2);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(master1);
		session.save(master2);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void createPatients(SessionFactory factory) {
		/*String registrationId, String patientName, char gender, String consultantCode,
			String consultantName, String episodeNumber*/
		PatientOtc master1 = new PatientOtc("234521","XYZ",'M',"GAA0000","ABC","IP234323");
		PatientOtc master2 = new PatientOtc("2345213","STV",'F',"GAA0001","PQR","IP2762376");
		PatientOtc master3 = new PatientOtc("2345214","RST",'M',"GAA0002","TEST","IP2343423");
		PatientOtc master4 = new PatientOtc("898982","Jhon",'M',"GAA0000","ABC","IP231323");
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(master1);
		session.save(master2);
		session.save(master3);
		session.save(master4);
		session.getTransaction().commit();
		session.close();
	}
}
