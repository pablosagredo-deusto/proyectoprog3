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

	@Override
	public String toString() {
		return nombre +" "+ precio + " €";
	}
	
	
	

}
