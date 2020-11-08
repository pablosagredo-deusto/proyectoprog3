package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import clases.Articulo;
import clases.Ingrediente;
import clases.TipoProducto;

public class IngredienteTest {

	Ingrediente ing1;
	
	@Before
	public void setUp() {
	
		ing1 = new Ingrediente("Pepinillo", 001, 20);
		
	}
	@Test
	public void testGetNombre() {
		assertEquals("Pepinillo", ing1.getNombre());

	}
	@Test
	public void testGetId() {
		assertEquals(001, ing1.getId());

	}
	@Test
	public void testGetCalorias() {
		assertEquals(20, ing1.getCalorias());

	}

}
