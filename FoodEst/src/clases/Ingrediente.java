package clases;

public class Ingrediente {
<<<<<<< HEAD
	String nombre;
	String id;
	String tipo;

	public Ingrediente(String nombre, String id, String tipo) {
=======
	protected String nombre;
	protected int id;
	protected int calorias;

	public Ingrediente(String nombre, int id, int calorias) {
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
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
