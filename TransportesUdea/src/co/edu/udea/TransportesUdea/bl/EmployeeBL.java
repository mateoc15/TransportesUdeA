package co.edu.udea.TransportesUdea.bl;

import java.util.List;

import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.dto.Employee;


/**
 * 
 * @author alejo
 * Interfaz que contiene todo los metodos usados en la logica para el empleado
 */
public interface EmployeeBL {
	/**
	 * Metodo que valida que un empleado exista en la base de datos
	 * @param email
	 * @param pass
	 * @throws MyDaoException
	 */
	public Employee validarEmpleado(String email,String password) throws BLException;
	
	/**
	 * Metodo que crea un usuario en la base de daos
	 * @param cedula
	 * @param name
	 * @param lastname
	 * @param salary
	 * @param email
	 * @param password
	 * @throws MyDaoException
	 */
	public void crearEmpleado(String cedula,String name ,String lastname ,Double salary ,String email,String password) throws BLException;
	
	/**
	 * Metodo que elimina un empleado dato su email
	 * @param email
	 * @throws MyDaoException
	 */
	public void eliminarEmpleado(String email) throws BLException;
	
	/**
	 * Metodo que actualiza un empleado exista en la base de datos
	 * @throws MyDaoException
	 */
	public void actualizarEmpleado(String cedula,String name ,String lastname ,Double salary ,String email,String password) throws BLException;

	/**
	 * Método que lista todos los empleados.
	 * @return
	 */
	public List<Employee> ObtenerTodosEmpleados() throws BLException;

}
