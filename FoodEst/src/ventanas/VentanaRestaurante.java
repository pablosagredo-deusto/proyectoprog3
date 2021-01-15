package ventanas;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;


import clases.*;
import clases.Menu;

import javax.swing.*;




public class VentanaRestaurante extends JFrame {


	Pedido p;
	double precio=0.0;
	



	public VentanaRestaurante(JFrame ventanaAnterior, Restaurante restaurante, Usuario usuario) {

		super("restaurante");
		setSize(1150, 505);
		setVisible(true);

		// PANEL GENERAL : parte izquierda y parte derecha
		JSplitPane panelGeneral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		panelGeneral.setBorder(null);
		panelGeneral.setResizeWeight(0.66); // Esto es el porcentaje de la parte de la izquierda ---> ajustar
		panelGeneral.setEnabled(false);
		panelGeneral.setDividerSize(0);

		
		//--------------------------------Panel DERECHA-------------------------------------
				JPanel panelDerecha = new JPanel();
				panelDerecha.setLayout(new GridLayout(6, 2));
				DefaultListModel modeloPedido = new DefaultListModel();
				ArrayList<Producto> listaPedido = new ArrayList<Producto>();
				ArrayList<Menu> listaPedidoMenu = new ArrayList<Menu>();



				
				JList jlistaProductos = new JList();
				JLabel nombrePedido = new JLabel("PEDIDO ACTUAL:");
				JButton eliminar = new JButton("ELIMINAR");
				JButton pagar = new JButton("PAGAR");
				JLabel precioActual= new JLabel("Precio actual:");
				

				

				jlistaProductos.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						System.out.println("Seleccionar");
						JList list = (JList) evt.getSource();
						if (evt.getClickCount() == 2) {
							Object producto = (Object) jlistaProductos.getSelectedValue();
							

						}

					}

				});
				

				eliminar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						if (jlistaProductos.getSelectedValue() == null) {
							JOptionPane.showMessageDialog(null, "Selecciona un producto para eliminar");

						} else {
							System.out.println("entrando en eliminar");
							System.out.println(jlistaProductos.getSelectedValue());
							Object producto = (Object) jlistaProductos.getSelectedValue();
							int i=(int) jlistaProductos.getSelectedIndex();
							listaPedido.remove(i);
							modeloPedido.remove(i);


						}

					}
				});
				
				
				
				
				
		
		
		
		
		//----------------------------------------Panel IZQUIERDA------------------------------------


		JSplitPane panelIzquierda = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelIzquierda.setBorder(null);
		panelIzquierda.setResizeWeight(0.15);
		panelIzquierda.setEnabled(false);
		panelIzquierda.setDividerSize(0);

		// PanelNombre
		JSplitPane panelIzquierdaArriba = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelIzquierdaArriba.setBorder(null);
		panelIzquierdaArriba.setResizeWeight(0.15);
		panelIzquierdaArriba.setEnabled(false);
		panelIzquierdaArriba.setDividerSize(0);
		

		Font font = new Font("Cooper Black", Font.BOLD, 40);
		
		panelIzquierdaArriba.setBackground(Color.red);

			// nombre panelIzquierdaArriba1
		JPanel panelIzquierdaArriba1 = new JPanel();
		panelIzquierdaArriba1.setLayout(new BorderLayout());
		JLabel titulo = new JLabel(restaurante.getNombre());
		titulo.setFont(font);

		JButton atras = new JButton(new ImageIcon("src/imagenes/logoAtras2.png"));
		
		panelIzquierdaArriba1.add(titulo, BorderLayout.CENTER);
		panelIzquierdaArriba1.add(atras, BorderLayout.WEST);



			// nombre panelIzquierdaArriba2
		JPanel panelIzquierdaArriba2 = new JPanel();
		panelIzquierdaArriba2.setLayout(new GridLayout(1, 6));


		JButton entrantes = new JButton("ENTRANTES");
		JButton principales = new JButton("PRINCIPALES");
		JButton segundos = new JButton("SEGUNDOS");
		JButton postres = new JButton("POSTRES");
		JButton bebidas = new JButton("BEBIDAS");
		JButton menus = new JButton("MENUS");

		JButton buscar = new JButton();
		ImageIcon fot = new ImageIcon("src/Imagenes/key .png");
		buscar.setSize(40, 40);
		Icon icono = new ImageIcon(
				fot.getImage().getScaledInstance(buscar.getWidth(), buscar.getHeight(), Image.SCALE_DEFAULT));
		buscar.setIcon(icono);
		buscar.repaint();
		buscar.setOpaque(false);
		buscar.setContentAreaFilled(false);
		buscar.setBorderPainted(false);


		panelIzquierdaArriba2.add(entrantes);
		panelIzquierdaArriba2.add(principales);
		panelIzquierdaArriba2.add(segundos);
		panelIzquierdaArriba2.add(postres);
		panelIzquierdaArriba2.add(bebidas);
		panelIzquierdaArriba2.add(menus);



		
		
		panelIzquierdaArriba.add(panelIzquierdaArriba1);
		panelIzquierdaArriba.add(panelIzquierdaArriba2);

		

		panelIzquierda.add(panelIzquierdaArriba);

		// Panel izquierdaAbajo
		JPanel panelIzquierdaAbajo = new JPanel();
		panelIzquierdaAbajo.setLayout(new GridLayout(2, 4, 30, 30)); // meter separacion entre espacios


