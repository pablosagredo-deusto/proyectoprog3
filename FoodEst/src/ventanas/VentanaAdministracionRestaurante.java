package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
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
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.ManagerDB;
import clases.Producto;
import clases.Restaurante;
import clases.TipoProducto;
import clases.Usuario;


public class VentanaAdministracionRestaurante extends JFrame{


	public VentanaAdministracionRestaurante(Restaurante restaurante) {
		//PANEL DERECHA
		JPanel panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(2,1));
		
		JPanel panelBotonesArriba = new JPanel();
		JButton ba�adirProducto = new JButton("A�adir producto");
		JButton bmisDatos = new JButton("Datos del restaurante");
		
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(ba�adirProducto);
		panelBotones.add(bmisDatos);
		
		panelBotonesArriba.setLayout(new GridLayout(2,1));
		panelBotonesArriba.add(new JPanel());
		panelBotonesArriba.add(panelBotones);
		
		
		
		
		
		
		JPanel productosDisponibles = new JPanel();
		JScrollPane scrollProductosDisponibles = new JScrollPane(productosDisponibles);

		
		panelDerecha.add(panelBotonesArriba);
		panelDerecha.add(scrollProductosDisponibles);
		
	
		
		
		
		ManagerDB db = new ManagerDB();
		List<Producto> productos;
		try {
			
			db.connect();
			productos = db.getTodosProductos();
			db.disconnect();
			
			int numeroProductos = productos.size();
			
			for (Producto producto : productos) {
				if(restaurante.getId() == producto.getIdRestaurante()) {
					JPanel panel = new JPanel();
					panel.setLayout(new BorderLayout());
					Border blackLine = BorderFactory.createLineBorder(Color.black);
					panel.setBorder(blackLine);
					
					JLabel lnombre = new JLabel(producto.getNombre());
					panel.add(lnombre, BorderLayout.NORTH);
					
					JTextArea textIngredientes = new JTextArea();
					for (String ingrediente : producto.getIngredientes()) {
						textIngredientes.setText(ingrediente + "\n");
					}
					textIngredientes.setEditable(false);
					panel.add(textIngredientes, BorderLayout.CENTER);
					
					JButton beliminar = new JButton("Eliminar");
					panel.add(beliminar, BorderLayout.SOUTH);
					
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
					
					
					productosDisponibles.add(panel);
					
				}
				
			}
		} catch (Exception e) {
		}	
		
		
		
		
		
		
		
		//PANEL IZQUIERDA
		
		JSplitPane panelIzquierda = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelIzquierda.setBorder(null);
		panelIzquierda.setResizeWeight(0.15); // Esto es el porcentaje de la parte de la izquierda ---> ajustar
		panelIzquierda.setEnabled(false);
		panelIzquierda.setDividerSize(0);
		
		
		
		JPanel panelArriba = new JPanel();
		JLabel titulo = new JLabel("ADMINISTRACION DE " + restaurante.getNombre());
		titulo.setFont(new Font("Cooper Black", Font.BOLD, 20));
		panelArriba.add(titulo);
		
		JSplitPane panelAbajo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelAbajo.setBorder(null);
		panelAbajo.setResizeWeight(0.80); 
		panelAbajo.setEnabled(false);
		panelAbajo.setDividerSize(0);
		
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

	    
	    panelAbajo.add(panelAbajoPedidos);
	    panelAbajo.add(panelAbajoBotones);
	    
	    panelIzquierda.add(panelArriba);
	    panelIzquierda.add(panelAbajo);
	    
	    
	    JFrame thisFrame = this;
		
	    ba�adirProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaA�adirProducto(restaurante, thisFrame, productosDisponibles);
				
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
		setSize(1150, 505);
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


//VENTANA PARA A�ADIR PRODUCTO
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
