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
			String nombreDB = "jdbc:sqlite:/C:\\Users\\guill\\git\\proyectoprog3\\.classpath\\FoodEst\\lib\\FoodEstDB";
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
	
	//devuelve una lista con todas las direcciones --> comprobar en la venatanaDireccion si son del usuario correspondiente
	public List<Direccion> getTodasDirecciones() throws ExceptionDB {
		List<Direccion> direcciones = new ArrayList<Direccion>();
		String SQL="";
		try (Statement stmt = conn.createStatement()) {
			SQL="SELECT * FROM DIRECCION;";
			ResultSet rs = stmt.executeQuery(SQL);
			log( Level.INFO, "Buscar direcciones\t" + SQL, null );
			while (rs.next()) {
				Direccion direccion = new Direccion();
				
				direccion.setId(rs.getInt("ID_DIRECCION"));
				direccion.setNombre(rs.getString("NOMBRE_DIRECCION"));
				direccion.setCalle(rs.getString("CALLE_DIRECCION"));
				direccion.setMunicipio(rs.getString("MUNICIPIO_DIRECCION"));
				direccion.setPortal(rs.getInt("PORTAL_DIRECCION"));
				direccion.setPisoPuerta(rs.getString("PISOPUERTA_DIRECCION"));
				direccion.setCodigoPostal(rs.getInt("CODIGOPOSTAL_DIRECCION"));
				direccion.setIdUsuario(rs.getInt("ID_USUARIO"));
				
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
				
				
				producto.setIngredientes(rs.getString("INGREDIENTES_PRODUCTO"));
				
				
				
				
				productos.add(producto);
			}

			return productos;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los direcciones", e);
		}
	}
	
	
	//Devuelve todos los productos de un tipoProducto
	
	public List<Producto> getTodosProductosDeUnTipo(TipoProducto tipo) throws ExceptionDB {
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
				
				
				producto.setIngredientes(rs.getString("INGREDIENTES_PRODUCTO"));
				
				
				
				if(producto.getTipo().equals(tipo)) productos.add(producto);
				
			}

			return productos;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los direcciones", e);
		}
	}
	
	
	//Devuelve todos los productos de un restaurante
	public List<Producto> getTodosProductosDeRestaurante(Restaurante restaurante) throws ExceptionDB{
		List<Producto> productos = new ArrayList<Producto>();
		String SQL="";
		try (Statement stmt = conn.createStatement()) {
			SQL="SELECT NOMBRE_PRODUCTO, ID_PRODUCTO, PRECIO_PRODUCTO, DESCRIPCION_PRODUCTO, VEGANO, TIPO_PRODUCTO, INGREDIENTES_PRODUCTO, ID_RESTAURANTE FROM PRODUCTO WHERE ID_RESTAURANTE=" + restaurante.getId() + ";";
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
				producto.setIngredientes(rs.getString("INGREDIENTES_PRODUCTO"));

				productos.add(producto);
			}

			return productos;
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los direcciones", e);
		}
	}
	
	
	
	
	/*
	//Metodo para borrar el ultimo caracter de un String
	public static String removeLastCharacter(String str) {
		   String result = null;
		   if ((str != null) && (str.length() > 0)) {
		      result = str.substring(0, str.length() - 1);
		   }
		   return result;
	}
	*/
	//INSERTAR PRODUCTO
	public void insertarProducto(Producto producto) throws ExceptionDB {

			try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO PRODUCTO (NOMBRE_PRODUCTO, PRECIO_PRODUCTO, INGREDIENTES_PRODUCTO, DESCRIPCION_PRODUCTO, VEGANO, TIPO_PRODUCTO, ID_RESTAURANTE) VALUES (?,?,?,?,?,?,?);"); 
				Statement stmtForId = conn.createStatement()) {
				
				stmt.setString(1, producto.getNombre());
				stmt.setDouble(2, producto.getPrecio());
				
				
												 
				stmt.setString(3, producto.getIngredientes());
				
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
	
	
	//INSERTAR PRODUCTO EN MENU
	public void insertarProductoEnMenu(Menu menu, Producto producto) throws ExceptionDB{
		try (PreparedStatement stmt = conn.prepareStatement("UPDATE PRODUCTO SET ID_MENU ="
				+ menu.getId() + "WHERE ID_PRODUCTO =" + producto.getId()+";")){
				
		} catch (SQLException e) {
			throw new ExceptionDB("Error al insertar producto en menu", e);
		}
	}

	//Borrar producto
	public void borrarProducto(Producto producto) throws ExceptionDB {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM PRODUCTO WHERE ID_PRODUCTO=?")) {
			stmt.setInt(1, producto.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDB("No se pudo elimiar el producto con id " + producto.getId(), e);
		}
	}
	//Borrar menu
	public void borrarMenu(Menu menu) throws ExceptionDB {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM MENU WHERE ID_MENU=?")) {
			stmt.setInt(1, menu.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDB("No se pudo elimiar el menu con id " + menu.getId(), e);
		}
	}
	
	public void borrarDireccion(Direccion direccion)throws ExceptionDB {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM DIRECCION WHERE ID_DIRECCION=?")) {
			stmt.setInt(1, direccion.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDB("No se pudo elimiar la direccion con id " + direccion.getId(), e);
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
				menu.setIdRestaurante(rs.getInt("ID_RESTAURANTE"));
				
				
				menus.add(menu); //añadimos el menu a una lista de menus( todavia no tienen sus productos en sus arraylist)
			}

			
		} catch (SQLException | DateTimeParseException e) {
			throw new ExceptionDB("Error obteniendo los menus", e);
		}
		
		
		List<Producto> todosProductos = getTodosProductos(); //cogemos todos los productos de la base de datos
		
		for (Menu menu : menus) { //para cada menu añadido a la lista que vamos a devolver
			String SQL2="";
			try (Statement stmt = conn.createStatement()) {
				SQL2="SELECT ID_PRODUCTO FROM CONTIENE WHERE ID_MENU=" + menu.getId() + ";"; //sacamos los id de productos que tienen guardados
				ResultSet rs = stmt.executeQuery(SQL2);
				log( Level.INFO, "Buscar menus\t" + SQL2, null );
				List<Producto> productosMenu = new ArrayList<Producto>(); //creamos la lista donde van a ir sus productos
				while (rs.next()) {
					int idProductoBuscado = rs.getInt("ID_PRODUCTO"); //cogemos el id del producto
					for (Producto producto : todosProductos) {
						if (idProductoBuscado == producto.getId()) {
							productosMenu.add(producto); //añdimos el producto a la lisya del menu
						}
					}
					menu.setProductos(productosMenu); //asignamos la lista al menu
				}

				
			} catch (SQLException | DateTimeParseException e) {
				throw new ExceptionDB("Error obteniendo los menus", e);
			}
		}
		
		
		return menus; //devolvemos la lista de menus con sus respectivos productos asignados !!
	}
	
	
	//METODO INSERTAR MENU
	public void insertarMenu(Menu menu) throws ExceptionDB{
		 //Insertamos el menu --> coge el id en la base de datos
		 try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO MENU (NOMBRE_MENU, PRECIO_MENU, ID_RESTAURANTE) VALUES (?,?,?);"); 
					Statement stmtForId = conn.createStatement()) {
					
					stmt.setString(1, menu.getNombre());
					stmt.setDouble(2, menu.getPrecio());
					stmt.setInt(3, menu.getIdRestaurante());
					
					stmt.executeUpdate();
					 
				} catch (SQLException | DateTimeParseException e) {
					throw new ExceptionDB("Error al insertar menu", e);
				}
		 
		 //Cogemos el id del menu insertado
		 int idBuscadoMenu;
		 String SQL="";
			try (Statement stmt = conn.createStatement()) {
				SQL="SELECT MAX(ID_MENU) FROM MENU;";
				ResultSet rs = stmt.executeQuery(SQL);
				idBuscadoMenu = rs.getInt("MAX(ID_MENU)");

			} catch (SQLException | DateTimeParseException e) {
				throw new ExceptionDB("Error buscando el id del menu", e);
			}
		 //Para ese idmenu metemos los productos asociados a este menu en la tabla contiene
			for (Producto producto : menu.getProductos()) {
				try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO CONTIENE (ID_MENU, ID_PRODUCTO) VALUES (?,?);"); 
						Statement stmtForId = conn.createStatement()) {
						
						stmt.setInt(1, idBuscadoMenu);
						stmt.setInt(2, producto.getId());
						
						stmt.executeUpdate();
						 
					} catch (SQLException | DateTimeParseException e) {
						throw new ExceptionDB("Error al insertar menu", e);
					}
			}

	 }

	 
	 
	 
	 
	 //INSERTAR PEDIDO
	 public void insertarPedido(Pedido pedido) throws ExceptionDB {
		 try(PreparedStatement stmt = conn.prepareStatement("INSERT INTO PEDIDO (ID_RESTAURANTE, ID_USUARIO, ID_DIRECCION, "
		 		+ "ESTADO_PEDIDO, PRECIOTOTAL_PEDIDO, METODOPAGO_PEDIDO, CUBIERTOS) VALUES(?,?,?,?,?,?,?);");
				 Statement stmtForId = conn.createStatement()) {
						
						stmt.setInt(1, pedido.getRestaurante().getId());
						stmt.setInt(2, pedido.getUsuario().getId());
						stmt.setInt(3, pedido.getDireccion().getId());
						stmt.setString(4, pedido.getEstado().toString());
						stmt.setDouble(5, pedido.getPreciototal());
						stmt.setString(6, pedido.getMetodopago());
						int cubiertosInt = pedido.isCubiertos() ? 1 : 0;
						stmt.setInt(7, cubiertosInt);
						
						stmt.executeUpdate();
						 
					} catch (SQLException | DateTimeParseException e) {
						throw new ExceptionDB("Error al insertar menu", e);
					}
		
	 
	 }
	 
	 
	 /*Insertar los productos en el envio correspondiente (ejecutar siempre despues del metodo insertar pedio, para que 
	 el pedido obtenga sus productos en la tabla pedir)*/
	 public void insertarProductosEnPedido(List<Producto> productosInsertar) throws ExceptionDB {
		 String SQL="";
		 int codigoPedido = 0;
		 	
			try (Statement stmt = conn.createStatement()) {
				SQL="SELECT ID_PEDIDO FROM PEDIDO WHERE ID_PEDIDO=(SELECT max(ID_PEDIDO) FROM PEDIDO) "; //cogemos el id ultimo pedido, es decir el que acabamos de meteer
				ResultSet rs = stmt.executeQuery(SQL);
				log( Level.INFO, "Buscar menus\t" + SQL, null );
				while (rs.next()) {
					codigoPedido = rs.getInt("ID_PEDIDO");
				}

			} catch (SQLException | DateTimeParseException e) {
				throw new ExceptionDB("Error obteniendo los pedidos", e);
			}
			
			//Para cada producto lo metemos en la tabla pedir (la cual relaciona el pedido con los productos enviados)
			for (Producto producto : productosInsertar) {
				try(PreparedStatement stmt = conn.prepareStatement("INSERT INTO PEDIR (ID_PRODUCTO, ID_PEDIDO) VALUES(?,?);");
					Statement stmtForId = conn.createStatement()) {
								
						stmt.setInt(1, producto.getId());
						stmt.setInt(2, codigoPedido);
								
						stmt.executeUpdate();
								
								 
					} catch (SQLException | DateTimeParseException e) {
						throw new ExceptionDB("Error al insertar menu", e);
					}
			}
			
		 
	 }
	 
	 
	 
	 public void insertarDireccion (Direccion direccion) throws ExceptionDB {
		 try(PreparedStatement stmt = conn.prepareStatement("INSERT INTO DIRECCION (NOMBRE_DIRECCION, CALLE_DIRECCION, "
		 		+ "MUNICIPIO_DIRECCION, PORTAL_DIRECCION, PISOPUERTA_DIRECCION, CODIGOPOSTAL_DIRECCION, ID_USUARIO) VALUES(?,?,?,?,?,?,?);");
			Statement stmtForId = conn.createStatement()) {
				
				stmt.setString(1, direccion.getNombre());
				stmt.setString(2, direccion.getCalle());
				stmt.setString(3, direccion.getMunicipio());
				stmt.setInt(4, direccion.getPortal());
				stmt.setString(5, direccion.getPisoPuerta());
				stmt.setInt(6, direccion.getCodigoPostal());
				stmt.setInt(7, direccion.getIdUsuario());
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