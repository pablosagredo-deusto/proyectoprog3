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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
		panelDerechaArriba1.add(new JPanel());	

		
		panelDerechaArriba1.add(lenvioGratisRestaurante);
		panelDerechaArriba1.add(envioGratisRestaurante);
		JButton guardarCambios = new JButton("Guardar cambios");
		panelDerechaArriba1.add(guardarCambios);	

		
		
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
		
		
		
		
				//Inserccion de menus desde la basde de datos
		ManagerDB db = new ManagerDB();
		List<Menu> menus;
		try {
			
			db.connect();
			menus = db.getTodosMenus();
			db.disconnect();
			
			
			for (Menu menu : menus) {
				if(restaurante.getId() == menu.getIdRestaurante()) {
					
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					panel.setBorder(BorderFactory.createLineBorder(Color.black));
					
					JLabel lnombre = new JLabel(menu.getNombre());
					panel.add(lnombre, BorderLayout.NORTH);
					
					
					JTextArea productosMenu = new JTextArea();
					List<Producto> todosProductos = db.getTodosProductos();
					
					for (Producto producto : todosProductos) {
						/*if (producto.getIdMenu() = menu.getId()) {
							
						}*/
					}
					
				}
				
			}
		} catch (Exception e) {
		}	
		
		
		
		
		
		
		
		
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
		
		
//		for (int i = 0; i < 80; i++) {
//		JPanel panelPruba= new JPanel();
//		panelPruba.setBorder(BorderFactory.createLineBorder(Color.black));
//		panelPruba.setLayout(new BorderLayout());
//		panelPruba.add(new JLabel("Prueba"), BorderLayout.NORTH);
//		JPanel panelmedio = new JPanel();
//		panelmedio.add(new JButton("pruba"));
//		panelmedio.add(new JButton("pruba"));
//		panelmedio.add(new JButton("pruba"));
//		
//		panelPruba.add(panelmedio, BorderLayout.CENTER);
//
//		panelPruba.add(new JButton("pruba"), BorderLayout.SOUTH);
//		
//		
//			
//		productosDisponiblesCenter.add(panelPruba);
//		}
			
			
		
		
		
	
		
		
		
		
		//Inserccion de productos desde la base de datos
		//ManagerDB db = new ManagerDB();
		List<Producto> productos;
		try {
			
			//db.connect();
			productos = db.getTodosProductos();
			db.disconnect();
			
			
			for (Producto producto : productos) {
				if(restaurante.getId() == producto.getIdRestaurante()) {
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					panel.setBorder(BorderFactory.createLineBorder(Color.black));
					
					JLabel lnombre = new JLabel(producto.getNombre());
					panel.add(lnombre, BorderLayout.NORTH);
					
					JTextArea textIngredientes = new JTextArea();
					textIngredientes.setText("Ingredientes:");
					for (String ingrediente : producto.getIngredientes()) {
						textIngredientes.setText(ingrediente + "\n");
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
				new VentanaA�adirProducto(restaurante, thisFrame, productosDisponibles);
				
			}
		});
	    
	    
	    
	    
	    String data[][];   
	    String nombreColumnas[]={"ID","DIRECCION","PRODUCTOS", "PRECIO", "PAGO", "CUBIERTOS"};
	    DefaultTableModel modeloTabla = new DefaultTableModel(data, nombreColumnas);
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
	
	public VentanaA�adirProducto(Restaurante restaurante , JFrame ventanaAnterior, JPanel panelProductos) {
		
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
				Producto productoNuevo = new Producto(); 
				
				productoNuevo.setNombre(tnombre.getText());
				productoNuevo.setDescripcion(tdescripcion.getText());
				productoNuevo.setPrecio(Double.parseDouble(tprecio.getText()));
				productoNuevo.setVegano(checkvegano.isSelected());
				String tipoElegido = (String) comboTipoProducto.getSelectedItem();
				productoNuevo.setTipo(TipoProducto.valueOf(tipoElegido));
				productoNuevo.setIdRestaurante(restaurante.getId());
				
				
				String ingredientes = tingredientes.getText();
				List<String> ingredientesList = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(ingredientes, ",");
				while (st.hasMoreTokens()) {
					 String token = st.nextToken();
					 ingredientesList.add(token);
				}
				productoNuevo.setIngredientes(ingredientesList);
				

				
				dispose();
				ventanaAnterior.dispose();
				new VentanaAdministracionRestaurante(restaurante);
				 
			}
		});
		
		

	}
}
