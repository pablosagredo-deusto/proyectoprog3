package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ManagerDB {
	Connection conn = null;
	private static boolean LOGGING = true;
	

	// METODO PARA CONECTAR CON LA BASE DE DATOS
	public void connect(String nombreDB) throws ExceptionDB {
		String nombreBD = "jdbc:sqlite:/C:\\Users\\guill\\git\\proyectoprog3\\FoodEst\\lib\\FoodEstDB";
		try {

			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(nombreDB);

			log(Level.INFO, "Conectada base de datos " + nombreBD, null);
		} catch (ClassNotFoundException | SQLException e) {
			log( Level.SEVERE, "Error en conexion de base de datos " + nombreBD, e );
		}
	}

	// METODO PARA DESCONECTAR CON LA BASE DE DATOS
	public void disconnect() throws ExceptionDB {
		try {
			conn.close();
			log(Level.INFO, "Desconectado de la base de datos ", null);
		} catch (SQLException e) {
			log(Level.SEVERE, "Error cerrando la conexión con la BD", e);
			
		}
	}

	// OBTENER TODOS LOS USUARIOS DE LA BASE DE DATOS
	public List<Usuario> getTodosUsuarios() throws ExceptionDB {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String SQL="";
		try (Statement stmt = conn.createStatement()) {
			SQL="SELECT NOMBRE_USUARIO, APELLIDO_USUARIO, CONTRASEÑA_USUARIO, ID_USUARIO FROM USUARIO";
			ResultSet rs = stmt.executeQuery(SQL);
		
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(rs.getString("NOMBRE_USUARIO"));
				usuario.setApellido(rs.getString("APELLIDO_USUARIO"));
				usuario.setContraseña(rs.getString("CONTRASEÑA_USUARIO"));
				usuario.setId(rs.getInt("ID_USUARIO"));
				usuarios.add(usuario);
			}
			log( Level.INFO, "Buscando usuarios\t" + SQL, null );

			return usuarios;
		} catch (SQLException | DateTimeParseException e) {
			log( Level.SEVERE, "Buscando usuarios\t" + SQL, e );
			throw new ExceptionDB("Error obteniendo los usuarios'", e);
			
		}
	}

	public List<Restaurante> getTodosRestaurantes() throws ExceptionDB {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		String SQL="";
		try (Statement stmt = conn.createStatement()) {
			SQL="SELECT * FROM RESTAURANTE";
			ResultSet rs = stmt.executeQuery(SQL);
			log( Level.INFO, "BD tipo buscado\t" + SQL, null );
			while (rs.next()) {
				Restaurante restaurante = new Restaurante();
				restaurante.setNombre(rs.getString("NOMBRE_RESTAURANTE"));
				restaurante.setCategoria(rs.getString("CATEGORIA_RESTAURANTE")); // esto esta dando problemas -->
																					// revisar
				restaurante.setContraseña(rs.getString("CONTRASEÑA_RESTAURANTE"));
				restaurante.setId(rs.getInt("ID_RESTAURANTE"));
				restaurante.setDireccion(rs.getString("DIRECCION_RESTAURANTE"));
				if (rs.getInt("ENVIO_GRATIS") == 1)
					restaurante.setEnviogratis(true);

				restaurantes.add(restaurante);
			}

			return restaurantes;
		} catch (SQLException | DateTimeParseException e) {
			
			throw new ExceptionDB("Error obteniendo los restaurantes", e);
		}
	}

	public List<Direccion> getTodasDirecciones() throws ExceptionDB {
		List<Direccion> direcciones = new ArrayList<Direccion>();
		String SQL="";
		try (Statement stmt = conn.createStatement()) {
			SQL="SELECT * FROM DIRECCION";
			ResultSet rs = stmt.executeQuery(SQL);
			log( Level.INFO, "Buscar direcciones\t" + SQL, null );
			while (rs.next()) {
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

	private static Logger logger = null;

	// Metodo local para el logger
	private static void log(Level level, String msg, Throwable excepcion) {
		if (!LOGGING)
			return;
		if (logger == null) { // Logger por defecto local:
			logger = Logger.getLogger(ManagerDB.class.getName()); // Nombre del logger - el de la clase
			logger.setLevel(Level.ALL); // Loguea todos los niveles
		}
		if (excepcion == null)
			logger.log(level, msg);
		else
			logger.log(level, msg, excepcion);
	}

}