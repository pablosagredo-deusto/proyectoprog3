package clases;

import java.io.Serializable;

public class Direccion implements Serializable{
	protected String nombre;
	protected String calle;
	protected String pueblo;
	protected int portal;
	protected String puerta;
	protected int codigoPostal;
	
	
	public Direccion(String nombre, String calle, String pueblo, int portal, String puerta, int codigoPostal) {
		super();
		this.nombre =  nombre;
		this.calle =  calle;
		this.pueblo =  pueblo;
		this.portal =  portal;
		this.puerta =  puerta;
		this.codigoPostal =  codigoPostal;
	}
	
	public Direccion() {
		super();
		this.nombre =  "";
		this.calle =  "";
		this.pueblo =  "";
		this.portal =  0;
		this.puerta =  "";
		this.codigoPostal =  0;
	}
	
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPueblo() {
		return pueblo;
	}

	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}

	public int getPortal() {
		return portal;
	}

	public void setPortal(int portal) {
		this.portal = portal;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
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

	@Override
	public String toString() {
		return "Direccion [nombre=" + nombre + ", calle=" + calle + ", pueblo=" + pueblo + ", portal=" + portal
				+ ", puerta=" + puerta + ", codigoPostal=" + codigoPostal + "]";
	}
	

}
