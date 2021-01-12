package clases;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;






public class ManagerDB {
	Connection conn = null;
	private static boolean LOGGING = true;
	

	// METODO PARA CONECTAR CON LA BASE DE DATOS
	public void connect() throws ExceptionDB {
		try {
			String nombreDB = "jdbc:sqlite:C:\\Users\\Usuario\\git\\proyectoprog3\\FoodEst\\lib\\FoodEstDB";
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(nombreDB);

			log(Level.INFO, "Conectada base de datos ", null);
		} catch (ClassNotFoundException | SQLException e) {
			log( Level.SEVERE, "Error en conexion de base de datos ", e );
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
			ResultSet rs = stmt.executeQuery("SELECT NOMBREUSUARIO_USUARIO, NOMBRE_USUARIO, APELLIDO_USUARIO, CONTRASEÑA_USUARIO, EMAIL_USUARIO, ID_USUARIO FROM USUARIO");
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombreUsuario(rs.getString("NOMBREUSUARIO_USUARIO"));
				usuario.setNombre(rs.getString("NOMBRE_USUARIO"));
				usuario.setApellido(rs.getString("APELLIDO_USUARIO"));
				usuario.setContraseña(rs.getString("CONTRASEÑA_USUARIO"));
				usuario.setEmail(rs.getString("EMAIL_USUARIO"));
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

	//METODO PARA INSERTAR USUARIO POR PRIMERA VEZ
	public void insertarUsuario(Usuario usuario) throws ExceptionDB {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO USUARIO (NOMBREUSUARIO_USUARIO, NOMBRE_USUARIO, APELLIDO_USUARIO, CONTRASEÑA_USUARIO, EMAIL_USUARIO) VALUES (?, ?, ?, ?, ?)"); 
			Statement stmtForId = conn.createStatement()) {
			
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getContraseña());
			stmt.setString(5, usuario.getEmail());
			
	
			stmt.executeUpdate();
			 
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error al insertar usuario'", e);
		}
	}
	
	//METODO PARA INSERTAR RESTAURANTE POR PRIMERA VEZ
	public void insertarRestaurante(Restaurante restaurante) throws ExceptionDB {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO RESTAURANTE (NOMBRE_RESTAURANTE, CATEGORIA_RESTAURANTE, CONTRASEÑA_RESTAURANTE, DIRECCION_RESTAURANTE, ENVIO_GRATIS) VALUES (?, ?, ?, ?, ?)"); 
			Statement stmtForId = conn.createStatement()) {
			
			stmt.setString(1, restaurante.getNombre());
			stmt.setString(2, restaurante.getCategoria());
			stmt.setString(3, restaurante.getContraseña());
			stmt.setString(4, restaurante.getDireccion());
			int intEnvioGratis = restaurante.isEnviogratis() ? 1 : 0; //para pasar de boolean a int y poder meterlo en la base de datos
			stmt.setInt(5, intEnvioGratis);
			
			stmt.executeUpdate();
			 
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error al insertar restaurante", e);
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
				restaurante.setCategoria(rs.getString("CATEGORIA_RESTAURANTE")); 
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

	
	
	
	public List<Producto> getTodosProductos() throws ExceptionDB {
		//devuelve lista de productos
		List<Producto> productos = new ArrayList<Producto>();
		String SQL="";
		try (Statement stmt = conn.createStatement()) {
			SQL="SELECT NOMBRE_PRODUCTO, ID_PRODUCTO, PRECIO_PRODUCTO, DESCRIPCION_PRODUCTO, VEGANO, TIPO_PRODUCTO, INGREDIENTES_PRODUCTO, ID_RESTAURANTE FROM PRODUCTO;";
			ResultSet rs = stmt.executeQuery(SQL);
			log( Level.INFO, "Buscar productos\t" + SQL, null );
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setNombre(rs.getString("NOMBRE_PRODUCTO"));
				producto.setId(rs.getInt("ID_PRODUCTO"));
				producto.setPrecio(rs.getDouble("PRECIO_PRODUCTO"));
				producto.setDescripcion(rs.getString("DESCRIPCION_PRODUCTO"));
				if(rs.getInt("VEGANO") == 1)  producto.setVegano(true);
				producto.setTipo(TipoProducto.valueOf(rs.getString("TIPO_PRODUCTO")));
				producto.setIdRestaurante(rs.getInt("ID_RESTAURANTE"));
				
				String ingredientesSQL = rs.getString("INGREDIENTES_PRODUCTO");	
				List<String> ingredientesJava = new ArrayList<>();
				StringTokenizer st = new StringTokenizer(ingredientesSQL, ",");
				while (st.hasMoreTokens()) {
					 String token = st.nextToken();
					 ingredientesJava.add(token);
				}
				producto.setIngredientes(ingredientesJava);
				
				
				
				
				productos.add(producto);
			}

			return productos;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los direcciones", e);
		}
	}
	
