package clases;

public class Ingrediente {
	protected String nombre;
	protected int id;

	protected int calorias;

	public Ingrediente(String nombre, int id, int calorias) {
		super();
		this.nombre = nombre;
		this.id = id;

		this.calorias = calorias;
	}

	public Ingrediente() {
		super();
		this.nombre = "";
		this.id = "";

		this.calorias = 0;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", id=" + id + ", tipo="  + ", calorias=" + calorias + "]";
	}
	
	

}
