package clases;

import java.util.ArrayList;

public class Usuario {
	protected String nombreUsuario;
	protected String nombre;
	protected String apellido;
	protected String contrase�a;
	protected int id;
	protected ArrayList<Restaurante> restaurantesGuardados;
	protected ArrayList<Pedido> pedidos;

	public Usuario(String nombreUsuario, String nombre, String apellido, String contrase�a, int id, ArrayList<Pedido> pedidos,
			ArrayList<Restaurante> restaurantesGuardados) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrase�a = contrase�a;
		this.id = id;
		this.pedidos = pedidos;
		this.restaurantesGuardados = restaurantesGuardados;
	}

	public Usuario() {
		super();
		this.nombreUsuario = "";
		this.nombre = "";
		this.apellido = "";
		this.contrase�a = "";
		this.id = 0;
		this.pedidos = new ArrayList<Pedido>();
		this.restaurantesGuardados = new ArrayList<Restaurante>();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
