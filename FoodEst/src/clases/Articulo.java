package clases;

import java.util.ArrayList;

enum Tipo{
	BEBIDA, HAMBURGUESA, PIZZA, RACIONES, OTRO
}


public class Articulo {
	protected String nombre;
	protected float precio;
	protected String caracteristica;
	protected ArrayList<Ingrediente> ingredientes;
	protected boolean vegano; 
	protected Tipo tipo;
	
	
	
	
	public Articulo(String nombre, float precio, String caracteristica, ArrayList<Ingrediente> ingredientes,
			boolean vegano, Tipo tipo) {
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public ArrayList<Ingrediente> getIngredientes() {
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	
	
	

}
