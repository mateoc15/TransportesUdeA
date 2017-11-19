package co.edu.udea.TransportesUdea.dao;

import java.util.List;

import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.dto.Report;
import co.edu.udea.TransportesUdea.dto.User;

/**
 * Clase encargada de gestion de persistencia de la tabla Report
 * @author Santiago
 *
 */
public interface ReportDao {
	
	/**
	 * metodo para obtener un reporte(PQRS) a traves de su id
	 * @param idReport
	 * @return Report
	 * @throws MyDaoException
	 */
	public Report getReportById(Integer idReport) throws MyDaoException;
	
	
	/**
	 * metodo para obtener la lista de reportes cuyo estado es pendiente
	 * @return
	 * @throws MyDaoException
	 */
	public List<Report> getReportsPending() throws MyDaoException;
	
	/**
	 * metodo para agregar un nuevo reporte a la base de datos
	 * @param report
	 * @throws MyDaoException
	 */
	public void saveReport(Report report) throws MyDaoException;

	/**
	 * metodo para realizar modificaciones a un reporte almacenado
	 * @param employee
	 * @throws MyDaoException
	 */
	public void updateReport(Report report) throws MyDaoException;
	
	/**
	 * metodo para eliminar un reporte de la base de datos dado su id
	 * @param id
	 * @throws MyDaoException
	 */
	public void deleteReport(Integer id) throws MyDaoException;


	/**
	 * metodo para obtener la lista de reportes ralizador por un usuario dado su id
	 * @return
	 * @throws MyDaoException
	 */
	public List<Report> getReportsUser(User user) throws MyDaoException;
	
	

}
