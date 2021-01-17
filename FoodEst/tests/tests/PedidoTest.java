package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Direccion;
import clases.EstadoPedido;
import clases.Menu;
import clases.Pedido;
import clases.Producto;
import clases.Restaurante;
import clases.Usuario;

public class PedidoTest {

	
	Pedido pedido;
	List<Menu> menus;
	List<Producto> productos;
	Usuario us ;
	Direccion dir ;
	Restaurante res;
	
	@Before
	public void setUp() {
		
		pedido = new Pedido();
		
		//Lista de productos
		productos = new ArrayList<Producto>();
		
		Producto pr1 = new Producto();
		Producto pr2 = new Producto();
		productos.add(pr1);
		productos.add(pr2);
		
		
		//Lista de menus
		menus = new ArrayList<Menu>();
		
		
		Menu menu1 = new Menu();
		List<Producto> productosMenu1 = new ArrayList<Producto>();
		Producto pr11 = new Producto();
		Producto pr12 = new Producto();
		productosMenu1.add(pr11);
		productosMenu1.add(pr12);
		menu1.setProductos(productosMenu1);
		
		
		Menu menu2 = new Menu();
		List<Producto> productosMenu2 = new ArrayList<Producto>();
		Producto pr21 = new Producto();
		Producto pr22 = new Producto();
		productosMenu1.add(pr21);
		productosMenu1.add(pr22);
		menu2.setProductos(productosMenu2);
		
		
		menus.add(menu1);
		menus.add(menu2);


		
		Usuario us = new Usuario();
		Direccion dir = new Direccion();
		Restaurante res = new Restaurante();
		

		
		pedido = new Pedido(1, us, res, dir, EstadoPedido.ENTREGADO, productos, menus, 20.4, "Tarjeta", false);
	}
	@Test
	public void testGetId() {
		assertEquals(1, pedido.getId());	
	}
	@Test
	public void testGetUsuario() {
		assertEquals(us, pedido.getUsuario());	
	}
	
	@Test
	public void testGetRestaurante() {
		assertEquals(res, pedido.getRestaurante());	
	}
	
	@Test
	public void testGetDireccion() {
		assertEquals(dir, pedido.getDireccion());	
	}

	@Test
	public void testGetEstadoPedido() {
		assertEquals(EstadoPedido.ENTREGADO, pedido.getEstado());	
	}
	
	@Test
	public void testGetProductos() {
		assertEquals(productos, pedido.getProductos());	
	}

	@Test
	public void testGetPrecioTotal() {
		assertEquals(20.4, pedido.getPreciototal(), 0.05);	
	}
	@Test
	public void testGetMetodoPago() {
		assertEquals("Tarjeta", pedido.getMetodopago());	
		
	}
	@Test
	public void testisCubiertos() {
		assertEquals(false, pedido.isCubiertos());	
		
	}
	
	
}
