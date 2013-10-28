package fr.utbm.lo54project.model.dto;
 
/**
 * DTO FormationsDTO : Permet de désérialiser les données relatives aux formations des différentes tables,
 * pour les utiliser dans les objets de la classe FormationsDTO.
 * Constituer juste des attributs privés, des constructeurs, des getters et des setters
 * @author Lodjeu - Libam - Ntieche
 *
 */
public class FormationsDTO {
 
	private String sessionId;
	private String courseCode;
	private String courseTitle;
	private String courseLocation;
	private String courseStartDate;
	private String courseEndDate;
	private int courseNbClients;
	private String clientFirstName;
	private String clientLastName;
	
	public FormationsDTO(){
		
	}

	public FormationsDTO(String sessionId, String courseCode, String courseTitle,
			String courseLocation, String courseStartDate,
			String courseEndDate, int courseNbClients) {
		super();
		this.sessionId = sessionId;
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseLocation = courseLocation;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseNbClients = courseNbClients;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}

	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public String getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public int getCourseNbClients() {
		return courseNbClients;
	}

	public void setCourseNbClients(int courseNbClients) {
		this.courseNbClients = courseNbClients;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}
 	
 
}
