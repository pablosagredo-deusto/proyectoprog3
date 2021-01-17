package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.Producto;
import clases.TipoProducto;

public class ProductoTest {
	
	
	Producto pr;
	@Before
	public void setUp() {
		pr = new Producto("Producto1", 1, 10.9, "Descripcion producto1", "ingrediente1, ingrediente1", true, TipoProducto.ENTRANTE, 2);
		
	}
	@Test
	public void testGetNombre() {
		assertEquals("Producto1", pr.getNombre());	
	}
	@Test
	public void testGetId() {
		assertEquals(1, pr.getId());	
	}
	@Test
	public void testGetDescripcion() {
		assertEquals("Descripcion producto1", pr.getDescripcion());	
	}
	@Test
	public void testGetIngredientes() {
		assertEquals("ingrediente1, ingrediente1", pr.getIngredientes());	
	}
	@Test
	public void testIsVegano() {
		assertEquals(true, pr.isVegano());	
	}
	@Test
	public void testGetTipoProducto() {
		assertEquals(TipoProducto.ENTRANTE, pr.getTipo());	
	}
	@Test
	public void testGetIdRestaurante() {
		assertEquals(2, pr.getIdRestaurante());	
	}

}
