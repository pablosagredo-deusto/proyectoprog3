package clases;

import java.io.Serializable;

public class Direccion implements Serializable{
	protected String nombre;
	protected String direccion;
	protected int codigoPostal;
	
	
	public Direccion(String nombre, String direccion, int codigoPostal) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
	}
	
	public Direccion() {
		super();
		this.nombre = "";
		this.direccion = "";
		this.codigoPostal = 0;
	}
	
	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
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

	@Override
	public String toString() {
		return nombre + " ("+ codigoPostal + ")" +": " +  direccion;
	}
	
	
	
	
	
}
