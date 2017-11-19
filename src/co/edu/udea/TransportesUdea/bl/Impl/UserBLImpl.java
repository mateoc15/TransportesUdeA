package co.edu.udea.TransportesUdea.bl.Impl;

import java.util.List;

import co.edu.udea.TransportesUdea.Exception.BLException;
import co.edu.udea.TransportesUdea.Exception.MyDaoException;
import co.edu.udea.TransportesUdea.bl.UserBL;
import co.edu.udea.TransportesUdea.dao.UserDao;
import co.edu.udea.TransportesUdea.dto.User;
import co.edu.udea.TransportesUdea.util.Validaciones;
import co.edu.udea.TransportesUdea.util.encode.Base64Coder;

/**
 * Esta clase contiene toda la logica de negocio 
 * que est� relacionada con los usuarios del sistema.
 * @author CristianCamilo
 *
 */	
public class UserBLImpl implements UserBL {

	private UserDao UserDao;

	private static final int MIN_PASSWORD_LENGHT = 8;
	
	/**
	 * M�todo constructor de la clase
	 * @param UserDao Objeto de tipo DAO 
	 * que ser� inyectado a traves del constructor
	 *  para el acceso a la capa de datos
	 */
	public UserBLImpl(UserDao usuarioDao) {
		this.UserDao = usuarioDao;
	}
	
	/**
	 * Este metodo valida que el usuario (email) y la contrase�a ingresados coincidan.
	 * @param email nombre de usuario
	 * @param password contrase�a 
	 * @return retorna un valor verdadero si el usuario
	 * y la contrase�a coinciden con los que se encuentran almacenados en la base de datos.
	 * @throws BLException 
	 */
	public User validarUsuario(String email, String password) throws BLException{
		
		User usuario = null;
		String passCoded = null;
					
		if (email == null || "".equals(email.trim())) {
			throw new BLException("Debe especificar un email.");
		}
		
		if (!Validaciones.isEmail(email)) {
			throw new BLException("El email debe ser un correo electronico v�lido.");
		}
		
		if(password == null || "".equals(password.trim())){
			throw new BLException("Debe especificar una contrase�a valida.");
		}
		
		if(password.length() < MIN_PASSWORD_LENGHT ){
			throw new BLException("La contrase�a debe tener minimo "+MIN_PASSWORD_LENGHT+" caracteres.");
		}

		try {
			usuario = UserDao.getuserByEmail(email);
		} catch (MyDaoException e) {
			// TODO: handle exception
			throw new BLException(e.getMessage());				
		}
			
		passCoded = Base64Coder.encodeString(password);
		
		if (usuario == null || !passCoded.equals(usuario.getPassword())) {
			/**
			 * Se muestra el error sin mostrar informaci�n sensible.
			 */
			throw new BLException("Los datos proporcionados son incorrectos.");
		}
		return usuario;
		
	}

	@Override
	public void crearUsuario(String cedula, String name, String lastname, String phone, String city, String email,
			String password) throws BLException {
		if (cedula == null || "".equals(cedula.trim())) {
			throw new NullPointerException("Debe especificar la cedula del user.");
        }
		if (name == null || "".equals(name.trim())) {
			throw new NullPointerException("Debe especificar el nombre del user.");
        }
		if (lastname == null || "".equals(lastname.trim())) {
			throw new NullPointerException("Debe especificar el apellido del user.");
        }
		if (phone == null || "".equals(phone.trim())) {
			throw new NullPointerException("Debe especificar el telefono del user.");
        }
		if (city == null || "".equals(city.trim())) {
			throw new NullPointerException("Debe especificar la ciudad del user.");
        }
		if (email == null || "".equals(email.trim())) {
			throw new NullPointerException("Debe especificar el email del user.");
        }
		if (password == null || "".equals(password.trim())) {
			throw new NullPointerException("Debe especificar la contrasena del user.");
        }
		
		if (!Validaciones.isEmail(email)) {
			throw new BLException("El email debe ser un correo electronico valido.");
		}
		
        try{
		User user = UserDao.getuserById(cedula);
		if(user != null){
			throw new MyDaoException("Ya existe un usuario con esta cedula.");
		}
		
		user = UserDao.getuserByEmail(email);
		if(user != null){
			throw new MyDaoException("Ya existe un usuario con este email.");
		}
		
	    user = new User();
	    user.setId(cedula);
	    user.setName(name);
	    user.setLastName(lastname);
	    user.setEmail(email);
	    user.setPassword(Base64Coder.encodeString(password));
	    user.setPhone(phone);
	    user.setCity(city);
	    
	    UserDao.saveUser(user);
        }
	    catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
	}

	@Override
	public void eliminarUsuario(String id) throws BLException {
		if (id == null || "".equals(id.trim())) {
			throw new NullPointerException("Debe especificar el email del user.");
        }
		try{
			
		User user = UserDao.getuserById(id);
		
		if(user == null){
			throw new BLException("No existe un usuario con esta cedula.");
		}
		
		UserDao.deleteUser(id);
		}
		catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		
	}

	@Override
	public void actualizarUsuario(String cedula, String name, String lastname, String city, String phone, String email,
			String password) throws BLException {
		
		if (cedula == null || "".equals(cedula.trim())) {
			throw new NullPointerException("Debe especificar la cedula del usuario.");
        }
		
		if (name == null && lastname == null && city == null  && phone == null && email == null && password == null  ) {
			throw new BLException("debe modificar algun campo.");
        }
		
		try{
			
		User usuario = UserDao.getuserById(cedula);
		
		if(usuario == null){
			throw new BLException("No existe un empleado con este email.");
		}
		
		if (!(name == null || "".equals(name.trim()))) {
			usuario.setName(name);
        }
		if (!(lastname == null || "".equals(lastname.trim()))) {
			usuario.setLastName(lastname);
        }
		if (!(city == null )) {
			usuario.setCity(city);
        }
		if (!(phone == null )) {
			usuario.setPhone(phone);
        }
		if (!(email == null || "".equals(email.trim()))) {
			usuario.setEmail(email);
        }
		if (!(password == null || "".equals(password.trim()))) {
			usuario.setPassword(Base64Coder.encodeString(password));
        }
	    
		UserDao.updateUser(usuario);
		    
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		
	}

	@Override
	public List<User> ObtenerTodosUsuarios() throws BLException{
        List<User> users = null;
		
		try {
			users = UserDao.getAllUsers();
		} catch (MyDaoException e) {
			throw new BLException(e.getMessage());
		}
		return users;

	}
}
