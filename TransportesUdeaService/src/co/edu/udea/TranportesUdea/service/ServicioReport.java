package co.edu.udea.TranportesUdea.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.TranportesUdea.dto.ReportWs;
import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.bl.EmployeeBL;
import co.edu.udea.TransportesUdea.bl.ReportBL;
import co.edu.udea.TransportesUdea.bl.UserBL;
import co.edu.udea.TransportesUdea.dto.Employee;
import co.edu.udea.TransportesUdea.dto.Report;
import co.edu.udea.TransportesUdea.dto.ReportType;
import co.edu.udea.TransportesUdea.dto.User;

/**
 * Clase en la cual se exponen los servicios relacionados con el reporte
 * @author Alejandro Isaza
 * @email alejandro.isazad@udea.edu.co
 *
 */
@Component // se anota con Component para que spring lo cargue.
@Path("report")
public class ServicioReport {
	
	@Autowired
	ReportBL reportBL;
	EmployeeBL employeeBL;
	UserBL userBL;
	//colocar setter o constructor para la inyeccion de dependencias de employeeBL
	/**
	 * Getter necesario para la inyeccion de dependencias de ReportBL
	 * @return the ReportBL
	 */
	public ReportBL getReportBL() {
		return reportBL;
	}

	/**
	 * setter necesario para la inyeccion de dependencias de ReportBL
	 * @param reportBL the reportBL to set
	 */
	public void setReportBL (ReportBL  reportBL) {
		this.reportBL = reportBL;
	}

	
	/**
	 * Metodo utilizado para ser invocado como servicio web REST
	 * que permite obtener un reporte dado su id 
	 * 
	 * @throws MyDaoException
	 * @throws BLException 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obtener")
	public ReportWs obtenerReporte(@QueryParam("id") Integer id) throws MyDaoException, BLException{
		
		ReportWs resultado = null;
		Report dato = null;
		dato = reportBL.ReporteporId(id);

		Employee empleado = dato.getIdEmployee();
		String empleadoNombre = (empleado == null) ? "" : empleado.getName();
		String Response = dato.getResponse();
		String response = (Response == null) ? "" : Response;
		User usuario = dato.getIdUser();
		ReportType reportType = dato.getIdReportType();	
		resultado = new ReportWs(dato.getId(),dato.getDescription(), dato.getStatus(), reportType.getName(), empleadoNombre,usuario.getName(),dato.getCreateDate(),response);

		return resultado;
	}
	
	/**
	 * Metodo utilizado para ser invocado como servicio web REST
	 * que permite listar todos los reportes pendientes
	 * 
	 * @throws MyDaoException
	 * @throws BLException 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public List<ReportWs> obtenerReportesPendientes() throws MyDaoException, BLException{
		
		List<ReportWs> resultado = new ArrayList<>();
		List<Report> datos = null;
		
		datos = reportBL.listarReportesPendientes();
		
		for(Report report:datos){
			Employee empleado = report.getIdEmployee();
			String empleadoNombre = (empleado == null) ? "" : empleado.getName();
			String Response = report.getResponse();
			String response = (Response == null) ? "" : Response;
			User usuario = report.getIdUser();
			ReportType reportType = report.getIdReportType();
			
			resultado.add(new ReportWs(report.getId(),report.getDescription(), report.getStatus(), reportType.getName(), empleadoNombre,usuario.getName(),report.getCreateDate(),response));
		}
		return resultado;
	}

    /**
     * Metodo utilizado para ser invocado como servicio web REST que permite crear un reporte en el sistema
     * @param description
     * @param reportType
     * @param user
     * @throws MyDaoException
     * @throws BLException 
     */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("crear")
	public String crearReporte(@QueryParam("description") String description, @QueryParam("reportType") String reportType, @QueryParam("user") String user) throws MyDaoException, BLException{
		try{
		reportBL.almacenarReporte(description, reportType, user);
		}catch (BLException e) {
			return e.getMessage();
		}
		return "El Reporte ha sido creado satisfactoriamente";
	}
	
	
	/**
	 * Metodo utilizado para ser invocado como servicio web GET
	 * que permite listar todos los reportes de un usuario
	 * 
	 * @throws MyDaoException
	 * @throws BLException 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarUser")
	public List<ReportWs> obtenerReportesPendientesUsuario(@QueryParam("user") String idUser) throws MyDaoException, BLException{
		System.out.println(idUser);
		List<ReportWs> resultado = new ArrayList<>();
		List<Report> datos = null;
		
		if(idUser == null){
           System.out.println("compa el id es nullo");
		}
		
		datos = reportBL.listarReportesUsuario(idUser);
		
		for(Report report:datos){
			Employee empleado = report.getIdEmployee();
			String empleadoNombre = (empleado == null) ? "" : empleado.getName();
			String Response = report.getResponse();
			String response = (Response == null) ? "" : Response;
			//User usuario = report.getIdUser();
			ReportType reportType = report.getIdReportType();
			
			resultado.add(new ReportWs(report.getId(),report.getDescription(), report.getStatus(), reportType.getName(), empleadoNombre,"pedra",report.getCreateDate(),response));
		}
		return resultado;
	}

    /**
     * Metodo utilizado para ser invocado como servicio web REST que permite actualizar un reporte en el sistema
     * @param id
     * @param employee
     * @param response
     * @return
     * @throws MyDaoException
     * @throws BLException
     */
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("actualizar")
	public String actualizarReporte(@QueryParam("id") Integer id, @QueryParam("employee") String employee,@QueryParam("response") String response) throws MyDaoException, BLException{
		try{
		reportBL.actualizarReporte(id, employee, response);
		}catch (BLException e) {
			return e.getMessage();
		}
		return "El Reporte ha sido actualizado satisfactoriamente";
	}
	
	/**
	 * Metodo utilizado para ser invocado como servicio web REST que permite eliminar un reporte en el sistema
	 * @param id
	 * @return
	 * @throws MyDaoException
	 * @throws BLException
	 */
	@DELETE
	@Path("eliminar")
	public String eliminarReporte(@QueryParam("id") Integer id) throws MyDaoException, BLException{
		try{
		reportBL.eliminarReporte(id);
		}catch (BLException e) {
			return e.getMessage();
		}
		return "El Reporte ha sido eliminado satisfactoriamente";
	}
}
