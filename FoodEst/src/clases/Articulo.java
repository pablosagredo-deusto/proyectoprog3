
package clases;

import java.util.ArrayList;
import java.util.List;


public class Articulo {
	protected String nombre;
	protected double precio;
	protected String caracteristica;
	protected List<Ingrediente> ingredientes;
	protected boolean vegano; 
	protected TipoProducto tipo;
	
	
	
	
	public Articulo(String nombre, double precio, String caracteristica, List<Ingrediente> ingredientes,
			boolean vegano, TipoProducto tipo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.caracteristica = caracteristica;
		this.ingredientes = ingredientes;
		this.vegano = vegano;
		this.tipo = tipo;
	}
	
	public Articulo() {
		super();
		this.nombre = "";
		this.precio = 0;
		this.caracteristica = "";
		this.ingredientes = new ArrayList<Ingrediente>();
		this.vegano = false;
		this.tipo = tipo.OTRO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
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
		return nombre +" "+ precio + " €";
	}
	
	
	
}
