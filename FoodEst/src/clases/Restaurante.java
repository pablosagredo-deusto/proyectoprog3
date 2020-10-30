package clases;

import java.util.ArrayList;

public class Restaurante {
	String nombre;
	String categoria;
	int id;
	String direccion;
	ArrayList<Articulo> articulos;
	boolean enviogratis;
	public Restaurante(String nombre, String categoria, int id, String direccion, ArrayList<Articulo> articulos,
			boolean enviogratis) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.id = id;
		this.direccion = direccion;
		this.articulos = articulos;
		this.enviogratis = enviogratis;
	}
	
	public Restaurante() {
		super();
		this.nombre = "";
		this.categoria = "";
		this.id = 0;
		this.direccion = "";
		this.articulos = new ArrayList<Articulo>();
		this.enviogratis = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public boolean isEnviogratis() {
		return enviogratis;
	}

	public void setEnviogratis(boolean enviogratis) {
		this.enviogratis = enviogratis;
	}
	
	
	
	

}
