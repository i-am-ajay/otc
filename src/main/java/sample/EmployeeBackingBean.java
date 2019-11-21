package sample;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.filix.entities.EmployeeDependent;
import com.filix.entities.EmployeeMaster;

@ManagedBean(name="empBean")
@SessionScoped
public class EmployeeBackingBean{
	private String empCode;
	private String empName;
	private EmployeeMaster selectedEmployee;
	private List<EmployeeMaster> employeeList;
	private List<EmployeeDependent> empDependentList;
	
	@Inject
	private ApplicationBean appBean;
	
	// Getters and setters
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String employeeCode) {
		this.empCode = employeeCode;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String employeeName) {
		this.empName = employeeName;
	}
	
	public EmployeeMaster getSelectedEmployee() {
		return selectedEmployee;
	}
	public void setSelectedEmployee(EmployeeMaster selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
	
	public List<EmployeeMaster> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeMaster> employeeList) {
		this.employeeList = employeeList;
	}
	
	public List<EmployeeDependent> getEmpDependentList() {
		return empDependentList;
	}
	public void setEmpDependentList(List<EmployeeDependent> empDependentList) {
		this.empDependentList = empDependentList;
	}
	
	public ApplicationBean getAppBean() {
		return appBean;
	}
	public void setAppBean(ApplicationBean appBean) {
		this.appBean = appBean;
	}
	
	public void populateEmployeeTable() {
		this.employeeList = appBean.getEmpDao().getEmployee(empCode, empName);
		this.empDependentList = null;
	}
	
	// listener method on row selection
	public void setDependentTable(SelectEvent event) {
		EmployeeMaster master = (EmployeeMaster)event.getObject();
		if(master != null) {
			empDependentList = master.getListOfDependent();
		}
	}
	
	public void clearDependentTable(UnselectEvent event) {
		System.out.println("unselect called.");
	}
	
}
