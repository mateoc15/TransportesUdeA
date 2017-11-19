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

import co.edu.udea.TranportesUdea.dto.Respuesta;
import co.edu.udea.TranportesUdea.dto.UserWs;
import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.bl.UserBL;
import co.edu.udea.TransportesUdea.dto.User;

/**
 * Clase en la cual se exponen los servicios relacionados con el usuario
 * @author Alejandro Isaza
 * @email alejandro.isazad@udea.edu.co
 *
 */
@Component // se anota con Component para que spring lo cargue.
@Path("user")
public class ServicioUser {
	
	@Autowired
	UserBL userBL;
	//colocar setter o constructor para la inyeccion de dependencias de UserBL
	/**
	 * Getter necesario para la inyeccion de dependencias de UserBL
	 * @return the UserBL
	 */
	public UserBL getUserBL() {
		return userBL;
	}


	/**
	 * setter necesario para la inyeccion de dependencias de UserBL
	 * @param UserBL the UserBL to set
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * Metodo utilizado para ser invocado como servicio web REST
	 * que permite listar todos los empleados
	 * 
	 * @throws MyDaoException
	 * @throws BLException 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public List<UserWs> obtenerUsuarios() throws MyDaoException, BLException{
		
		List<UserWs> resultado = new ArrayList<>();
		List<User> datos = null;
		
		datos = userBL.ObtenerTodosUsuarios();
		for(User user:datos){
			resultado.add(new UserWs(user.getId(),user.getName(), user.getLastName(), user.getPhone(),user.getCity(), user.getEmail()));
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
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("login")
	public Respuesta validarUsuario(@QueryParam("user") String email,@QueryParam("pass") String password) throws MyDaoException,BLException{
		Respuesta respuesta = null;
      try{
		User user = userBL.validarUsuario(email, password);
		UserWs UserWs = new UserWs(user.getId(),user.getName(), user.getLastName(), user.getPhone(),user.getCity(), user.getEmail()); 
		respuesta = new Respuesta(true, UserWs.getName(),"user",user.getId());
		return respuesta;
      }catch (BLException e) {
    	    respuesta = new Respuesta(false, e.getMessage(),null,null);
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
	public Respuesta crearUsuario(@QueryParam("cedula") String cedula, @QueryParam("nombre") String name, @QueryParam("apellidos") String lastname, @QueryParam("phone") String phone,@QueryParam("city") String city, @QueryParam("email") String email, @QueryParam("password") String password) throws MyDaoException, BLException{
		Respuesta respuesta=null;
		try{
			userBL.crearUsuario(cedula, name, lastname, phone,city, email, password);
			respuesta = new Respuesta(true,null,null,null);
		}catch (BLException e) {
			respuesta = new Respuesta(false,e.getMessage(),null,null);
		}
		return respuesta;
	}

	
	/**
	 * Metodo utilizado para ser invocado como servicio web REST que permite actualizar un usuario en el sistema
	 * @param cedula
	 * @param name
	 * @param lastname
	 * @param city
	 * @param phone
	 * @param email
	 * @param password
	 * @return
	 * @throws MyDaoException
	 * @throws BLException
	 */
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Path("actualizar")
	// antes era actualizarEmpleado estaba mal
	public String actualizarUsuario(@QueryParam("id") String cedula,@QueryParam("name") String name,@QueryParam("lastname") String lastname,@QueryParam("city") String city,@QueryParam("phone") String phone,
			@QueryParam("email") String email,@QueryParam("pass") String password) throws MyDaoException, BLException{
		try{
		userBL.actualizarUsuario(cedula, name, lastname, city, phone, email, password);
		}catch (BLException e) {
			return e.getMessage();
		}
		return "El Usuario ha sido actualizado satisfactoriamente";
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
	@Produces(MediaType.TEXT_PLAIN)
		public String eliminarUsuario(@QueryParam("id") String id) throws MyDaoException, BLException{
		try{
		userBL.eliminarUsuario(id);
		}catch (BLException e) {
			return e.getMessage();
		}
		return "El Empleado ha sido eliminado satisfactoriamente";
	}
}
