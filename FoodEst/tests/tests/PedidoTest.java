package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.*;

public class PedidoTest {

	@Before
	public void setUp() {
		
		Direccion direccionRestaurante = new  Direccion("BurguerKingDir", "C/Leioa/Calle Menor/8/00", "Bilbao",12, "3a", 45006);
		List<Producto> productosBurgerKing = new ArrayList<>();
        	
		
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
		
		Restaurante restaurante =new Restaurante("BurguerKing", "Comida rapida", "password" , direccionRestaurante, productosBurgerKing, false);
	
		Producto Pizza1 = new Producto("Piza", 001, 15.5, "pizza", ingredientesPizza, false,  TipoProducto.PIZZA, null);
		Producto Hamburguesa1= new Producto("Hamburguesa", 002, 15.5, "Hamburguesa prueba", ingredientesHamburguesa, false,  TipoProducto.HAMBURGUESA, null);
		
		productosBurgerKing.add(Pizza1);
		productosBurgerKing.add(Hamburguesa1);
		
		
		
		
		Direccion direccionPedido = new  Direccion("BurguerKingDir", "C/Leioa/Calle Menor/8/00", "Bilbao",12, "3a", 45006);
		List<Producto> productosPedido = new ArrayList<>();
		productosPedido.add(Pizza1);
		
		Pedido pedido = new Pedido(1, restaurante, direccionPedido, null, productosBurgerKing, 50, "Efectivo", false);
	}
	
	@Test
	public void testGetCodigoPostal() {
		assertEquals("C/Deusto/Calle Mayor/3/1A", Direccion.getDireccion());
	}
	
	

}

