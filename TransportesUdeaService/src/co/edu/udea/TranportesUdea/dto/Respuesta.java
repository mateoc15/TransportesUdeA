package co.edu.udea.TranportesUdea.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * clase dto para el usuario usado en los servicios
 * @author Alejandro Isaza
 * @email alejandro.isazad@udea.edu.co
 *
 */
@XmlRootElement(name="Respuesta")
public class Respuesta {
	private boolean estado;
    private String dato;
    private String tipo;
    private String id;
	 
	public Respuesta() {
		super();
	}

	public Respuesta(boolean estado, String dato, String tipo, String id) {
		super();
		this.estado = estado;
		this.dato = dato;
		this.tipo = tipo;
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}






}
