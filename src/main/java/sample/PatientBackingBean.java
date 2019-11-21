package sample;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.filix.entities.PatientOtc;

@ManagedBean(name="patientBean")
@SessionScoped
public class PatientBackingBean {
	private String registrationId;
	private String patientName;
	private String episodeNumber;
	private String consultantCode;
	private String consultantName;
	
	private List<PatientOtc> patientList;
	@Inject
	private ApplicationBean appBean;

	// getters and setters
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getEpisodeNumber() {
		return episodeNumber;
	}
	public void setEpisodeNumber(String episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

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

	public List<PatientOtc> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<PatientOtc> patientList) {
		this.patientList = patientList;
	}
	
	public void populatePatientTable(){
		this.patientList = appBean.getPatientDao().getPatientList(registrationId, patientName, consultantCode, consultantName, episodeNumber);
	}
}	
