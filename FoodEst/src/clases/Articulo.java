package clases;

import java.util.ArrayList;

public class Articulo {
	String nombre;
	float precio;
	String caracteristica;
	ArrayList<Ingrediente> ingredientes;
	boolean vegano;
	public Articulo(String nombre, float precio, String caracteristica, ArrayList<Ingrediente> ingredientes,
			boolean vegano) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.caracteristica = caracteristica;
		this.ingredientes = ingredientes;
		this.vegano = vegano;
	}
	
	public Articulo() {
		super();
		this.nombre = "";
		this.precio = 0;
		this.caracteristica = "";
		this.ingredientes = new ArrayList<Ingrediente>();
		this.vegano = false;
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

	@Override
	public String toString() {
		return nombre +" "+ precio + " €";
	}
	
	
	

}
