package sample;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.filix.dao.ConsultantDAO;
import com.filix.dao.EmployeeDAO;
import com.filix.dao.ItemMappingDAO;
import com.filix.dao.ItemMasterDAO;
import com.filix.dao.PatientDAO;

@ManagedBean
@ApplicationScoped
public class ApplicationBean {
	@Inject
	private ItemMappingDAO mappingDao;
	
	@Inject
	private ItemMasterDAO masterDao;
	
	@Inject
	private EmployeeDAO empDao;
	
	@Inject
	private ConsultantDAO consultantDao;
	
	@Inject
	private PatientDAO patientDao;
	
	public ItemMappingDAO getMappingDao() {
		return mappingDao;
	}
	public void setMappingDao(ItemMappingDAO mappingDao) {
		this.mappingDao = mappingDao;
	}

	public ItemMasterDAO getMasterDao() {
		return masterDao;
	}
	public void setMasterDao(ItemMasterDAO masterDao) {
		this.masterDao = masterDao;
	}
	
	public EmployeeDAO getEmpDao() {
		return empDao;
	}
	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}
	
	public ConsultantDAO getConsultantDao() {
		return consultantDao;
	}
	public void setConsultantDao(ConsultantDAO consultantDao) {
		this.consultantDao = consultantDao;
	}
	public PatientDAO getPatientDao() {
		return patientDao;
	}
	public void setPatientDao(PatientDAO patientDao) {
		this.patientDao = patientDao;
	}
	
	
	
	
}
