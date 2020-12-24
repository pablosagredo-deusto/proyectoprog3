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
		Direccion direccionRestaurante = new  Direccion("BurgerKingDirec", "C/Leioa/Calle Menor/8/00", null, 48750, null, 0);
		
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
		
		
		
		Producto Pizza1 = new Producto("Piza", 001, 15.5, "pizza", null, false,  TipoProducto.PIZZA, null);
		//("Piza", 15.5, "prueba", ingredientesPizza, false, TipoProducto.PIZZA);
		Producto Hamburguesa1= new Producto("Hamburguesa", 002, 15.5, "Hamburguesa", null, false,  TipoProducto.HAMBURGUESA, null);
		
		
		productosBurgerKing.add(Pizza1);
		productosBurgerKing.add(Hamburguesa1);
		
		Restaurante restaurante = new Restaurante("BurgerKing", "Comida rapida", 001, direccionRestaurante, productosBurgerKing, false);
		
		Direccion direccionPedido = new  Direccion("CASA", "C/Deusto/Calle Mayor/3/1A", 48760);
		List<Articulo> productosPedido = new ArrayList<>();
		productosPedido.add(Pizza1);
		
		Pedido pedido = new Pedido(001, restaurante, direccionPedido, "enviado", EstadoPedido.OTRO, productosPedido);
	}
	
	@Test
	public void testGetCodigoPostal() {
		assertEquals("C/Deusto/Calle Mayor/3/1A", direccion.getDireccion());
	}
	
	

}

