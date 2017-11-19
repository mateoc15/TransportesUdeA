package co.edu.udea.TransportesUdea.bl;

import java.util.List;

import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.dto.User;
/**
 * Interfaz que contiene todo los metodos usados en la logica para el usuario
 * @author Alejandro Isaza
 * @email alejandro.isazad@udea.edu.co
 *
 */
public interface UserBL {
	/**
	 * Metodo que valida que un usuario exista en la base de datos
	 * @param email
	 * @param pass
	 * @throws MyDaoException
	 */
	public User validarUsuario(String email, String password) throws BLException;


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
	public void crearUsuario(String cedula,String name ,String lastname ,String phone , String city ,String email,String password) throws BLException;
	
	/**
	 * Metodo que elimina un Usuario dato su email
	 * @param email
	 * @throws MyDaoException
	 */
	public void eliminarUsuario(String id) throws BLException;
	
	/**
	 * Metodo que actualiza un Usuario exista en la base de datos
	 * @throws MyDaoException
	 */
	public void actualizarUsuario(String cedula,String name ,String lastname , String city ,String phone ,String email,String password) throws BLException;

	/**
	 * Metodo que lista todos los Usuarios.
	 * @return
	 */
	public List<User> ObtenerTodosUsuarios() throws BLException;

}
