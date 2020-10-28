package clases;

import java.util.ArrayList;

public class Usuario {
	String nombre;
	String apellido;
	int id;
	ArrayList<Pedido> pedidos;

	public Usuario(String nombre, String apellido, int id, ArrayList<Pedido> pedidos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.pedidos = pedidos;
	}

	public Usuario() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.id = 0;
		this.pedidos = new ArrayList<Pedido>();
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
