package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Pedido;
import clases.Producto;
import clases.Restaurante;
import clases.Usuario;

public class UsuarioTest {
	
	
	Usuario us;
	ArrayList<Pedido> pedidos;
	ArrayList<Restaurante> restaurantes;
	@Before
	public void setUp() {
		
		pedidos = new ArrayList<Pedido>();
		
		Pedido p1 = new Pedido();
		Pedido p2 = new Pedido();
		pedidos.add(p1);
		pedidos.add(p2);
		
		
		restaurantes = new ArrayList<Restaurante>();
		
		Restaurante r1 = new Restaurante();
		Restaurante r2 = new Restaurante();
		restaurantes.add(r1);
		restaurantes.add(r2);
		
		
		
		us = new Usuario("Usuario1", "Usuario1", "Apellido1", "Contraseña", "Email", 1, pedidos, restaurantes);
		
	}
	@Test
	public void testGetNombre() {
		assertEquals("Usuario1", us.getNombre());	
	}
	@Test
	public void testGetNombreUsuario() {
		assertEquals("Usuario1", us.getNombreUsuario());	
	}
	@Test
	public void testGetApellido() {
		assertEquals("Usuario1", us.getApellido());	
	}
	@Test
	public void testGetEmail() {
		assertEquals("Email", us.getEmail());	
	}
	@Test
	public void testGetId() {
		assertEquals(1, us.getId());	
	}
	@Test
	public void testGetPedidos() {
		assertEquals(pedidos, us.getPedidos());	
	}
	@Test
	public void testGetRestaurantesGuardados() {
		assertEquals(restaurantes, us.getRestaurantesGuardados());	
	}


}
