package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.TipoProducto;
import clases.Ingrediente;
import clases.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoTest {
	
	Producto producto;
	List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	
	@Before
	public void setUp() {
		
		ingredientes= new ArrayList<Ingrediente>();
		Ingrediente ing1 = new Ingrediente("Pepinillo", 001, 20);
		Ingrediente ing2 = new Ingrediente("Bacon", 002, 150);
		ingredientes.add(ing1);
		ingredientes.add(ing2);
		Producto producto = new Producto("Piza", 001, 15.5, "pizza", ingredientes, false,  TipoProducto.PIZZA, null);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Piza", producto.getNombre());

	}
	/*
	  al ser un doble hay que poner un
	  valor de error (valor delta) que permita seguir
	  considerando iguales a los dos valores
	 */
	
	@Test
	public void testGetPrecio() {
		assertEquals(15.5, producto.getPrecio(), 0.001); 
	}

	

	@Test
	public void testGetIngredientes() {
		assertEquals(ingredientes, producto.getIngredientes());
	}

	@Test
	public void testIsVegano() {
		assertEquals(false, producto.isVegano());
	}

	@Test
	public void testGetTipo() {
		assertEquals(TipoProducto.PIZZA, producto.getTipo());
	}

}