	//Metodo para borrar el ultimo caracter de un String
	public static String removeLastCharacter(String str) {
		   String result = null;
		   if ((str != null) && (str.length() > 0)) {
		      result = str.substring(0, str.length() - 1);
		   }
		   return result;
	}
	
	public void insertarProducto(Producto producto) throws ExceptionDB {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO PRODUCTO (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, INGREDIENTES_PRODUCTO, DESCRIPCION_PRODUCTO, VEGANO, TIPO_PRODUCTO, ID_RESTAURANTE, ID_MENU) VALUES (?,?,?,?,?,?,?,?);"); 
			Statement stmtForId = conn.createStatement()) {
			
			stmt.setString(1, producto.getNombre());
			stmt.setDouble(2, producto.getPrecio());
			
			String ingredientesSQL = "";
			for (String ingrediente : producto.getIngredientes()) {
				ingredientesSQL = ingrediente + ",";
				
			}
			removeLastCharacter(ingredientesSQL); //He creado el metodo arriba para borrar el ultimo caracter
			stmt.setString(3, ingredientesSQL);
			
			stmt.setString(4, producto.getDescripcion());
			
			int veganoInt = producto.isVegano() ? 1 : 0;
			stmt.setInt(5, veganoInt);
			
			stmt.setString(6, producto.getTipo().toString()); //utilizamos el metodo toString por defecto de las enumeraciones
			stmt.setInt(7, producto.getIdRestaurante()); //cogemos el int del restaurante al que esté asignado este producto
			
			stmt.executeUpdate();
			 
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error al insertar restaurante", e);
		}
	}
	

	
	public void borrarProducto(Producto producto) throws ExceptionDB {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM PRODUCTO WHERE ID_PRODUCTO=?")) {
			stmt.setInt(1, producto.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDB("No se pudo elimiar el producto con id " + producto.getId(), e);
		}
	}
	
	//OBTENER TODOS LOS MENUD DE UN RESTAURANTE
	public List<Menu> getTodosMenus() throws ExceptionDB{
		List<Menu> menus = new ArrayList<Menu>();
		String SQL="";
		try (Statement stmt = conn.createStatement()) {
			SQL="SELECT NOMBRE_MENU, PRECIO_MENU, ID_MENU, ID_RESTAURANTE FROM MENU";
			ResultSet rs = stmt.executeQuery(SQL);
			log( Level.INFO, "Buscar menus\t" + SQL, null );
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setNombre(rs.getString("NOMBRE_MENU"));
				menu.setPrecio(rs.getDouble("PRECIO_MENU"));
				menu.setId(rs.getInt("ID_MENU"));
				menu.setId(rs.getInt("ID_RESTAURANTE"));
				
				
				menus.add(menu);
			}

			return menus;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los menus", e);
		}
	}
	//METODO INSERTAR MENU
	 public void insertarMenu(Menu menu) throws ExceptionDB{
		 try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO MENU (NOMBRE_MENU, PRECIO_MENU, ID_RESTAURANTE) VALUES (?,?,?);"); 
					Statement stmtForId = conn.createStatement()) {
					
					stmt.setString(1, menu.getNombre());
					stmt.setDouble(2, menu.getPrecio());
					stmt.setInt(3, menu.getIdRestaurante());
					stmt.executeUpdate();
					 
				} catch (SQLException | DateTimeParseException e) {
					throw new ExceptionDB("Error al insertar menu", e);
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