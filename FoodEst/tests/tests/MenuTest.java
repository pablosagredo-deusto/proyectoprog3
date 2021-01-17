package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Direccion;
import clases.Menu;
import clases.Producto;

public class MenuTest {


	
	Menu menu;
	List<Producto> productos;
	@Before
	public void setUp() {
		productos = new ArrayList<Producto>();
		Producto pr1 = new Producto();
		Producto pr2 = new Producto();
		productos.add(pr1);
		productos.add(pr2);
		
		
		
		menu = new Menu("Menu1", 16.5, 1, 1, productos);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Menu1", menu.getNombre());	
	}
	@Test
	public void testGetPrecio() {
		assertEquals(16.5, menu.getPrecio(),0.05);	
	}
	@Test
	public void testGetId() {
		assertEquals(1, menu.getId());	
	}
	@Test
	public void testGetIdRestaurante() {
		assertEquals(1, menu.getIdRestaurante());	
	}
	
	@Test
	public void testGetProductos() {
		assertEquals(productos, menu.getProductos());	
	}
			
		
}
