package clases;

public class AdministracionDB {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JBDC ");
			
		} catch ( ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
		}

	}}
