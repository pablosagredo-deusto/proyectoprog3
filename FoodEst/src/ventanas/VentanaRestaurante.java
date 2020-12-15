package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import clases.*;

import javax.swing.*;

public class VentanaRestaurante extends JFrame {

	public VentanaRestaurante(JFrame ventanaAnterior, Restaurante restaurante) {
		super("restaurante");
		setSize(1150, 505);
		setVisible(true);

		// PANEL GENERAL : parte izquierda y parte derecha
		JSplitPane panelGeneral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		panelGeneral.setBorder(null);
		panelGeneral.setResizeWeight(0.66); // Esto es el porcentaje de la parte de la izquierda ---> ajustar
		panelGeneral.setEnabled(false);
		panelGeneral.setDividerSize(0);

		// Panel izquierda

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
		JLabel titulo = new JLabel("KFC");
		JButton atras = new JButton(new ImageIcon("src/imagenes/logoAtras2.png"));

		Font font = new Font("Cooper Black", Font.BOLD, 40);
		titulo.setFont(font);

		panelNombre.setBackground(Color.red);

		// nombre panelNombreArriba
		JPanel panelNombreArriba = new JPanel();
		panelNombreArriba.setLayout(new BorderLayout());

		// nombre panelNombreAbajo
		JPanel panelNombreAbajo = new JPanel();
		panelNombreAbajo.setLayout(new GridLayout(0, 5));

		JButton entrantes = new JButton("ENTRANTES");
		JButton principales = new JButton("PRINCIPALES");
		JButton segundos = new JButton("SEGUNDOS");
		JButton postres = new JButton("POSTRES");
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

		panelNombreAbajo.add(entrantes, 0, 0);
		panelNombreAbajo.add(principales, 0, 1);
		panelNombreAbajo.add(segundos, 0, 2);
		panelNombreAbajo.add(postres, 0, 3);
		panelNombreAbajo.add(buscar, 0, 4);

		panelNombre.add(panelNombreArriba);
		panelNombre.add(panelNombreAbajo);

		panelNombreArriba.add(titulo, BorderLayout.CENTER);
		panelNombreArriba.add(atras, BorderLayout.WEST);

		panelIzquierda.add(panelNombre);

		// Panel izquierdaAbajo
		JPanel panelIzquierdaAbajo = new JPanel();
		panelIzquierdaAbajo.setLayout(new GridLayout(2, 4, 30, 30)); // meter separacion entre espacios

		// PANEL1
		JPanel area1 = new JPanel();
		area1.setLayout(new BorderLayout());
		JLabel text1 = new JLabel("HAMBURGUESA");
		JButton b1 = new JButton("AÑADIR");
		JTextArea text2 = new JTextArea("INGREDIENTES:\n -Pan\n -Lechuga \n -Carne");
		text2.setEditable(false);

		// PANEL1-foto1

		area1.add(b1, BorderLayout.SOUTH);
		area1.add(text1, BorderLayout.NORTH);
		area1.add(text2, BorderLayout.CENTER);

		JPanel area2 = new JPanel();
		JPanel area3 = new JPanel();
		JPanel area4 = new JPanel();
		JPanel area5 = new JPanel();
		JPanel area6 = new JPanel();
		JPanel area7 = new JPanel();

		JScrollPane scroll = new JScrollPane(panelIzquierdaAbajo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		area1.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		area2.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		area3.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		area4.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		area5.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		area6.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		area7.setBorder(BorderFactory.createLineBorder(Color.black, 5));

		panelIzquierdaAbajo.add(area1);
		panelIzquierdaAbajo.add(area2);
		panelIzquierdaAbajo.add(area3);
		panelIzquierdaAbajo.add(area4);
		panelIzquierdaAbajo.add(area5);
		panelIzquierdaAbajo.add(area6);
		panelIzquierdaAbajo.add(area7);

		panelIzquierda.add(scroll);

		panelIzquierdaAbajo.setBackground(Color.red);

		panelGeneral.add(panelIzquierda);

		// Panel derecha
		JPanel panelDerecha = new JPanel();
		panelDerecha.setLayout(new GridLayout(6, 2));
		DefaultListModel modeloPedido = new DefaultListModel();
		ArrayList<Producto> productos = new ArrayList<Producto>();

		//productos.add(new Producto("Ensalada ", 23.0, "", null, false, TipoProducto.OTRO));
		JList listaProductos = new JList();
		JLabel nombrePedido = new JLabel("PEDIDO ACTUAL:");
		JButton eliminar = new JButton("ELIMINAR");
		JButton pagar = new JButton("PAGAR");

		if (!productos.isEmpty()) {
			for (Producto producto : productos) {
				modeloPedido.addElement(producto.toString());

			}

		}

		listaProductos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				System.out.println("BORRAR");
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {

					Producto producto = (Producto) listaProductos.getSelectedValue();

				}

			}

		});
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto a = new Producto();
				//Corregir el constructor!!
				//productos.add(a = new Producto(text1.getText(), 12, "", null, false));
				modeloPedido.addElement(a.toString());

			}
		});

		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (listaProductos.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null, "Selecciona un producto para eliminar");

				} else {
					Producto producto = (Producto) listaProductos.getSelectedValue();
					int i=(int) listaProductos.getSelectedValue();
					productos.remove(i);
					modeloPedido.removeElement(producto);


				}

			}
		});

		pagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPago();
				setVisible(false);

			}
		});
		
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				dispose();
				
				
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

		panelDerecha.add(nombrePedido, 3, 0);

		panelGeneral.add(panelDerecha);
		add(panelGeneral);

	}
}
