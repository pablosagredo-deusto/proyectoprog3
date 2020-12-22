package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;




public class ManagerDB {
	Connection conn = null; 
	
	//METODO PARA CONECTAR CON LA BASE DE DATOS
	public void connect() throws ExceptionDB{ 
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:/C:\\Users\\guill\\git\\proyectoprog3\\FoodEst\\lib\\FoodEstDB" );
		} catch (ClassNotFoundException e) {
			throw new ExceptionDB("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new ExceptionDB("Error conectando a la BD", e);
		}
	}
	
	//METODO PARA DESCONECTAR CON LA BASE DE DATOS
	public void disconnect() throws ExceptionDB {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new ExceptionDB("Error cerrando la conexi�n con la BD", e);
		}
	}
	
	//OBTENER TODOS LOS USUARIOS DE LA BASE DE DATOS
	public List<Usuario> getTodosUsuarios() throws ExceptionDB {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT NOMBRE_USUARIO, APELLIDO_USUARIO, CONTRASE�A_USUARIO, ID_USUARIO FROM USUARIO");

			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(rs.getString("NOMBRE_USUARIO"));
				usuario.setApellido(rs.getString("APELLIDO_USUARIO"));
				usuario.setContrase�a(rs.getString("CONTRASE�A_USUARIO"));
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuarios.add(usuario);
			}
			
			return usuarios;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los usuarios'", e);
		}
	}
	
	
	public List<Restaurante> getTodosRestaurantes() throws ExceptionDB {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM RESTAURANTE");

			while(rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setNombre(rs.getString("NOMBRE_RESTAURANTE"));
				restaurante.setCategoria(rs.getString("CATEGORIA_RESTAURANTE")); //esto esta dando problemas --> revisar
				restaurante.setContrase�a(rs.getString("CONTRASE�A_RESTAURANTE"));
				restaurante.setId(rs.getInt("ID_RESTAURANTE"));
				restaurante.setDireccion(rs.getString("DIRECCION_RESTAURANTE"));
				if(rs.getInt("ENVIO_GRATIS") == 1) restaurante.setEnviogratis(true);
				
				restaurantes.add(restaurante);
			}
			
			return restaurantes;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los restaurantes", e);
		}
	}
	
	public List<Direccion> getTodasDirecciones() throws ExceptionDB {
		List<Direccion> direcciones  = new ArrayList<Direccion>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM DIRECCION");

			while(rs.next()) {
				Direccion direccion = new Direccion();
				direccion.setNombre(rs.getString("NOMBRE_DIRECCION"));
				direccion.setCalle(rs.getString("CALLE_DIRECCION"));
				direccion.setMunicipio(rs.getString("MUNICPIO_DIRECCION"));
				direccion.setPortal(rs.getInt("PORTAL_DIRECCION"));
				direccion.setPisoPuerta(rs.getString("PISOPUERTA_DIRECCION"));
				direccion.setCodigoPostal(rs.getInt("CODIGOPOSTAL_DIRECCION"));
				
				direcciones.add(direccion);
		
			}
			
			return direcciones;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los direcciones", e);
		}
		
		
	}
	
}