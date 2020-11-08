package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurante {
	protected String nombre;
	protected String categoria;
	protected int id;
	protected Direccion direccion;
	protected List<Articulo> articulos;
	protected boolean enviogratis;
	
	
	public Restaurante(String nombre, String categoria, int id, Direccion direccion, List<Articulo> articulos,
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
		this.direccion = new Direccion();
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Articulo> getArticulos() {
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

	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", categoria=" + categoria + ", id=" + id + ", direccion=" + direccion
				+ ", articulos=" + articulos + ", enviogratis=" + enviogratis + "]";
	}
	
	
	
	
	

}
