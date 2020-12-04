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
	boolean cubiertos;

	public Pedido(int id, String restaurante, String direccion, String estado, ArrayList<Articulo> articulos,
			float preciototal, String metodopago,boolean cubiertos) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.direccion = direccion;
		this.estado = estado;
<<<<<<< HEAD
		this.articulos = articulos;
=======
		this.productos = productos;
		
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
		this.preciototal = preciototal;
		this.metodopago = metodopago;
		this.cubiertos=cubiertos;
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

	@Override
	public String toString() {
		return "Pedido" + id + ", restaurante=" + restaurante + ", direccion=" + direccion + ", estado=" + estado
				+ ", articulos=" + articulos + ", preciototal=" + preciototal + ", metodopago=" + metodopago
				+ ", cubiertos=" + cubiertos + "";
	}
	

}
