
package clases;

import java.util.ArrayList;
import java.util.List;


public class Producto {
	protected String nombre;
	protected int id;
	protected double precio;
	protected String decripcion;
	protected ArrayList<Ingrediente> ingredientes;
	protected boolean vegano; 
	protected TipoProducto tipo;
	protected Restaurante restaurante;
	
	
	
	
	public Producto(String nombre,int id, double precio, String decripcion, ArrayList<Ingrediente> ingredientes,
			boolean vegano, TipoProducto tipo, Restaurante restaurante) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.precio = precio;
		this.decripcion = decripcion;
		this.ingredientes = ingredientes;
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
		this.decripcion = "";
		this.ingredientes = new ArrayList<Ingrediente>();
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

	public String getDecripcion() {
		return decripcion;
	}

	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return this.ingredientes;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
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


	@Override
	public String toString() {
		return nombre +" "+ precio + "€";
	}
	
	
	
}
