package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutFocusTraversalPolicy;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.ManagerDB;
import clases.Menu;

import clases.Producto;
import clases.Restaurante;
import clases.TipoProducto;
import clases.Usuario;



public class VentanaAdministracionRestaurante extends JFrame{


	public VentanaAdministracionRestaurante(Restaurante restaurante) {
		//PANEL DERECHA
		JSplitPane panelDerecha = new JSplitPane(JSplitPane.VERTICAL_SPLIT); //panelmenus
		panelDerecha.setBorder(null);
		panelDerecha.setResizeWeight(0.10);
		panelDerecha.setEnabled(false);
		panelDerecha.setDividerSize(0);
		
		
		
		
		
		
		
		
			//PANELARRIBA
		JPanel panelDerechaArriba = new JPanel();
		
		JPanel panelDerechaArriba1 = new JPanel();
		panelDerechaArriba1.setLayout(new GridLayout(4,3));
		
		JLabel lnombreRestaurante = new  JLabel("Nombre de restaurante:");
		JTextField nombreRestaurante = new JTextField(restaurante.getNombre());
		
		JLabel lcategoriaRestaurante = new JLabel("Categoria de restaurante:");
		JTextField categoriaRestaurante = new JTextField(restaurante.getCategoria());
		
		JLabel ldireccionRestaurante = new JLabel("Direccion de restaurante:");
		JTextField direccionRestaurante = new JTextField(restaurante.getDireccion());
		
		JLabel lenvioGratisRestaurante = new JLabel("Direccion de restaurante:");
		JTextField envioGratisRestaurante = new JTextField(restaurante.getDireccion());
		
		panelDerechaArriba1.add(lnombreRestaurante);
		panelDerechaArriba1.add(nombreRestaurante);	
		panelDerechaArriba1.add(new JPanel());	
		
		panelDerechaArriba1.add(lcategoriaRestaurante);
		panelDerechaArriba1.add(categoriaRestaurante);
		panelDerechaArriba1.add(new JPanel());	

		
		panelDerechaArriba1.add(ldireccionRestaurante);
		panelDerechaArriba1.add(direccionRestaurante);	
		JButton bcerrarSesion = new JButton("Cerrar sesion");
		panelDerechaArriba1.add(bcerrarSesion);	

		
		panelDerechaArriba1.add(lenvioGratisRestaurante);
		panelDerechaArriba1.add(envioGratisRestaurante);
		JButton bguardarCambios = new JButton("Guardar cambios");
		panelDerechaArriba1.add(bguardarCambios);	

		
		
		panelDerechaArriba.add(panelDerechaArriba1);
		panelDerechaArriba.add(new JPanel());
		
				
				
				
				
		
			//PANELADERECHABAJO 

		JSplitPane panelDerechaAbajo = new JSplitPane(JSplitPane.VERTICAL_SPLIT); //panelmenus
		panelDerechaAbajo.setBorder(null);
		panelDerechaAbajo.setResizeWeight(0.35);
		panelDerechaAbajo.setEnabled(false);
		panelDerechaAbajo.setDividerSize(0);
		
				//panelDerechaAbajo1 (barra + scroll) --> MENUS
		JSplitPane panelDerechaAbajo1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT); //panelmenus
		panelDerechaAbajo1.setBorder(null);
		panelDerechaAbajo1.setResizeWeight(0.02);
		panelDerechaAbajo1.setEnabled(false);
		panelDerechaAbajo1.setDividerSize(0);
		
		JPanel panelMenusBarra = new JPanel();
		JLabel lmenusRestaurante = new JLabel("MENUS DEL RESTAURANTE:    ");
		JButton ba�adirMenu = new JButton("A�adir menu");
		panelMenusBarra.add(lmenusRestaurante);
		panelMenusBarra.add(ba�adirMenu);
		
		JPanel menusDisponibles = new JPanel();
		menusDisponibles.setLayout(new FlowLayout());
		JScrollPane scrollMenusDisponibles = new JScrollPane(menusDisponibles);
		
