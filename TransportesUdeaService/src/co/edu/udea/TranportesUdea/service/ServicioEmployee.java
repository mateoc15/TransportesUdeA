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

import co.edu.udea.TranportesUdea.dto.EmployeeWs;
import co.edu.udea.TranportesUdea.dto.Respuesta;
import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.bl.EmployeeBL;
import co.edu.udea.TransportesUdea.dto.Employee;



/**
 * Clase en la cual se exponen los servicios relacionados con los empleados.
 * @author santiago
 * @email santiago.remirez9@udea.edu.co
 */
@Component // se anota con Component para que spring lo cargue.
@Path("employee")
public class ServicioEmployee {
	
	@Autowired
	EmployeeBL employeeBL;
	//colocar setter o constructor para la inyeccion de dependencias de employeeBL
	/**
	 * Getter necesario para la inyeccion de dependencias de EmployeeBL
	 * @return the employeeBL
	 */
	public EmployeeBL getEmployeeBL() {
		return employeeBL;
	}


	/**
	 * setter necesario para la inyeccion de dependencias de EmployeeBL
	 * @param employeeBL the employeeBL to set
	 */
	public void setEmployeeBL(EmployeeBL employeeBL) {
		this.employeeBL = employeeBL;
	}
	
	/**
	 * M�todo utilizado para ser invocado como servicio web REST
	 * que permite listar todos los empleados
	 * 
	 * @throws MyDaoException
	 * @throws BLException 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public List<EmployeeWs> obtenerEmpleados() throws MyDaoException, BLException{
		
		List<EmployeeWs> resultado = new ArrayList<>();
		List<Employee> datos = null;
		
		datos = employeeBL.ObtenerTodosEmpleados();
		for(Employee empleado:datos){
			resultado.add(new EmployeeWs(empleado.getName(), empleado.getLastName(), empleado.getId(), empleado.getEmail()));
		}
		return resultado;
	}
	


	/**
	 * Metodo utilizado para ser invocado como servicio web REST
	 * que permite validar un empleado
	 * 
	 * @param cedula identificacion del empleado que se va a crear
	 * @param name nombre del empleado que se va a crear
	 * @param lastname apellidos del empleado que se va a crear
	 * @param salary salario que tiene el empleado que se va a crear
	 * @param email	correo electronico del empleado que se crear�
	 * @param password contrase�a del empleado
	 * @throws MyDaoException
	 * @throws BLException 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("login")
	public Respuesta validarEmpleado(@QueryParam("user") String email,@QueryParam("pass") String password) throws MyDaoException, BLException{
		Respuesta respuesta = null;
		try{
		Employee employee = employeeBL.validarEmpleado(email, password);
		EmployeeWs employeeWs = new EmployeeWs(employee.getName(), employee.getLastName(), employee.getId(), employee.getEmail()); 
		respuesta = new Respuesta(true,employeeWs.getNombres(),"employee",employee.getId());
		return respuesta;
		}catch (BLException | NullPointerException e) {
			respuesta = new Respuesta(false,e.getMessage(),null,null);
			return respuesta;
		}
	}


	/**
	 * Metodo utilizado para ser invocado como servicio web REST
	 * que permite crear un empleado en el sistema
	 * 
	 * @param cedula identificacion del empleado que se va a crear
	 * @param name nombre del empleado que se va a crear
	 * @param lastname apellidos del empleado que se va a crear
	 * @param salary salario que tiene el empleado que se va a crear
	 * @param email	correo electronico del empleado que se crear�
	 * @param password contrase�a del empleado
	 * @throws MyDaoException
	 * @throws BLException 
	 */
	@POST
	@Path("crear")
	public Respuesta crearEmpleado(@QueryParam("cedula") String cedula, @QueryParam("nombre") String name, @QueryParam("apellidos") String lastname, @QueryParam("salario") Double salary, @QueryParam("email") String email, @QueryParam("password") String password) throws MyDaoException, BLException{
		Respuesta respuesta=null;
		try{
		 employeeBL.crearEmpleado(cedula, name, lastname, salary, email, password);
		 respuesta = new Respuesta(true,null,null,null);
		}catch (Exception e) {
		 respuesta = new Respuesta(false,e.getMessage(),null,null);
		}
		return respuesta;
	}

	
	 
    /**
     * Metodo utilizado para ser invocado como servicio web REST que permite actualizar un empleado en el sistema
     * @param cedula
     * @param name
     * @param lastname
     * @param salary
     * @param email
     * @param password
     * @return
     * @throws MyDaoException
     * @throws BLException
     */
	@PUT
	@Path("actualizar")
	public String actualizarEmpleado(@QueryParam("id") String cedula,@QueryParam("name") String name,@QueryParam("lastname") String lastname,@QueryParam("salary") Double salary,
			@QueryParam("email") String email,@QueryParam("pass") String password) throws MyDaoException, BLException{
		try{
		employeeBL.actualizarEmpleado(cedula,name,lastname,salary,email,password);
		}catch (BLException e) {
			return e.getMessage();
		}
		return "El Empleado ha sido actualizado satisfactoriamente";
	}
	
	/**
	 * Metodo utilizado para ser invocado como servicio web REST que permite eliminar un empleado en el sistema
	 * @param id
	 * @return
	 * @throws MyDaoException
	 * @throws BLException
	 */
	@DELETE
	@Path("eliminar")
	public String eliminarEmpleado(@QueryParam("id") String id) throws MyDaoException, BLException{
		try{
		employeeBL.eliminarEmpleado(id);
		}catch (BLException e) {
			return e.getMessage();
		}
		return "El Empleado ha sido eliminado satisfactoriamente";
	}
}
