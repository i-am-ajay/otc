package sample;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.filix.entities.ConsultantDependent;
import com.filix.entities.ConsultantMaster;
import com.filix.entities.EmployeeDependent;
import com.filix.entities.EmployeeMaster;

@ManagedBean(name="consultantBean")
@SessionScoped
public class ConsultantBackingBean {
	private String consultantCode;
	private String consultantName;
	private String selectedConsultant;
	@Inject
	private ApplicationBean appBean;
	
	private List<ConsultantMaster> consultantList;
	private List<ConsultantDependent> consultantDependentList;
	
	public String getConsultantCode() {
		return consultantCode;
	}
	public void setConsultantCode(String consultantCode) {
		this.consultantCode = consultantCode;
	}
	
	public String getConsultantName() {
		return consultantName;
	}
	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}
	
	public String getSelectedConsultant() {
		return selectedConsultant;
	}
	public void setSelectedConsultant(String selectedConsultant) {
		this.selectedConsultant = selectedConsultant;
	}
	
	
	public ApplicationBean getAppBean() {
		return appBean;
	}
	public void setAppBean(ApplicationBean appBean) {
		this.appBean = appBean;
	}
	
	public List<ConsultantMaster> getConsultantList() {
		return consultantList;
	}
	public void setConsultantList(List<ConsultantMaster> consultantList) {
		this.consultantList = consultantList;
	}
	public List<ConsultantDependent> getConsultantDependentList() {
		return consultantDependentList;
	}
	public void setConsultantDependentList(List<ConsultantDependent> consultantDependentList) {
		this.consultantDependentList = consultantDependentList;
	}
	
	// listener and action methods
	public void populateConsultantTable() {
		this.consultantDependentList = null;
		this.consultantList = null;
		this.consultantList = appBean.getConsultantDao().getConsultant(consultantCode, consultantName);
		if(consultantList !=null && consultantList.size() > 0)
			System.out.println(consultantList.get(0).getConsultantCode());
	}
	
	// listener method on row selection
	public void setDependentTable(SelectEvent event) {
		ConsultantMaster master = (ConsultantMaster)event.getObject();
		if(master != null) {
			System.out.println("Calling consultant dependent");
			consultantDependentList = master.getConsultantDependets();
			System.out.println(this.consultantList.get(0).getConsultantName());
		}
	}
	
	public void clearDependentTable(UnselectEvent event) {
		System.out.println("unselect called.");
	}
	
	
}
