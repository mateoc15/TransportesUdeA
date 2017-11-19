package co.edu.udea.TransportesUdea.dto;

/**
 * 
 * @author Santiago
 *
 */

// esta clase si vale la pena implementarla? de hacerlo debe tener mas infor
// tiempo estimado de respuesta o algo asi 

public class ReportType {
	
	 String id;
	 String name;
	 
		public ReportType() {
			super();
		}

	 
	public ReportType(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	 

}
