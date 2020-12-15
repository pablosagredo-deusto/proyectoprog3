package clases;

import java.util.ArrayList;

public class Usuario {
	protected String nombre;
	protected String apellido;
	protected String contraseña;
	protected int id;
	public static int idContadorUsuario = 0;
	protected ArrayList<Restaurante> restaurantesGuardados;
	protected ArrayList<Pedido> pedidos;

	public Usuario(String nombre, String apellido, String contraseña, ArrayList<Pedido> pedidos,
			ArrayList<Restaurante> restaurantesGuardados) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.id = idContadorUsuario++;
		this.pedidos = pedidos;
		this.restaurantesGuardados = restaurantesGuardados;
	}

	public Usuario() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.contraseña = "";
		this.id = idContadorUsuario++;
		this.pedidos = new ArrayList<Pedido>();
		this.restaurantesGuardados = new ArrayList<Restaurante>();
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Restaurante> getRestaurantesGuardados() {
		return restaurantesGuardados;
	}

	public void setRestaurantesGuardados(ArrayList<Restaurante> restaurantesGuardados) {
		this.restaurantesGuardados = restaurantesGuardados;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	

}
