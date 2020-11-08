package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.Articulo;
import clases.TipoProducto;
import clases.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class ArticuloTest {
	
	Articulo articulo;
	List<Ingrediente> ingredientes;
	
	
	@Before
	public void setUp() {
		
		ingredientes= new ArrayList<Ingrediente>();
		Ingrediente ing1 = new Ingrediente("Pepinillo", 001, 20);
		Ingrediente ing2 = new Ingrediente("Bacon", 002, 150);
		ingredientes.add(ing1);
		ingredientes.add(ing2);
		articulo = new Articulo("Piza", 15.5, "prueba", ingredientes, false, TipoProducto.PIZZA);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Piza", articulo.getNombre());

	}
	/*
	  al ser un doble hay que poner un
	  valor de error (valor delta) que permita seguir
	  considerando iguales a los dos valores
	 */
	
	@Test
	public void testGetPrecio() {
		assertEquals(15.5, articulo.getPrecio(), 0.001); 
	}

	@Test
	public void testGetCaracteristica() {
		assertEquals("prueba", articulo.getCaracteristica());
	}

	@Test
	public void testGetIngredientes() {
		assertEquals(ingredientes, articulo.getIngredientes());
	}

	@Test
	public void testIsVegano() {
		assertEquals(false, articulo.isVegano());
	}

	@Test
	public void testGetTipo() {
		assertEquals(TipoProducto.PIZZA, articulo.getTipo());
	}

}