		panelDerechaAbajo1.add(panelMenusBarra);
		panelDerechaAbajo1.add(scrollMenusDisponibles);
		
		
		
		

		
		
		
		
		
		
		
		
				//panelDerechaAbajo2 (barra + scroll) --> PRODUCTOS
		JSplitPane panelDerechaAbajo2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT); //panelproductos
		panelDerechaAbajo2.setBorder(null);
		panelDerechaAbajo2.setResizeWeight(0.02);
		panelDerechaAbajo2.setEnabled(false);
		panelDerechaAbajo2.setDividerSize(0);
		
		JPanel panelProductosbarra = new JPanel();
		JLabel lproductosRestaurante = new JLabel("PRODUCTOS DEL RESTAURANTE:    ");
		JButton ba�adirProducto = new JButton("A�adir producto");
		panelProductosbarra.add(lproductosRestaurante);
		panelProductosbarra.add(ba�adirProducto);
		
		JPanel productosDisponibles = new JPanel();
		JPanel productosDisponiblesCenter = new JPanel();

		productosDisponibles.setLayout(new BorderLayout());   
		productosDisponibles.add(productosDisponiblesCenter, BorderLayout.CENTER);
		productosDisponiblesCenter.setLayout(new GridLayout(0,4));
		
		JScrollPane scrollProductos = new JScrollPane(productosDisponiblesCenter);

		
		panelDerechaAbajo2.add(panelProductosbarra);
		panelDerechaAbajo2.add(scrollProductos);

		
		
		panelDerechaAbajo.add(panelDerechaAbajo1);
		panelDerechaAbajo.add(panelDerechaAbajo2);

		
		
		

		
		panelDerecha.add(panelDerechaArriba);
		panelDerecha.add(panelDerechaAbajo);
		
	
			
			
		
		
		
	
		
		
		
		
		
		ManagerDB db = new ManagerDB();
		List<Producto> productos;
		List<Menu> menus;
		try {
			
			db.connect();
			productos = db.getTodosProductos();
			menus = db.getTodosMenus();
			db.disconnect();
			
			//Inserccion de productos disponibles en el retaurante desde la base de datos
			for (Producto producto : productos) {
				if(restaurante.getId() == producto.getIdRestaurante()) {
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					panel.setBorder(BorderFactory.createLineBorder(Color.black));
					
					JLabel lnombre;
					
					lnombre = new JLabel(producto.toString());
					
					panel.add(lnombre, BorderLayout.NORTH);
					
					JTextArea textIngredientes = new JTextArea();
					textIngredientes.append("INGREDIENTES:" + "\n");
					StringTokenizer st = new StringTokenizer(producto.getIngredientes(), " ,");
					 while (st.hasMoreTokens()) {
						 String token = st.nextToken();
						 textIngredientes.append(" - " + token + "\n");
					 }
					
					
					
					
					textIngredientes.setEditable(false);
					panel.add(textIngredientes, BorderLayout.CENTER);
					
					JButton beliminar = new JButton("Eliminar");
					panel.add(beliminar, BorderLayout.SOUTH);
					
					
					productosDisponiblesCenter.add(panel);
					
					beliminar.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							ManagerDB db = new ManagerDB();
							try {
								db.connect();
								db.borrarProducto(producto);
								db.disconnect();
								
								dispose();
								new VentanaAdministracionRestaurante(restaurante);
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
						}
					});
					
				}
			}
					
					
					
					
			//Inserccion de menus del restaurante en el panel de menus		
			for (Menu menu : menus) {
				if(restaurante.getId() == menu.getIdRestaurante()) {
								
					JPanel panelMenu = new JPanel();
					panelMenu.setLayout(new BorderLayout());
					panelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
								
					JLabel lnombre = new JLabel(menu.getNombre());
					panelMenu.add(lnombre, BorderLayout.NORTH);
						
								
					JTextArea productosMenu = new JTextArea();
					for (Producto producto : productos) {
						if(producto.getIdMenu() == menu.getId()) {
							productosMenu.setText(producto.getNombre() + "\n");
						}
					}
					panelMenu.add(productosMenu, BorderLayout.CENTER);
					
					
					JButton bEliminarMenu = new JButton("Eliminar");
					panelMenu.add(bEliminarMenu, BorderLayout.SOUTH);
					
					menusDisponibles.add(panelMenu); //a�adimos el panel
					
					bEliminarMenu.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							ManagerDB db = new ManagerDB();
							try {
								db.connect();
								db.borrarMenu(menu);
								db.disconnect();
								
								dispose();
								new VentanaAdministracionRestaurante(restaurante);
								
							} catch (Exception e2) {
								// TODO: handle exception
							}
							
						}
					});
								
				}
							
			}
					
			
				
		} catch (Exception e) {
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//PANEL IZQUIERDA
		
		JSplitPane panelIzquierda = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelIzquierda.setBorder(null);
		panelIzquierda.setResizeWeight(0.15); // Esto es el porcentaje de la parte de arriba ---> ajustar
		panelIzquierda.setEnabled(false);
		panelIzquierda.setDividerSize(0);
		
		
		
		JPanel panelIzquierdaArriba = new JPanel();
		JLabel titulo = new JLabel("ADMINISTRACION DE " + restaurante.getNombre());
		titulo.setFont(new Font("Cooper Black", Font.BOLD, 20));
		panelIzquierdaArriba.add(titulo);
		
		JSplitPane panelIzquierdaAbajo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelIzquierdaAbajo.setBorder(null);
		panelIzquierdaAbajo.setResizeWeight(0.80); 
		panelIzquierdaAbajo.setEnabled(false);
		panelIzquierdaAbajo.setDividerSize(0);
		
		JPanel panelAbajoPedidos = new JPanel(); //a�adir la jtable a esteee!!!
		TitledBorder border = new TitledBorder("Pedidos recibidos");
	    border.setTitleJustification(TitledBorder.CENTER);
	    border.setTitlePosition(TitledBorder.TOP);
	    panelAbajoPedidos.setBorder(border);
	    
	    JPanel panelAbajoBotones = new JPanel();
	    JButton botonMarcarTodosPedidos  = new JButton("Marcar todos los pedidos como enviados");
	    JButton botonMarcarPedido  = new JButton("Marcar primero pedido como enviado");
	    panelAbajoBotones.add(botonMarcarPedido);
	    panelAbajoBotones.add(botonMarcarTodosPedidos);

	    
	    panelIzquierdaAbajo.add(panelAbajoPedidos);
	    panelIzquierdaAbajo.add(panelAbajoBotones);
	    
	    panelIzquierda.add(panelIzquierdaArriba);
	    panelIzquierda.add(panelIzquierdaAbajo);
	    
	    
	    JFrame thisFrame = this;
		
	    ba�adirProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaA�adirProducto(restaurante, thisFrame);
				
			}
		});
	    
	    ba�adirMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaA�adirMenu(restaurante, thisFrame);
				
			}
		});
	    
	    bcerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaLogin();
				
			}
		});
	    
	    
	    
	    
	    String data[][];   
	    String nombreColumnas[]={"ID","DIRECCION","PRODUCTOS", "PRECIO", "PAGO", "CUBIERTOS"};
	    DefaultTableModel modeloTabla = new DefaultTableModel(null, nombreColumnas);
	    JTable tablaPedidos = new JTable(modeloTabla);
	    
	    JScrollPane scrollTablaPedidos =new JScrollPane(tablaPedidos);   
	    
	    
	    
	    
	    panelAbajoPedidos.add(scrollTablaPedidos);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    setLayout(new GridLayout(1,2));
		add(panelIzquierda);
		add(panelDerecha);

		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(1150, 590);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Restaurante restaurante  = new Restaurante();
				new VentanaAdministracionRestaurante(restaurante);
				
				
			}
		});

	}
}


