
package clases;

import java.util.*;

public class Producto {
	protected String nombre;
	protected int id;
	protected double precio;
	protected String descripcion;
	protected String ingredientes;
	protected boolean vegano; 
	protected TipoProducto tipo;
	protected int idRestaurante;
	protected int idMenu;
	
	
	
	
	public Producto(String nombre,int id, double precio, String descripcion, String ingredientes,
			boolean vegano, TipoProducto tipo, int idRestaurante) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.ingredientes = ingredientes;
		this.vegano = vegano;
		this.tipo = tipo;
		this.idRestaurante = idRestaurante;
		this.idMenu = idMenu;
	}

	// NO TIENE MUCHO SENTIDO CREAR UN PRODUCTO VACIO
	public Producto() {
		super();
		this.nombre = "";
		this.id = 0;
		this.precio = 0;
		this.descripcion = "";
		this.ingredientes = "";
		this.vegano = false;
		this.tipo = TipoProducto.PRINCIPAL;
		this.idRestaurante = 0;
		this.idMenu = 0;
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public String toStringPrecio() {
		return nombre + " " + precio + "€";
	}

	@Override
	public String toString() {
		String resultado = nombre + "(" + precio + "€)" + "(" + getTipo().toString() + ")";
		if (vegano) {
			resultado = resultado + "(V)";
		}
		return resultado;
	}
	
	

}
