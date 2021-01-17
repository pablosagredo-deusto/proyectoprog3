package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Producto;
import clases.Restaurante;
import clases.TipoProducto;

public class RestauranteTest {
	
	Restaurante res;
	List<Producto> productos;
	@Before
	public void setUp() {
		
		productos = new ArrayList<Producto>();
		
		Producto pr1 = new Producto();
		Producto pr2 = new Producto();
		productos.add(pr1);
		productos.add(pr2);
		
		res = new Restaurante("Restaurante", "categoria", "contraseña", "direccion", productos, false);
	}
	
	
	@Test
	public void testGetNombre() {
		assertEquals("Restaurante", res.getNombre());	
	}
	@Test
	public void testGetCategoria() {
		assertEquals("categoria", res.getCategoria());	
	}
	
	@Test
	public void testGetContraseña() {
		assertEquals("contraseña", res.getContrasena());	
	}
	@Test
	public void testGetDireccion() {
		assertEquals("direccion", res.getDireccion());	
	}
	@Test
	public void testIsEnvioGratis() {
		assertEquals(false, res.isEnviogratis());	
	}

}