//------------------------------------------------------------VENTANA PARA A�ADIR PRODUCTO----------------------------------------------------------------------------------------------------
class VentanaA�adirProducto extends JFrame{
	
	public VentanaA�adirProducto(Restaurante restaurante , JFrame ventanaAnterior) {
		
		setSize(300, 350);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("A�adir producto a restaurante");
		setVisible(true);
		
		setLayout(new GridLayout(7,2));
	
		
		JButton bcancelar = new JButton("Cancelar");
		JButton ba�adir = new JButton("A�adir");
		
		JLabel lnombre = new JLabel("Nombre de producto");
		JTextField tnombre = new JTextField();
		
		
		JLabel lprecio = new JLabel("Precio de producto");
		JTextField tprecio = new JTextField();
		
		JLabel ldescripcion = new JLabel("Descripcion de producto");
		JTextField tdescripcion = new JTextField();
		
		JLabel lvegano = new JLabel("Producto vegano");
		JCheckBox checkvegano = new JCheckBox();
		
		JLabel lingredientes = new JLabel("Ingredientes");
		JTextField tingredientes = new JTextField();
		
		JLabel ltipoProducto = new JLabel("Tipo");
		JComboBox<String> comboTipoProducto = new JComboBox();
		
		
		TipoProducto[] tipos = TipoProducto.values();
		
		for (TipoProducto tipoProducto : tipos) {
			String tipo = tipoProducto.toString();
			comboTipoProducto.addItem(tipo);
		}
		
		
		
		add(lnombre);
		add(tnombre);
		
		add(lprecio);
		add(tprecio);
		
		add(ldescripcion);
		add(tdescripcion);
		
		add(ltipoProducto);
		add(comboTipoProducto);
		
		add(lvegano);
		add(checkvegano);
		
		add(lingredientes);
		add(tingredientes);
		
		add(ba�adir);
		add(bcancelar);
		
		ba�adir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Producto productoNuevo = new Producto(); //creamos el producto
				
				productoNuevo.setNombre(tnombre.getText());
				productoNuevo.setDescripcion(tdescripcion.getText());
				productoNuevo.setPrecio(Double.parseDouble(tprecio.getText()));
				productoNuevo.setVegano(checkvegano.isSelected());
				String tipoElegido = (String) comboTipoProducto.getSelectedItem();
				productoNuevo.setTipo(TipoProducto.valueOf(tipoElegido));
				productoNuevo.setIdRestaurante(restaurante.getId());
				productoNuevo.setIngredientes(tingredientes.getText());
				
				
				
				//Insertamos el producto creado en la base de datos
				ManagerDB db = new ManagerDB();
				try {
					db.connect();
					db.insertarProducto(productoNuevo);
					db.disconnect();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				dispose();
				ventanaAnterior.dispose();
				new VentanaAdministracionRestaurante(restaurante);
				 
			}
		});
		
		

	}
}
//-----------------------------------------------VentanaA�adirMenu----------------------------------------------
class VentanaA�adirMenu extends JFrame{
	
