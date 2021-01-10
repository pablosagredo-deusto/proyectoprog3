package clases;
import java.util.ArrayList;
import java.util.List;




public class Menu {
	String nombre;
	Double precio;
	int id;
	int idRestaurante;
	
	public Menu(String nombre, Restaurante restaurante, Double precio, int idRestaurante) {
		super();
		this.nombre = nombre;

		this.precio= precio;
		this.id= id;
		this.idRestaurante= idRestaurante;
		
	}
	public Menu() {
		super();
		this.nombre = "";

		this.precio= 0.0;
		this.id = 0;
		this.idRestaurante= 0;

	}
	public int getIdRestaurante() {
		return idRestaurante;
	}
	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
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

	

}
