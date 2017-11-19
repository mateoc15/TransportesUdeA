package co.edu.udea.TransportesUdea.bl.Impl;

import java.util.Date;
import java.util.List;

import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.bl.ReportBL;
import co.edu.udea.TransportesUdea.dao.EmployeeDao;
import co.edu.udea.TransportesUdea.dao.ReportDao;
import co.edu.udea.TransportesUdea.dao.UserDao;
import co.edu.udea.TransportesUdea.dto.Employee;
import co.edu.udea.TransportesUdea.dto.Report;
import co.edu.udea.TransportesUdea.dto.ReportType;
import co.edu.udea.TransportesUdea.dto.User;

public class ReportBLImpl implements ReportBL {
	
	private ReportDao reportDao;
	private UserDao usuarioDao;
	private EmployeeDao employeeDao;
	/**
	 * Metodo constructor de la clase
	 * @param UserDao Objeto de tipo DAO 
	 * que sera inyectado a traves del constructor
	 *  para el acceso a la capa de datos
	 */
	public ReportBLImpl(ReportDao reportDao,UserDao usuarioDao,EmployeeDao employeeDao) {
		this.reportDao = reportDao;
		this.usuarioDao = usuarioDao;
		this.employeeDao = employeeDao;
	}

	public void almacenarReporte(String descripcion, String idReportType, String idUser) throws BLException{
		
		User usuario;
		
		if (descripcion == null || "".equals(descripcion.trim())) {
			throw new BLException("Debe proporcionar una descripci�n.");
		}
		
		if (idReportType == null || "".equals(idReportType.trim())) {
			throw new BLException("Debe especificar el tipo de reporte.");
		}
		
		if (idUser == null || "".equals(idUser.trim())) {
			throw new BLException("La cedula no puede ser nula ni puede estar vacia.");
		}
		
		/**
		 * Se debe Validar que el usuario Exista en la base de datos.
		 */
		try {
				
			usuario = usuarioDao.getuserById(idUser);
			if (usuario == null){
			  throw new BLException("El Usuario especificado no existe");
			}
			ReportType tipoReporte = new ReportType(idReportType, "");
						
			Date fecha = new Date();
			Report reporte = new Report( descripcion, "Pendiente", tipoReporte, usuario, fecha);
			reportDao.saveReport(reporte);
			
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		
	}

	@Override
	public List<Report> listarReportesPendientes() throws BLException{
		List<Report> reportespendientes=null;
		
		try {
			reportespendientes = reportDao.getReportsPending();
			
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		return reportespendientes;
	}

	@Override
	public List<Report> listarReportesUsuario(String idUsuario)throws BLException {
		List<Report> reportesUsuario=null;
		User usuario;
		try {
			usuario = usuarioDao.getuserById(idUsuario);
			if (usuario == null){
			  throw new BLException("El Usuario especificado no existe");
			}
			reportesUsuario = reportDao.getReportsUser(usuario);
			
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		return reportesUsuario;
	}
	
	@Override
	public Report ReporteporId(Integer idReport)throws BLException {
		Report reporte=null;
		try {
			reporte = reportDao.getReportById(idReport);
			
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		return reporte;
	}

	@Override
	public void eliminarReporte(Integer id) throws BLException {
		Report reporte=null;
		try {
			reporte = new Report();
			reporte.setId(id);
			reportDao.deleteReport(id);
			
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
	}

	@Override
	public void actualizarReporte(Integer id, String idEmployee, String response)
			throws BLException {
        Employee employee;
        Report report;
		
        if (id == null || id.equals(0)) {
			throw new BLException("Debe proporcionar una id.");
		}
        
        if (idEmployee == null || "".equals(idEmployee.trim())) {
			throw new BLException("La cedula no puede ser nula ni puede estar vacia.");
		}

		if (response == null || "".equals(response.trim())) {
			throw new BLException("La respuesta no puede ser nula ni puede estar vacia.");
		}
		
		try {
    		report = reportDao.getReportById(id);
			if (report == null){
			  throw new BLException("El Reporte especificado no existe");
			}
			
			employee = employeeDao.getEmployeeById(idEmployee);
			if (employee == null){
				  throw new BLException("El Empleado especificado no existe");
				}

			report.setStatus("Revisado");
			report.setIdEmployee(employee);
			report.setResponse(response);
			reportDao.updateReport(report);
			
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		
	}
}