	public VentanaA�adirMenu(Restaurante restaurante , JFrame ventanaAnterior) {
		setSize(350, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("A�adir menu a restaurante");
		setVisible(true);
		setLayout(new GridLayout(3,1));
		
		//panel1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		
		JLabel lnombreMenu = new JLabel("Nombre de menu");
		JTextField tnombreMenu = new JTextField();
		panel1.add(lnombreMenu);
		panel1.add(tnombreMenu);
		
		JLabel ltipoMenu = new JLabel("Tipo:");
		JComboBox<String> combotipo = new JComboBox();
		combotipo.addItem("Normal");
		combotipo.addItem("Combinado");
		combotipo.addItem("Vegano");
		
		
		panel1.add(ltipoMenu);
		panel1.add(combotipo);

		
		//panel2 
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		
		JList listaProductos = new JList();
		DefaultListModel modeloProductos= new DefaultListModel();
		listaProductos.setModel(modeloProductos);
		JScrollPane scrollLista = new JScrollPane(listaProductos);
		
		//A�adimos los productos de este restaurante a la lista
		ManagerDB db = new ManagerDB();
		
		List<Producto> productos = null;
		try {
			db.connect();
			productos = db.getTodosProductos();
			db.disconnect();
			
			
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (Producto producto : productos) {
			if(producto.getIdRestaurante() == restaurante.getId()) {
				modeloProductos.addElement(producto.toString());
			}
		}
		
		DefaultListModel modeloProductosA�adidos= new DefaultListModel();
		JList productosA�adidos = new JList(modeloProductosA�adidos);
		
		
		
		productosA�adidos.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		panel2.add(scrollLista);
		panel2.add(productosA�adidos);

		

		
		//panel3
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		
		
		JPanel panelA�adirProducto = new JPanel();
		panelA�adirProducto.setLayout(new BorderLayout());
		JButton ba�adirProducto = new JButton("A�adir producto");
		panelA�adirProducto.add(new JPanel(), BorderLayout.EAST);
		panelA�adirProducto.add(ba�adirProducto, BorderLayout.CENTER);
		panelA�adirProducto.add(new JPanel(), BorderLayout.WEST);
		panelA�adirProducto.add(new JPanel(), BorderLayout.NORTH);
		panelA�adirProducto.add(new JPanel(), BorderLayout.SOUTH);
		
		JPanel panelBotonesAbajo = new JPanel();
		JButton botonA�adirMenu = new JButton("A�adir menu");
		JButton botonCancelarA�adirMenu = new JButton("Cancelar");
		panelBotonesAbajo.add(botonA�adirMenu);
		panelBotonesAbajo.add(botonCancelarA�adirMenu);

		
		panel3.add(panelA�adirProducto);
		panel3.add(panelBotonesAbajo);

		
		
		
		add(panel1);
		add(panel2);
		add(panel3);

		botonCancelarA�adirMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		List<Producto> productosA�adirAlMenu = new ArrayList<Producto>(); //vamos a�adiendo a una lista los productos que se vana a a�adir al menu
		
		ba�adirProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Producto> productos = null;
				try {
					db.connect();
					productos = db.getTodosProductos();
					db.disconnect();

				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				Producto productoSeleccionado = null;
				String productoString = (String) listaProductos.getSelectedValue();	
				modeloProductos.removeElement(productoString);
				for (Producto producto : productos) {
					if(producto.toString().equals(productoString)) {
						productoSeleccionado = producto;
					}
				}
				
	        	modeloProductosA�adidos.addElement(productoString);
	        	
	        	productosA�adirAlMenu.add(productoSeleccionado);
	        	
	        	
	        	
			}
		});
		
		//Utilizar la lista de productos para a�adir al menu que ya queda lista arriba
		botonA�adirMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerDB db = new ManagerDB();
				String nombreMenu = "";
				Menu menu = null;
				
				//Creamos un menu con los datos de la ventana y lo insertamos en la base de datos( en la base de datos obtiene su idMenu)
				try {
					menu = new Menu();
					menu.setNombre(tnombreMenu.getText());
					menu.setIdRestaurante(restaurante.getId());
					
					
					Double precio = 0.0;
					for (Producto producto : productosA�adirAlMenu) {
						precio = precio + producto.getPrecio();
					}
					menu.setPrecio(precio);
					
					nombreMenu = menu.getNombre();
					
					db.connect();
					db.insertarMenu(menu);
					db.disconnect();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				//Emparejamos los productos elegidos con el menu que hemos creado y hemos metido en la base de datos
				List<Menu> todosMenus;
				try {
					db.connect();
					Menu menunbuscado = null;
					todosMenus = db.getTodosMenus();
					for (Menu menu3 : todosMenus) {
						if (menu3.getNombre().equals(nombreMenu)) {
							menunbuscado = menu3;
						}
					}
					for (Producto producto2 : productosA�adirAlMenu) {
						db.insertarProductoEnMenu(menunbuscado, producto2);
					}
					db.disconnect();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				dispose();
				ventanaAnterior.dispose();
				new VentanaAdministracionRestaurante(restaurante);
				
			}
		});
	
		
	
	
			
	}
}

