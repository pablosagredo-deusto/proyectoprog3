package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.*;

public class PedidoTest {
	Producto Pizza1;
	Producto Hamburguesa1;
	List<Producto> productosBurgerKing;
	List<Ingrediente> ingredientesPizza;
	List<Ingrediente> ingredientesHamburguesa;
	Ingrediente ing1 ;
	Ingrediente ing2 ;
	Ingrediente ing3 ;
	Ingrediente ing4 ;
	Restaurante restaurante;
	Direccion direccionPedido;
	List<Producto> productosPedido;
	Pedido pedido1;
	

	@Before
	public void setUp() {

		Direccion direccionRestaurante = new Direccion("BurguerKingDir", "C/Leioa/Calle Menor/8/00", "Bilbao", 12, "3a",
				45006);
		List<Producto> productosBurgerKing = new ArrayList<Producto>();

		List<Ingrediente> ingredientesPizza = new ArrayList<Ingrediente>();
		List<Ingrediente> ingredientesHamburguesa = new ArrayList<Ingrediente>();
		Ingrediente ing1 = new Ingrediente("Pan", 001, 20);
		Ingrediente ing2 = new Ingrediente("Tomate", 002, 150);
		ingredientesPizza.add(ing1);
		ingredientesPizza.add(ing2);

		Ingrediente ing3 = new Ingrediente("Carne", 001, 20);
		Ingrediente ing4 = new Ingrediente("Pepinillo", 002, 150);
		ingredientesHamburguesa.add(ing3);
		ingredientesHamburguesa.add(ing4);

		Restaurante restaurante = new Restaurante("BurguerKing", "Comida rapida", "password", direccionRestaurante,
				productosBurgerKing, false);

		Producto Pizza1 = new Producto("Piza", 001, 15.5, "pizza", ingredientesPizza, false, TipoProducto.PIZZA, null);
		Producto Hamburguesa1 = new Producto("Hamburguesa", 002, 15.5, "Hamburguesa prueba", ingredientesHamburguesa,
				false, TipoProducto.HAMBURGUESA, null);

		productosBurgerKing.add(Pizza1);
		productosBurgerKing.add(Hamburguesa1);

		Direccion direccionPedido = new Direccion("BurguerKingDir", "C/Leioa/Calle Menor/8/00", "Bilbao", 12, "3a",
				45006);
		List<Producto> productosPedido = new ArrayList<Producto>();
		productosPedido.add(Pizza1);

		// list de pedidos problemos
		Pedido pedido1 = new Pedido(1, restaurante, direccionPedido, EstadoPedido.RECIBIDO, null, 50.5, "Efectivo", false);
	}

	@Test
	public void testGetCalle() {
		assertEquals("C/Deusto/Calle Mayor/3/1A", pedido1.getDireccion().getCalle());
	}

	
	@Test
	public void testGetId() {
		assertEquals(1, pedido1.getId());
	}

	@Test
	public void testGetRestaurante() {
		assertEquals(restaurante, pedido1.getRestaurante());
	}
	
	@Test
	public void testGetDireccion() {
		assertEquals(direccionPedido, pedido1.getDireccion());
	}
	
	@Test
	public void testGetEstado() {
		assertEquals(EstadoPedido.RECIBIDO, pedido1.getEstado());
	}
	
	
	@Test
	public void testGetProductos() {
		assertEquals(null, pedido1.getProductos());
	}
	
	
	@Test
	public void testGetPrecioTotal() {
		assertEquals(50.5, pedido1.getPreciototal(),0.001);
	}
	
	
	@Test
	public void testGetMetodoPago() {
		assertEquals("Efectivo", pedido1.getMetodopago());
	}
	
	
	@Test
	public void testGetCubiertos() {
		assertEquals(false,pedido1.getCubiertos());
	}
	
	
	@Test
	public void testToString() {
		assertEquals("",pedido1.toString());
	}
	
	

}
