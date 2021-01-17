package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurante {
	protected String nombre;
	protected String categoria;
	protected String contrasena;
	protected String direccion;
	protected List<Producto> productos;
	protected boolean enviogratis;

	protected int id;

	public Restaurante(String nombre, String categoria, String contrasena, String direccion, List<Producto> productos,
			boolean enviogratis) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.productos = productos;
		this.enviogratis = enviogratis;
	}

	public Restaurante() {
		super();
		this.nombre = "";
		this.categoria = "";
		this.contrasena = "";
		this.id = 0;
		this.direccion = null;
		this.productos = new ArrayList<Producto>();
		this.enviogratis = false;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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
