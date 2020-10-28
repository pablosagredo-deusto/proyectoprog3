package clases;

import java.util.ArrayList;

public class Pedido {
	int id;
	String restaurante;
	String direccion;
	String estado;
	ArrayList<Articulo> articulos;
	float preciototal;
	String metodopago;

	public Pedido(int id, String restaurante, String direccion, String estado, ArrayList<Articulo> articulos,
			float preciototal, String metodopago) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.direccion = direccion;
		this.estado = estado;
		this.articulos = articulos;
		this.preciototal = preciototal;
		this.metodopago = metodopago;
	}
	
	public Pedido() {
		super();
		this.id = 0;
		this.restaurante = "";
		this.direccion = "";
		this.estado = "";
		this.articulos = new ArrayList<Articulo>();
		this.preciototal = 0;
		this.metodopago = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	public float getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(float preciototal) {
		this.preciototal = preciototal;
	}

	public String getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}

}