<<<<<<< HEAD
		
		
		//pruebas auto añadir jlabels
		
		List<JLabel> labelsNombres = new ArrayList<>();
		List<JPanel> paneles= new ArrayList<>();

		String descripcion="";
		for (Producto p : lProductos) {
			JLabel label = new JLabel(p.getNombre());
			
			JPanel panel = new JPanel();

			labelsNombres.add(label);
			for (String product : p.getIngredientes()) {
				descripcion=descripcion+" "+product+" \n- ";
			}
			JTextArea label2 = new JTextArea(descripcion);
			label2.setEditable(false);
=======
		// PRODUCTOS DEL RESTAURANTE EN PanelIzquierdaAbajo
		ManagerDB db = new ManagerDB();
		List<Producto> todosProductos = null;
		try {
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3.git
			
			db.connect();
			todosProductos = db.getTodosProductos();
			db.disconnect();
			
			int numeroProductos = todosProductos.size(); //para el layout
			
			//Para cada producto se añade al panel de productos
			for (Producto producto : todosProductos) {
				if(restaurante.getId() == producto.getIdRestaurante()) {
					JPanel panelProducto = new JPanel();
					panelProducto.setLayout(new BorderLayout());
					JLabel tnombreProducto = new JLabel(producto.getNombre());
					JButton bañadir = new JButton("AÑADIR");
					
					
					bañadir.addActionListener(new ActionListener() {



						@Override
						public void actionPerformed(ActionEvent e) {

							listaPedido.add(producto); //LISTA QUE UTILIZAREMOS PARA EL PEDIDO 
							precio = precio+ producto.getPrecio();
							DecimalFormat df = new DecimalFormat("#.00");
							precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
							
							modeloPedido.addElement(producto.toStringPrecio());

						}
					});
					
					
					//Los ingredientes del producto
					JTextArea tingredientes = new JTextArea();
					tingredientes.setEditable(false);
					tingredientes.append("INGREDIENTES:" + "\n");
					StringTokenizer st = new StringTokenizer(producto.getIngredientes(), " ,");
					 while (st.hasMoreTokens()) {
						 String token = st.nextToken();
						 tingredientes.append(" - " + token + "\n");
					 }
					
					
					
					panelProducto.add(bañadir, BorderLayout.SOUTH);
					panelProducto.add(tnombreProducto, BorderLayout.NORTH);
					panelProducto.add(tingredientes, BorderLayout.CENTER);
					

					panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
					//Y finalmente añadimos el panel
					panelIzquierdaAbajo.add(panelProducto);
				}
				

			}

		} catch (Exception e) {
		}	
		
		

		//IMPORTANT
		
		
		
		
		
		
		
		//BOTONES PARA FILTRAR UN TIPO DE PRODUCTO
		
		//FILTRAR SOLO BEBIDAS
		bebidas.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				//----Para quitar los productos que hay añadidos-----
				Component[] components = panelIzquierdaAbajo.getComponents();
				for (Component component : components) {
					panelIzquierdaAbajo.remove(component);  
				}
				panelIzquierdaAbajo.revalidate();
				panelIzquierdaAbajo.repaint();
				//-----------------------------------------------
				
				
				ManagerDB db = new ManagerDB();
				List<Producto> todosProductos = null;
				try {
					
					db.connect();
					todosProductos = db.getTodosProductosDeUnTipo(TipoProducto.BEBIDA);
					db.disconnect();
					
					int numeroProductos = todosProductos.size(); //para el layout
					
					//Para cada producto se añade al panel de productos
					for (Producto producto : todosProductos) {
						if(restaurante.getId() == producto.getIdRestaurante()) {
							JPanel panelProducto = new JPanel();
							panelProducto.setLayout(new BorderLayout());
							JLabel tnombreProducto = new JLabel(producto.getNombre());
							JButton bañadir = new JButton("AÑADIR");
							
							
							bañadir.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									listaPedido.add(producto); //LISTA QUE UTILIZAREMOS PARA EL PEDIDO 
									precio = precio+ producto.getPrecio();
									DecimalFormat df = new DecimalFormat("#.00");
									precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
									
									
									modeloPedido.addElement(producto.toStringPrecio());

								}
							});
							
							
							//Los ingredientes del producto
							JTextArea tingredientes = new JTextArea();
							tingredientes.append("INGREDIENTES:" + "\n");
							StringTokenizer st = new StringTokenizer(producto.getIngredientes(), " ,");
							 while (st.hasMoreTokens()) {
								 String token = st.nextToken();
								 tingredientes.append(" - " + token + "\n");
							 }
							
							tingredientes.setEditable(false);
							
							panelProducto.add(bañadir, BorderLayout.SOUTH);
							panelProducto.add(tnombreProducto, BorderLayout.NORTH);
							panelProducto.add(tingredientes, BorderLayout.CENTER);
							

							panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
							//Y finalmente añadimos el panel
							panelIzquierdaAbajo.add(panelProducto);
						}
						
					}
				} catch (Exception e1) {
				}
				
			}
		});
		
		//FILTRAR SOLO SEGUNDOS
		segundos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//----Para quitar los productos que hay añadidos-----
				Component[] components = panelIzquierdaAbajo.getComponents();
				for (Component component : components) {
					panelIzquierdaAbajo.remove(component);  
				}
				panelIzquierdaAbajo.revalidate();
				panelIzquierdaAbajo.repaint();
				//-----------------------------------------------
				ManagerDB db = new ManagerDB();
				List<Producto> todosProductos = null;
				try {
					
					db.connect();
					todosProductos = db.getTodosProductosDeUnTipo(TipoProducto.SEGUNDO);
					db.disconnect();
					
					int numeroProductos = todosProductos.size(); //para el layout
					
					//Para cada producto se añade al panel de productos
					for (Producto producto : todosProductos) {
						if(restaurante.getId() == producto.getIdRestaurante()) {
							JPanel panelProducto = new JPanel();
							panelProducto.setLayout(new BorderLayout());
							JLabel tnombreProducto = new JLabel(producto.getNombre());
							JButton bañadir = new JButton("AÑADIR");
							
							
							bañadir.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									listaPedido.add(producto); //LISTA QUE UTILIZAREMOS PARA EL PEDIDO 
									precio = precio+ producto.getPrecio();
									DecimalFormat df = new DecimalFormat("#.00");
									precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
									
									
									modeloPedido.addElement(producto.toStringPrecio());

								}
							});
							
							
							//Los ingredientes del producto
							JTextArea tingredientes = new JTextArea();
							tingredientes.append("INGREDIENTES:" + "\n");
							StringTokenizer st = new StringTokenizer(producto.getIngredientes(), " ,");
							 while (st.hasMoreTokens()) {
								 String token = st.nextToken();
								 tingredientes.append(" - " + token + "\n");
							 }
							
							tingredientes.setEditable(false);
							
							panelProducto.add(bañadir, BorderLayout.SOUTH);
							panelProducto.add(tnombreProducto, BorderLayout.NORTH);
							panelProducto.add(tingredientes, BorderLayout.CENTER);
							

							panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
							//Y finalmente añadimos el panel
							panelIzquierdaAbajo.add(panelProducto);
						}
						
					}
				} catch (Exception e1) {
				}
				
			}
		});
		
		//FILTRAR SOLO POSTRES
		postres.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//----Para quitar los productos que hay añadidos-----
				Component[] components = panelIzquierdaAbajo.getComponents();
				for (Component component : components) {
					panelIzquierdaAbajo.remove(component);  
				}
				panelIzquierdaAbajo.revalidate();
				panelIzquierdaAbajo.repaint();
				//-----------------------------------------------
				ManagerDB db = new ManagerDB();
				List<Producto> todosProductos = null;
				try {
					
					db.connect();
					todosProductos = db.getTodosProductosDeUnTipo(TipoProducto.POSTRE);
					db.disconnect();
					
					int numeroProductos = todosProductos.size(); //para el layout
					
					//Para cada producto se añade al panel de productos
					for (Producto producto : todosProductos) {
						if(restaurante.getId() == producto.getIdRestaurante()) {
							JPanel panelProducto = new JPanel();
							panelProducto.setLayout(new BorderLayout());
							JLabel tnombreProducto = new JLabel(producto.getNombre());
							JButton bañadir = new JButton("AÑADIR");
							
							
							bañadir.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									listaPedido.add(producto); //LISTA QUE UTILIZAREMOS PARA EL PEDIDO 
									precio = precio+ producto.getPrecio();
									DecimalFormat df = new DecimalFormat("#.00");
									precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
									
									
									modeloPedido.addElement(producto.toStringPrecio());

								}
							});
							
							
							//Los ingredientes del producto
							JTextArea tingredientes = new JTextArea();
							tingredientes.append("INGREDIENTES:" + "\n");
							StringTokenizer st = new StringTokenizer(producto.getIngredientes(), " ,");
							 while (st.hasMoreTokens()) {
								 String token = st.nextToken();
								 tingredientes.append(" - " + token + "\n");
							 }
							
							tingredientes.setEditable(false);
							
							panelProducto.add(bañadir, BorderLayout.SOUTH);
							panelProducto.add(tnombreProducto, BorderLayout.NORTH);
							panelProducto.add(tingredientes, BorderLayout.CENTER);
							

							panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
							//Y finalmente añadimos el panel
							panelIzquierdaAbajo.add(panelProducto);
						}
						
					}
				} catch (Exception e1) {
				}
				
			}
		});

		//FILTRAR SOLO PRINCIPALES
		principales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//----Para quitar los productos que hay añadidos-----
				Component[] components = panelIzquierdaAbajo.getComponents();
				for (Component component : components) {
					panelIzquierdaAbajo.remove(component);  
				}
				panelIzquierdaAbajo.revalidate();
				panelIzquierdaAbajo.repaint();
				//-----------------------------------------------
				ManagerDB db = new ManagerDB();
				List<Producto> todosProductos = null;
				try {
					
					db.connect();
					todosProductos = db.getTodosProductosDeUnTipo(TipoProducto.PRINCIPAL);
					db.disconnect();
					
					int numeroProductos = todosProductos.size(); //para el layout
					
					//Para cada producto se añade al panel de productos
					for (Producto producto : todosProductos) {
						if(restaurante.getId() == producto.getIdRestaurante()) {
							JPanel panelProducto = new JPanel();
							panelProducto.setLayout(new BorderLayout());
							JLabel tnombreProducto = new JLabel(producto.getNombre());
							JButton bañadir = new JButton("AÑADIR");
							
							
							bañadir.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									listaPedido.add(producto); //LISTA QUE UTILIZAREMOS PARA EL PEDIDO 
									precio = precio+ producto.getPrecio();
									DecimalFormat df = new DecimalFormat("#.00");
									precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
									
									
									modeloPedido.addElement(producto.toStringPrecio());

								}
							});
							
							
							//Los ingredientes del producto
							JTextArea tingredientes = new JTextArea();
							tingredientes.append("INGREDIENTES:" + "\n");
							StringTokenizer st = new StringTokenizer(producto.getIngredientes(), " ,");
							 while (st.hasMoreTokens()) {
								 String token = st.nextToken();
								 tingredientes.append(" - " + token + "\n");
							 }
							
							tingredientes.setEditable(false);
							
							panelProducto.add(bañadir, BorderLayout.SOUTH);
							panelProducto.add(tnombreProducto, BorderLayout.NORTH);
							panelProducto.add(tingredientes, BorderLayout.CENTER);
							

							panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
							//Y finalmente añadimos el panel
							panelIzquierdaAbajo.add(panelProducto);
						}
						
					}
				} catch (Exception e1) {
				}
				
			}
		});
		
		//FILTRAR SOLO POR MENUS
		menus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//----Para quitar los productos que hay añadidos-----
				Component[] components = panelIzquierdaAbajo.getComponents();
				for (Component component : components) {
					panelIzquierdaAbajo.remove(component);  
				}
				panelIzquierdaAbajo.revalidate();
				panelIzquierdaAbajo.repaint();
				//-----------------------------------------------
				ManagerDB db = new ManagerDB();
				List<Menu> todosMenus = null;
				try {
					
					db.connect();
					todosMenus = db.getTodosMenus();
					db.disconnect();
					
					int numeroMenus = todosMenus.size(); //para el layout
					
					//Para cada producto se añade al panel de productos
					for (Menu menu : todosMenus) {
						if(restaurante.getId() == menu.getIdRestaurante()) {
							JPanel panelMenu = new JPanel();
							panelMenu.setLayout(new BorderLayout());
							JLabel tnombreMenu = new JLabel(menu.getNombre());
							JButton bañadir = new JButton("AÑADIR");
							
							
							bañadir.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									listaPedidoMenu.add(menu); //LISTA QUE UTILIZAREMOS PARA EL PEDIDO 
									precio = precio+ menu.getPrecio();
									DecimalFormat df = new DecimalFormat("#.00");
									precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
									
									
									modeloPedido.addElement(menu.toString());

								}
							});
							
							
							//Los ingredientes del producto
							JTextArea tproductosMenu = new JTextArea();
							tproductosMenu.append("PRODUCTOS:" + "\n");
							
							for (Producto producto : menu.getProductos()) {
								tproductosMenu.append(" - " + producto.toString() + "\n");
							}
							
							tproductosMenu.setEditable(false);
							
							panelMenu.add(bañadir, BorderLayout.SOUTH);
							panelMenu.add(tnombreMenu, BorderLayout.NORTH);
							panelMenu.add(tproductosMenu, BorderLayout.CENTER);
							

							panelMenu.setBorder(BorderFactory.createLineBorder(Color.black, 5));
							//Y finalmente añadimos el panel
							panelIzquierdaAbajo.add(panelMenu);
						}
						
					}
				} catch (Exception e1) {
				}
				
			}
		});
		
		
		
		//FILTRAR SOLO ENTRANTES
		entrantes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//----Para quitar los productos que hay añadidos-----
				Component[] components = panelIzquierdaAbajo.getComponents();
				for (Component component : components) {
					panelIzquierdaAbajo.remove(component);  
				}
				panelIzquierdaAbajo.revalidate();
				panelIzquierdaAbajo.repaint();
				//-----------------------------------------------
				ManagerDB db = new ManagerDB();
				List<Producto> todosProductos = null;
				try {
					
					db.connect();
					todosProductos = db.getTodosProductosDeUnTipo(TipoProducto.ENTRANTE);
					db.disconnect();
					
					int numeroProductos = todosProductos.size(); //para el layout
					
					//Para cada producto se añade al panel de productos
					for (Producto producto : todosProductos) {
						if(restaurante.getId() == producto.getIdRestaurante()) {
							JPanel panelProducto = new JPanel();
							panelProducto.setLayout(new BorderLayout());
							JLabel tnombreProducto = new JLabel(producto.getNombre());
							JButton bañadir = new JButton("AÑADIR");
							
							
							bañadir.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {

									listaPedido.add(producto); //LISTA QUE UTILIZAREMOS PARA EL PEDIDO 
									precio = precio+ producto.getPrecio();
									DecimalFormat df = new DecimalFormat("#.00");
									precioActual.setText("Precio actual:" + String.valueOf(df.format(precio)) + "€");
									
									
									modeloPedido.addElement(producto.toStringPrecio());

								}
							});
							
							
							//Los ingredientes del producto
							JTextArea tingredientes = new JTextArea();
							tingredientes.append("INGREDIENTES:" + "\n");
							StringTokenizer st = new StringTokenizer(producto.getIngredientes(), " ,");
							 while (st.hasMoreTokens()) {
								 String token = st.nextToken();
								 tingredientes.append(" - " + token + "\n");
							 }
							
							tingredientes.setEditable(false);
							
							panelProducto.add(bañadir, BorderLayout.SOUTH);
							panelProducto.add(tnombreProducto, BorderLayout.NORTH);
							panelProducto.add(tingredientes, BorderLayout.CENTER);
							

							panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
							//Y finalmente añadimos el panel
							panelIzquierdaAbajo.add(panelProducto);
						}
						
					}
				} catch (Exception e1) {
				}
				
			}
		});
		
		
		
		
		
		
		
		JScrollPane scroll = new JScrollPane(panelIzquierdaAbajo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panelIzquierda.add(scroll); //aqui se añade panelIzquierdaAbajo (el de los productos) metido en el scroll
		panelIzquierdaAbajo.setBackground(Color.red);
		panelGeneral.add(panelIzquierda);

<<<<<<< HEAD
		// Panel derecha
		JPanel panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(6, 2));
		DefaultListModel modeloPedido = new DefaultListModel();
		ArrayList<Producto> productos = new ArrayList<Producto>();


		JList listaProductos = new JList();
		JLabel nombrePedido = new JLabel("PEDIDO ACTUAL:");
		JButton eliminar = new JButton("ELIMINAR");
		JButton pagar = new JButton("PAGAR");
		JLabel precioActual = new JLabel("Precio actual" + precio);

		if (!productos.isEmpty()) {
			for (Producto producto : productos) {
				// el producto sin tostring de prueba
				modeloPedido.addElement(producto.toStringPrecio());

			}

		}

		listaProductos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				System.out.println("Seleccionar");
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					Object producto = (Object) listaProductos.getSelectedValue();

				}

			}

		});
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Producto a = new Producto("NOMBRE", 001, 15.5, "pizza", null, false, TipoProducto.PRINCIPAL, 001);

				/*
				 * protected String nombre; protected int id; protected double precio; protected
				 * String descripcion; protected List<String> ingredientes; protected boolean
				 * vegano; protected TipoProducto tipo; protected int idRestaurante;
				 */

				a.setNombre(text1.getText());
				productos.add(a);
				// problema precio
				precio = +a.getPrecio();
				precioActual.setText("");
				modeloPedido.addElement(a.toStringPrecio());

			}
		});

		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaProductos.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Selecciona un producto para eliminar");

				} else {
					System.out.println("entrando en eliminar");
					System.out.println(listaProductos.getSelectedValue());
					Object producto = (Object) listaProductos.getSelectedValue();
					int i = (int) listaProductos.getSelectedIndex();
					productos.remove(i);
					modeloPedido.remove(i);

				}

			}
		});

=======
		
		
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3.git
		pagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Pedido pedido = new Pedido();
				pedido.setRestaurante(restaurante);
				pedido.setProductos(listaPedido);
				pedido.setMenus(listaPedidoMenu);
				pedido.setUsuario(usuario);
				DecimalFormat df = new DecimalFormat("#.00");				
				pedido.setPreciototal(Double.parseDouble(df.format(precio)));


				ManagerDB db = new ManagerDB();
				
				try {
					db.connect();
					db.insertarPedido(pedido);
					db.disconnect();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		
		
		atras.addActionListener(new ActionListener() {

			

			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				dispose();
				
				
			}
		});
		



		jlistaProductos.setModel(modeloPedido);
		panelDerecha.add(jlistaProductos, 1, 0);

		panelDerecha.add(eliminar, 2, 1);
		panelDerecha.add(pagar, 2, 2);
		panelDerecha.add(precioActual, 2, 3);

		panelDerecha.add(nombrePedido, 3, 0);

		panelGeneral.add(panelDerecha);
		add(panelGeneral);

	}
	

		
		
	
	

}
