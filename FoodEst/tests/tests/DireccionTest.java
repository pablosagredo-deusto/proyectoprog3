package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import clases.Direccion;
import clases.Ingrediente;
import clases.TipoProducto;

public class DireccionTest {

	Direccion direccion;
	
	@Before
	public void setUp() {
		
		direccion = new Direccion("CASA", "C/Deusto/Calle Mayor/3/1A", null, 48760, null, 0);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("CASA", direccion.getNombre());
	}
	
	@Test
	public void testGetDireccion() {
		assertEquals("C/Deusto/Calle Mayor/3/1A", direccion.getDireccion());
	}
	
	@Test
	public void testGetCodigoPostal() {
		assertEquals("C/Deusto/Calle Mayor/3/1A", direccion.getDireccion());
	}
}
