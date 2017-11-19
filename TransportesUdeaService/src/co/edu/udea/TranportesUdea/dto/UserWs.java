package co.edu.udea.TranportesUdea.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase dto para el usuario usado en los servicios
 * @author Alejandro Isaza
 * @email alejandro.isazad@udea.edu.co
 *
 */
@XmlRootElement(name="usuario")
public class UserWs {
	String id;
	String name;
	String lastName;
	String phone;
	String city;
	String email;
	 
	public UserWs() {
		super();
	}

	public UserWs(String id,String name, String lastName, String phone, String city, String email) {
		super();
		this.id=id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.city = city;
		this.email = email;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
