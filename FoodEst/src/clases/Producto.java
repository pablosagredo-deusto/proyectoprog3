
package clases;

import java.util.*;


public class Producto {
	protected String nombre;
	protected int id;
	protected double precio;
	protected String descripcion;
	protected boolean vegano; 
	protected TipoProducto tipo;
	protected Restaurante restaurante;
	
	
	
	
	public Producto(String nombre,int id, double precio, String descripcion,
			boolean vegano, TipoProducto tipo, Restaurante restaurante) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.vegano = vegano;
		this.tipo = tipo;
		this.restaurante = restaurante;
	}
	
	//NO TIENE MUCHO SENTIDO CREAR UN PRODUCTO VACIO
	public Producto() {
		super();
		this.nombre = "";
		this.id = 0;
		this.precio = 0;
		this.descripcion = "";
		this.vegano = false;
		this.tipo = TipoProducto.OTRO;
		this.restaurante = new Restaurante();
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

	public void setDescripcion(String decripcion) {
		this.descripcion = descripcion;
	}



	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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
		return nombre +" "+ precio + "€";
	}
	
	
	
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", id=" + id + ", precio=" + precio + ", decripcion=" + decripcion
				+ ", ingredientes=" + ingredientes + ", vegano=" + vegano + ", tipo=" + tipo + ", restaurante="
				+ restaurante + "]";
	}

	public static void main(String[] args) {
		
	}
	
	
}
