package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import clases.*;

import javax.swing.*;
import javax.swing.border.Border;

public class VentanaRestaurante extends JFrame {
	
	Producto a;
	Pedido p;
	double precio=0.0;

	public VentanaRestaurante(JFrame ventanaAnterior, Restaurante restaurante) {
		super("restaurante");
		setSize(1150, 505);
		setVisible(true);
		

		// PANEL GENERAL 
		JSplitPane panelGeneral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		panelGeneral.setBorder(null);
		panelGeneral.setResizeWeight(0.66); // Esto es el porcentaje de la parte de la izquierda ---> ajustar
		panelGeneral.setEnabled(false);
		panelGeneral.setDividerSize(0);
		
		//--------------------------------Panel DERECHA-------------------------------------
				JPanel panelDerecha = new JPanel();
				panelDerecha.setLayout(new GridLayout(6, 2));
				DefaultListModel modeloPedido = new DefaultListModel();
				ArrayList<Producto> productosPedido = new ArrayList<Producto>();

				
				JList listaProductos = new JList();
				JLabel nombrePedido = new JLabel("PEDIDO ACTUAL:");
				JButton eliminar = new JButton("ELIMINAR");
				JButton pagar = new JButton("PAGAR");
				JLabel precioActual= new JLabel("Precio actual"+precio);
				

				

				listaProductos.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						System.out.println("Seleccionar");
						JList list = (JList) evt.getSource();
						if (evt.getClickCount() == 2) {
							Object producto = (Object) listaProductos.getSelectedValue();
							

						}

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
							int i=(int) listaProductos.getSelectedIndex();
							productosPedido.remove(i);
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
		JSplitPane panelNombre = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelNombre.setBorder(null);
		panelNombre.setResizeWeight(0.15);
		panelNombre.setEnabled(false);
		panelNombre.setDividerSize(0);
		JLabel titulo = new JLabel(restaurante.getNombre());
		JButton atras = new JButton(new ImageIcon("src/imagenes/logoAtras2.png"));

		Font font = new Font("Cooper Black", Font.BOLD, 40);
		titulo.setFont(font);
		panelNombre.setBackground(Color.red);

		// nombre panelNombreArriba
		JPanel panelNombreArriba = new JPanel();
		panelNombreArriba.setLayout(new BorderLayout());

		// nombre panelNombreAbajo
		JPanel panelNombreAbajo = new JPanel();
		panelNombreAbajo.setLayout(new GridLayout(1, 5));

		JButton entrantes = new JButton("ENTRANTES");
		JButton principales = new JButton("PRINCIPALES");
		JButton segundos = new JButton("SEGUNDOS");
		JButton postres = new JButton("POSTRES");
		JButton bebidas = new JButton("BEBIDAS");

		ImageIcon fot = new ImageIcon("src/Imagenes/key .png");
		

		panelNombreAbajo.add(entrantes);
		panelNombreAbajo.add(principales);
		panelNombreAbajo.add(segundos);
		panelNombreAbajo.add(postres);
		panelNombreAbajo.add(bebidas);

		panelNombre.add(panelNombreArriba);
		panelNombre.add(panelNombreAbajo);

		panelNombreArriba.add(titulo, BorderLayout.CENTER);
		panelNombreArriba.add(atras, BorderLayout.WEST);

		panelIzquierda.add(panelNombre);

		// Panel izquierdaAbajo
		JPanel panelIzquierdaAbajo = new JPanel();
		panelIzquierdaAbajo.setLayout(new GridLayout(2, 4, 30, 30)); // meter separacion entre espacios

		// PRODUCTOS DEL RESTAURANTE EN PanelIzquierdaAbajo
		ManagerDB db = new ManagerDB();
		List<Producto> productosRestaurante;
		try {
			
			db.connect();
			productosRestaurante = db.getTodosProductos();
			db.disconnect();
			
			int numeroProductos = productosRestaurante.size(); //para el layout
			
			for (Producto producto : productosRestaurante) {
				if(restaurante.getId() == producto.getIdRestaurante()) {
					JPanel panelProducto = new JPanel();
					panelProducto.setLayout(new BorderLayout());
					JLabel tnombreProducto = new JLabel(producto.getNombre());
					JButton bañadir = new JButton("AÑADIR");
					
					
					bañadir.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							

							a.setNombre(producto.getNombre());
							productosPedido.add(a);
							//problema precio
							precio=+ producto.getPrecio();
							precioActual.setText("");
							modeloPedido.addElement(a.toStringPrecio());

						}
					});
					
					JTextArea tingredientes = new JTextArea("INGREDIENTES:\n");
					for (String ingrediente : producto.getIngredientes()) {
						tingredientes.setText(ingrediente + "\n");
					}
					
					tingredientes.setEditable(false);
					
					panelProducto.add(bañadir, BorderLayout.SOUTH);
					panelProducto.add(tnombreProducto, BorderLayout.NORTH);
					panelProducto.add(tingredientes, BorderLayout.CENTER);
					

					panelProducto.setBorder(BorderFactory.createLineBorder(Color.black, 5));
					panelIzquierdaAbajo.add(panelProducto);
				}
				
			}
		} catch (Exception e) {
		}	
		
		
		
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				dispose();
				
				
			}
		});
		
		
		/* NO SE QUE ES ESTO
		if (!productos.isEmpty()) {
			for (Producto producto : productos) {
				//el producto sin tostring de prueba
				modeloPedido.addElement(producto.toStringPrecio());

			}

		}
		*/
		
		

		JScrollPane scroll = new JScrollPane(panelIzquierdaAbajo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panelIzquierda.add(scroll);
		panelIzquierdaAbajo.setBackground(Color.red);
		panelGeneral.add(panelIzquierda);

		
		
		pagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Pedido pedido = new Pedido(1, restaurante, null, EstadoPedido.RECIBIDO, productosPedido, 50.5, "Efectivo", false);
				for (Producto producto : productosPedido) {
					System.out.println(producto.toStringPrecio());
				}
//				new VentanaPago(pedido);
//				setVisible(false);

			}
		});
		
		
		
		
		/*
		entrantes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Producto producto : restaurante.productos) {
					
				}
				
			}
		});
		*/
		

		listaProductos.setModel(modeloPedido);
		panelDerecha.add(listaProductos, 1, 0);
		panelDerecha.add(eliminar, 2, 1);
		panelDerecha.add(pagar, 2, 2);
		panelDerecha.add(precioActual, 2, 3);

		panelDerecha.add(nombrePedido, 3, 0);

		panelGeneral.add(panelDerecha);
		add(panelGeneral);

	}
	
	
		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					Restaurante restaurante = new Restaurante("BurguerKing", "Comida rapida", "password", "C/Leioa/Calle Menor/8/00",
							null, false);
					VentanaRestaurante vrest = new VentanaRestaurante(null,restaurante);
					
				}
			});
		}
		
		
	
	
}
