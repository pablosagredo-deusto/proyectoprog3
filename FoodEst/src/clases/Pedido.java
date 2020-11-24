package clases;

import java.util.ArrayList;

public class Pedido {
	int id;
	Restaurante restaurante;
	Direccion direccion;
	EstadoPedido estado;
	ArrayList<Producto> productos;
	float preciototal;
	String metodoPago;
	boolean cubiertos;

	public Pedido(int id, Restaurante restaurante, Direccion direccion, EstadoPedido estado, ArrayList<Producto> productos,
			float preciototal, String metodoPago,boolean cubiertos) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.direccion = direccion;
		this.estado = estado;
		this.productos = productos;
		
		this.preciototal = preciototal;
		this.metodoPago = metodoPago;
		this.cubiertos=cubiertos;
	}
	
	public Pedido() {
		super();
		this.id = 0;
		this.restaurante = new Restaurante();
		this.direccion = new Direccion();
		this.estado = EstadoPedido.OTRO;
		this.productos = new ArrayList<Producto>();
		this.preciototal = 0;
		this.metodoPago = "";
		this.cubiertos=false;
	}

	public boolean isCubiertos() {
		return cubiertos;
	}

	public void setCubiertos(boolean cubiertos) {
		this.cubiertos = cubiertos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public ArrayList<Producto> getArticulos() {
		return productos;
	}

	public void setArticulos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public float getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(float preciototal) {
		this.preciototal = preciototal;
	}

	public String getMetodopago() {
		return metodoPago;
	}

	public void setMetodopago(String metodopago) {
		this.metodoPago = metodopago;
	}

	@Override
	public String toString() {
		return "Pedido" + id + ", restaurante=" + restaurante + ", direccion=" + direccion + ", estado=" + estado
				+ ", articulos=" + productos + ", preciototal=" + preciototal + ", metodopago=" + metodoPago
				+ ", cubiertos=" + cubiertos + "";
	}
	

}
