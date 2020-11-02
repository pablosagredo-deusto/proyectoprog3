package clases;

import java.io.Serializable;

public class Ubicacion implements Serializable{
	protected String nombre;
	protected String direccion;
	
	
	public Ubicacion(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Ubicacion() {
		super();
		this.nombre = "";
		this.direccion = "";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
	
}
