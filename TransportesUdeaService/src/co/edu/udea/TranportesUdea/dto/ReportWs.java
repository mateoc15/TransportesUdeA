package co.edu.udea.TranportesUdea.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase dto para el reporte usado en los servicios
 * @author Alejandro Isaza
 * @email alejandro.isazad@udea.edu.co
 *
 */
@XmlRootElement(name="reporte")
public class ReportWs {
	 Integer id;
	 String description;
	 String status;
	 String ReportType;
	 String Employee;
	 String User;
	 Date createDate; // se le debe pasar la hora actual del servidor en el constructor no deberia de ir
	 String response;
	 
	 
	 
	public ReportWs() {
		super();
	}



	public ReportWs(Integer id,String description, String status, String reportType, String employee, String user, Date createDate,
			String response) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		ReportType = reportType;
		Employee = employee;
		User = user;
		this.createDate = createDate;
		this.response = response;
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



	public String getReportType() {
		return ReportType;
	}



	public void setReportType(String reportType) {
		ReportType = reportType;
	}



	public String getEmployee() {
		return Employee;
	}



	public void setEmployee(String employee) {
		Employee = employee;
	}



	public String getUser() {
		return User;
	}



	public void setUser(String user) {
		User = user;
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
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	
	


}
