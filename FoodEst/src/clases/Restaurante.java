package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurante {
	protected String nombre;
	protected String categoria;
	protected String contrase�a;
	protected int id;
	public static int idContadorRestaurante = 0;
	protected String direccion;
	protected List<Producto> productos;
	protected boolean enviogratis;
	
	
	public Restaurante(String nombre, String categoria,String contrase�a, String direccion, List<Producto> productos,
			boolean enviogratis) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.contrase�a = contrase�a;
		this.id = idContadorRestaurante++;
		this.direccion = direccion;
		this.productos = productos;
		this.enviogratis = enviogratis;
	}
	
	public Restaurante() {
		super();
		this.nombre = "";
		this.categoria = "";
		this.contrase�a = "";
		this.id = idContadorRestaurante++;
		this.direccion ="";
		this.productos = new ArrayList<Producto>();
		this.enviogratis = false;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
