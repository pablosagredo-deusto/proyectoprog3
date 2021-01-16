package clases;

import java.util.ArrayList;

public class Usuario {
	protected String nombreUsuario;
	protected String nombre;
	protected String apellido;
	protected String contraseña;
	protected String email;
	protected int id;
	protected ArrayList<Restaurante> restaurantesGuardados;
	protected ArrayList<Pedido> pedidos;

	public Usuario(String nombreUsuario, String nombre, String apellido, String contraseña, String email,  int id, ArrayList<Pedido> pedidos,
			ArrayList<Restaurante> restaurantesGuardados) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.email = email;
		this.id = id;
		this.pedidos = pedidos;
		this.restaurantesGuardados = restaurantesGuardados;
	}

	public Usuario() {
		super();
		this.nombreUsuario = "";
		this.nombre = "";
		this.apellido = "";
		this.contraseña = "";
		this.email = "";
		this.id = 0;
		this.pedidos = new ArrayList<Pedido>();
		this.restaurantesGuardados = new ArrayList<Restaurante>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", id=" + id + "]";
	}
	

}
