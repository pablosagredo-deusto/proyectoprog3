package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurante {
	protected String nombre;
	protected String categoria;
	protected int id;
	protected Direccion direccion;
	protected List<Producto> productos;
	protected boolean enviogratis;
	
	
	public Restaurante(String nombre, String categoria, int id, Direccion direccion, List<Producto> productos,
			boolean enviogratis) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.id = id;
		this.direccion = direccion;
		this.productos = productos;
		this.enviogratis = enviogratis;
	}
	
	public Restaurante() {
		super();
		this.nombre = "";
		this.categoria = "";
		this.id = 0;
		this.direccion = new Direccion();
		this.productos = new ArrayList<Producto>();
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

	public List<Producto> getArticulos() {
		return productos;
	}

	public void setArticulos(ArrayList<Producto> productos) {
		this.productos = productos;
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
				+ ", articulos=" + productos + ", enviogratis=" + enviogratis + "]";
	}
	
	
	
	
	

}
