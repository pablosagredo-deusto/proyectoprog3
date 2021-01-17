package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import clases.Direccion;

public class DireccionTest {

	Direccion direccion;
	
	@Before
	public void setUp() {
		Direccion direccion = new Direccion("Direccion1", 1, "C GRAN VIA", "Bilbao", 3, "1A", 48910);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Direccion1", direccion.getNombre());
	}
	
	@Test
	public void testGetDireccion() {
		assertEquals(1, direccion.getIdUsuario());
	}
	
	@Test
	public void testGetCalle() {
		assertEquals("C GRAN VIA", direccion.getCalle());
	}
	
	@Test
	public void testGetMunicipio() {
		assertEquals("Bilbao", direccion.getMunicipio());
	}
	
	@Test
	public void testGetPostal() {
		assertEquals(3, direccion.getPortal());
	}
	@Test
	public void testGetPisoPuerta() {
		assertEquals("1A", direccion.getPisoPuerta());
	}
	@Test
	public void testCodigoPostal() {
		assertEquals(48950, direccion.getCodigoPostal());
	}
}
