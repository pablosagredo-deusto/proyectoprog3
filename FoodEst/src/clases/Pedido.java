package clases;

import java.util.*;

public class Pedido {
	Usuario usuario;
	int id;
	Restaurante restaurante;
	Direccion direccion;
	EstadoPedido estado;
	List<Producto> productos;
	double preciototal;
	String metodoPago;
	boolean cubiertos;

	public Pedido(int id, Usuario usuario, Restaurante restaurante, Direccion direccion, EstadoPedido estado, List<Producto> productos,
			double preciototal, String metodoPago, boolean cubiertos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.direccion = direccion;
		this.estado = estado;
		this.productos = productos;
		for (Producto producto : productos) {
			preciototal=+producto.getPrecio();
		}
		this.preciototal = preciototal;
		this.metodoPago = metodoPago;
		this.cubiertos = cubiertos;
	}

	public Pedido() {
		super();
		this.id = 0;
		this.restaurante = new Restaurante();
		this.usuario = new Usuario();
		this.direccion = new Direccion();
		this.estado = EstadoPedido.OTRO;
		this.productos = null;
		this.preciototal = 0;
		this.metodoPago = "";
		this.cubiertos = false;
	}

	public boolean isCubiertos() {
		return cubiertos;
	}

	public void setCubiertos(boolean cubiertos) {
		this.cubiertos = cubiertos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMetodoPago() {
		return metodoPago;
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

	public List<Producto> getArticulos() {
		return productos;
	}

	public void setArticulos(List<Producto> productos) {
		this.productos = productos;
	}

	public double getPreciototal() {
		return preciototal;
	}

	public void setPreciototal(double preciototal) {
		this.preciototal = preciototal;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getMetodopago() {
		return metodoPago;
	}

	@Override
	public String toString() {
		return "Pedido" + id + ", restaurante=" + restaurante + ", direccion=" + direccion + ", estado=" + estado
				+ ", articulos=" + productos + ", preciototal=" + preciototal + ", metodopago=" + metodoPago
				+ ", cubiertos=" + cubiertos + "";
	}
	
	public String toStringProductos() {
		return  "Productos" + productos + ", preciototal=" + preciototal + "";
	}

	public Object getCubiertos() {
		return cubiertos;
	}

}
