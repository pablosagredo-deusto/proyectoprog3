package tests;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import clases.Ingrediente;
import clases.TipoProducto;
import junit.framework.TestCase;

public class IngredienteTest extends TestCase{

	Ingrediente ing1;
	String nombre ;
	int id;
	int calorias;

	@Before
	public void setUp() {
		
		ing1 = new Ingrediente("Pepinillo", 001, 20);
		nombre = ing1.getNombre();
		id = ing1.getId();
		calorias = ing1.getCalorias();

	}

	@Test
	public void testGetNombre() {
		assertEquals("Deberia ser pepinillo","Pepinillo", nombre);
		

	}

	@Test
	public void testGetId() {
		assertEquals(001, id);

	}

	@Test
	public void testGetCalorias() {
		assertEquals(20, calorias);

	}

}
