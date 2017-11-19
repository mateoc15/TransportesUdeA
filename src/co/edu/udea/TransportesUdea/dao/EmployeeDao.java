package co.edu.udea.TransportesUdea.dao;

import java.util.List;

import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.dto.Employee;

/**
 * 
 * @author Santiago - email:santiago.ramiress@gmail.com
 * 
 *
 */

public interface EmployeeDao {
	
	/**
	 * metodo para obtener un empleado a traves de su email
	 * @param emal
	 * @return
	 * @throws MyDaoException
	 */
	public Employee getEmployeeByEmail(String email) throws MyDaoException;
	
	/**
	 * metodo para obtener un empleado a traves de su id(cedula)
	 * @param id
	 * @return
	 * @throws MyDaoException
	 */
	public Employee getEmployeeById(String id) throws MyDaoException;
	
	/**
	 * metodo para agregar un nuevo empleado a la base de datos
	 * @param employee
	 * @throws MyDaoException
	 */
	public void saveEmployee(Employee employee) throws MyDaoException;

	/**
	 * metodo para realizar modificaciones a un empleado almacenado
	 * @param employee
	 * @throws MyDaoException
	 */
	public void updateEmployee(Employee employee) throws MyDaoException;
	
	/**
	 * metodo para eliminar un empleado de la base de datos dado su id
	 * @param id
	 * @throws MyDaoException
	 */
	public void deleteEmployee(String id) throws MyDaoException; 
	
	/**
	 *  metodo que permite obtener todos los empleados existentes en la base de datos
	 * @throws MyDaoException 
	 */
	public List<Employee> getAllEmployees() throws MyDaoException;
	
}
