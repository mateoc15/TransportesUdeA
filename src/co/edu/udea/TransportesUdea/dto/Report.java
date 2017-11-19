package co.edu.udea.TransportesUdea.dto;

import java.util.Date;

/**
 * 
 * @author Santiago
 *
 */

public class Report {
	 Integer id;
	 String description;
	 String status;
	 ReportType idReportType;
	 Employee idEmployee;
	 User idUser;
	 Date createDate; // se le debe pasar la hora actual del servidor en el constructor no deberia de ir
	 String response;
	 
	 
	 
	public Report() {
		super();
	}



	public Report(Integer id, String description, String status, ReportType idReportType, Employee idEmployee,
			User idUser, Date createDate, String response) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.idReportType = idReportType;
		this.idEmployee = idEmployee;
		this.idUser = idUser;
		this.createDate = createDate;
		this.response = response;
	}

	
	public Report(String description, String status, ReportType idReportType, User idUser, Date createDate) {
		super();
		this.description = description;
		this.status = status;
		this.idReportType = idReportType;
		this.idUser = idUser;
		this.createDate = createDate;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public ReportType getIdReportType() {
		return idReportType;
	}



	public void setIdReportType(ReportType idReportType) {
		this.idReportType = idReportType;
	}



	public Employee getIdEmployee() {
		return idEmployee;
	}



	public void setIdEmployee(Employee idEmployee) {
		this.idEmployee = idEmployee;
	}



	public User getIdUser() {
		return this.idUser;
	}



	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}
	
	


}
