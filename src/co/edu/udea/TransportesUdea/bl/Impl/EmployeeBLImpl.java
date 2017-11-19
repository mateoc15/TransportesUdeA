package co.edu.udea.TransportesUdea.bl.Impl;

import java.util.Date;
import java.util.List;

import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.bl.EmployeeBL;
import co.edu.udea.TransportesUdea.dao.EmployeeDao;
import co.edu.udea.TransportesUdea.dto.Employee;
import co.edu.udea.TransportesUdea.util.Validaciones;
import co.edu.udea.TransportesUdea.util.encode.Base64Coder;
/**
 * clase que implementa la interaz del empleado
 * @author alejo
 *
 */
public class EmployeeBLImpl implements EmployeeBL {
	
	EmployeeDao EmployeeDao;
	
	private static final int MIN_PASSWORD_LENGHT = 8;
	
	public EmployeeBLImpl(EmployeeDao EmployeeDao){
		this.EmployeeDao = EmployeeDao;
	}

	@Override
	public Employee validarEmpleado(String email, String password)
			throws BLException {
		
		String passCoded = null;
		Employee empleado = null;
		
		if (email == null || "".equals(email.trim())) {
			throw new NullPointerException("Debe especificar el email del empleado.");
        }
		
		if (!Validaciones.isEmail(email)) {
			throw new BLException("El email debe ser un correo electronico válido.");
		}
		
		if (password == null || "".equals(password.trim())) {
			throw new NullPointerException("Debe especificar la contrasena del empleado.");
        }
		
		if(password.length() < MIN_PASSWORD_LENGHT ){
			throw new BLException("La contraseña debe tener minimo "+MIN_PASSWORD_LENGHT+" caracteres.");
		}
        try{
		empleado = EmployeeDao.getEmployeeByEmail(email);
				
		passCoded = Base64Coder.encodeString(password);
		
		if (empleado == null || !passCoded.equals(empleado.getPassword())) {
			/**
			 * Se muestra el error sin mostrar información sensible.
			 */
			throw new BLException("Los datos proporcionados son incorrectos.");
		}
        }catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		return empleado;
	}

	@Override
	public void crearEmpleado(String cedula,String name, String lastname, Double salary,
			String email, String password)
			throws BLException {
		

		if (cedula == null || "".equals(cedula.trim())) {
			throw new NullPointerException("Debe especificar la cedula del empleado.");
        }
		if (name == null || "".equals(name.trim())) {
			throw new NullPointerException("Debe especificar el nombre del empleado.");
        }
		if (lastname == null || "".equals(lastname.trim())) {
			throw new NullPointerException("Debe especificar el apellido del empleado.");
        }
		if (salary == null ) {
			throw new NullPointerException("Debe especificar el salario del empleado.");
        }
		if (email == null || "".equals(email.trim())) {
			throw new NullPointerException("Debe especificar el email del empleado.");
        }
		if (password == null || "".equals(password.trim())) {
			throw new NullPointerException("Debe especificar la contrasena del empleado.");
        }
		
		if (!Validaciones.isEmail(email)) {
			throw new BLException("El email debe ser un correo electronico valido.");
		}
		
        try{
		Employee empleado = EmployeeDao.getEmployeeById(cedula);
		if(empleado != null){
			throw new BLException("Ya existe un empleado con esta cedula.");
		}
		 empleado = EmployeeDao.getEmployeeByEmail(email);
		if(empleado != null){
			throw new BLException("Ya existe un empleado con ese email.");
		}
		
	    empleado = new Employee();
	    empleado.setId(cedula);
	    empleado.setName(name);
	    empleado.setLastName(lastname);
	    empleado.setEmail(email);
	    empleado.setPassword(Base64Coder.encodeString(password));
	    empleado.setStartDate(new Date());
	    empleado.setSalary(salary);
	    EmployeeDao.saveEmployee(empleado);
	    
        }catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
	   

	}

	@Override
	public void eliminarEmpleado(String id) throws BLException {
		if (id == null || "".equals(id.trim())) {
			throw new NullPointerException("Debe especificar la cedula del empleado.");
        }
		
		try{
		Employee empleado = EmployeeDao.getEmployeeById(id);
		if(empleado == null){
			throw new BLException("No existe un empleado con esa cedula.");
		}
		
		EmployeeDao.deleteEmployee(id);
		
		}catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
	}
	
	@Override
	public void actualizarEmpleado(String cedula,String name, String lastname, Double salary,
			String email, String password)
			throws BLException  {
		

		if (cedula == null || "".equals(cedula.trim())) {
			throw new NullPointerException("Debe especificar la cedula del empleado.");
        }
		
		if (name == null && lastname == null && salary == null  && email == null && password == null  ) {
			throw new BLException("debe modificar algun campo.");
        }
		
		try{
			
		Employee empleado = EmployeeDao.getEmployeeById(cedula);
		if(empleado == null){
			throw new BLException("No existe un empleado con este email.");
		}
		
		if (!(name == null || "".equals(name.trim()))) {
			empleado.setName(name);
        }
		if (!(lastname == null || "".equals(lastname.trim()))) {
			empleado.setLastName(lastname);
        }
		if (!(salary == null )) {
			empleado.setSalary(salary);
        }
		if (!(email == null || "".equals(email.trim()))) {
			empleado.setEmail(email);
        }
		if (!(password == null || "".equals(password.trim()))) {
			empleado.setPassword(Base64Coder.encodeString(password));
        }
	    
		    EmployeeDao.updateEmployee(empleado);
		    
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		    

	}

	public List<Employee> ObtenerTodosEmpleados(){
		
		List<Employee> empleados = null;
		
		try {
			empleados = EmployeeDao.getAllEmployees();
		} catch (MyDaoException e) {
			// TODO manejo de excepcion
		}
		return empleados;
//		cambiar los nombres de los atributos en json sin cambiar los nombres de los atributos en el pojo
//		colocar setter para la inyeccion de dependencias
//		importar el proyecto de ProyectoIngweb en el deployment
		
		
	}
}
