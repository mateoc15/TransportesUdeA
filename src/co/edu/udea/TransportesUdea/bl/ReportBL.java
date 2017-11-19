package co.edu.udea.TransportesUdea.bl;

import java.util.List;

import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.dto.Employee;
import co.edu.udea.TransportesUdea.dto.Report;

/**
 * clase para la logica de negocio de los reportes del sistema
 * @author Santiago
 *
 */
public interface ReportBL {
	
	 /**
	 * metodo que retorna todos los reportes cuyo estado sea pendiente
	 * en el sistema y ordenados desendentemente por fecha
	 * @return
	 */
	public List<Report> listarReportesPendientes() throws BLException;
	
	/**
	 * Este m�todo es usado para almacenar el reporte enviado por un usuario en la base de datos.
	 * @param descripcion Descripci�n de la petici�n, Queja, Reclamo o Solicitud
	 * @param idReportType
	 * @param idUser
	 */
	public void almacenarReporte(String descripcion, String idReportType, String idUser) throws BLException;
	
	/**
	 * metodo que retorna todos los reportes realizados por un usuario
	 * @return
	 */
	public List<Report> listarReportesUsuario(String idUsuario) throws BLException;
	
	/**
	 * metodo que retorna un reporte dado su id
	 * @return
	 */
	public Report ReporteporId(Integer id)throws BLException ;
	
	/**
	 * metodo que retorna un reporte dado su id
	 * @return
	 */
	public void actualizarReporte(Integer id,String idEmployee,String response)throws BLException ;
	/**
	 * metodo que retorna un reporte dado su id
	 * @return
	 */
	public void eliminarReporte(Integer id)throws BLException ;

}
