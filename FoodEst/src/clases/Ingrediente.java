package clases;

public class Ingrediente {
	String nombre;
	String id;
	String tipo;

	public Ingrediente(String nombre, String id, String tipo) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.tipo = tipo;
	}

	public Ingrediente() {
		super();
		this.nombre = "";
		this.id = "";
		this.tipo = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
