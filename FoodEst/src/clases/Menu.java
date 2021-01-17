package clases;
import java.util.ArrayList;
import java.util.List;




public class Menu {
	protected String nombre;
	protected Double precio;
	protected int id;
	protected int idRestaurante;
	protected List<Producto> productos;
	
	public Menu(String nombre, Restaurante restaurante, Double precio, int idRestaurante, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.precio= precio;
		this.id= id;
		this.idRestaurante= idRestaurante;
		this.productos = productos;
		
	}
	public Menu() {
		super();
		this.nombre = "";
		this.precio= 0.0;
		this.id = 0;
		this.idRestaurante= 0;
		this.productos = null;

	}
	public int getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//calcula el precio para el menu, sumando el de todos sus productos
	public void calcularPrecio() {
		double precioMenu = 0.0;
		for (Producto producto : productos) {
			precioMenu = precioMenu + producto.getPrecio();
		}
		
		this.precio = precioMenu;
	}
	@Override
	public String toString() {
		return "Menu: " + nombre + " (" +  precio + "€)";
	}

	

}
