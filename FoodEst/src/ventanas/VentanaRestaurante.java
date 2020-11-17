package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import clases.Articulo;
import clases.Pedido;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaRestaurante extends JFrame {

	public VentanaRestaurante() {
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
		ImageIcon fot = new ImageIcon("src/Imagenes/key.png");
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();//articulos añadidos a pedidos
		ArrayList<Articulo> items= new ArrayList<Articulo>();
		articulos.add(new Articulo());
		articulos.add(new Articulo());
		articulos.add(new Articulo());
		Pedido pedidoActual = new Pedido(000, "", "", "", articulos, 0, "", false);

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

		panelNombreArriba.add(titulo, BorderLayout.WEST);
		panelIzquierda.add(panelNombre);

		// Panel izquierdaAbajo
		JPanel panelIzquierdaAbajo = new JPanel();
		panelIzquierdaAbajo.setLayout(new GridLayout(2, 4, 30, 30)); // meter separacion entre espacios

		// PANEL1
		ArrayList<JPanel>panelesArticulos=new ArrayList<JPanel>();
		JButton b1 = new JButton("AÑADIR");
		JLabel text1 = new JLabel("HAMBURGUESA");
		JTextArea text2 = new JTextArea("INGREDIENTES:\n -Pan\n -Lechuga \n -Carne");
		text2.setEditable(false);
		JButton b2 = new JButton("AÑADIR");
		JLabel text3 = new JLabel("Perrito");
		JTextArea text4 = new JTextArea("INGREDIENTES:\n -Pan\n -Lechuga \n -Carne");
		text2.setEditable(false);

		// PANEL1-foto1
		for (Articulo a : articulos) {
			JPanel articulo=new JPanel();
			JButton añadir = new JButton("AÑADIR");
			JLabel nombre = new JLabel("HAMBURGUESA");
			JTextArea texto = new JTextArea("INGREDIENTES:\n -Pan\n -Lechuga \n -Carne");
			texto.setEditable(false);
			panelesArticulos.add(articulo);
			
		}
		JPanel area1 = new JPanel();
		area1.setLayout(new BorderLayout());
		area1.add(b1, BorderLayout.SOUTH);
		area1.add(text1, BorderLayout.NORTH);
		area1.add(text2, BorderLayout.CENTER);

		JPanel area2 = new JPanel();
		area2.setLayout(new BorderLayout());
		area2.add(b2, BorderLayout.SOUTH);
		area2.add(text3, BorderLayout.NORTH);
		area2.add(text4, BorderLayout.CENTER);
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

		JList listaArticulos = new JList();
		JLabel nombrePedido = new JLabel("PEDIDO ACTUAL:");
		JButton eliminar = new JButton("ELIMINAR");
		JButton pagar = new JButton("PAGAR");

		if (!articulos.isEmpty()) {
			for (Articulo articulo : articulos) {
				modeloPedido.addElement(articulo.toString());

			}

		}

		listaArticulos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {

					Articulo articulo = (Articulo) listaArticulos.getSelectedValue();

				}

			}

		});
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// crear objeto Articulo con datos base datos

				Articulo a = new Articulo(text1.getText(), 12, "", null, false);
				articulos.add(a);
				System.out.println("add22");
				modeloPedido.addElement(a.toString());

			}
		});

		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				eliminarArticulo(listaArticulos, modeloPedido);

			}
		});
		
		//JFrame jj=new JFrame(this);
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new VentanaBuscador();
				

			}
		});
		
		entrantes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				area1.setVisible(false);
				

			}
		});
		
		
		
		int precio = 12;
		pagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pedidoActual.setRestaurante(titulo.getText());
				pedidoActual.setPreciototal(precio);
				new VentanaPago(pedidoActual);
				setVisible(false);

			}
		});

		listaArticulos.setModel(modeloPedido);
		panelDerecha.add(listaArticulos, 1, 0);
		panelDerecha.add(eliminar, 2, 1);
		panelDerecha.add(pagar, 2, 2);

		panelDerecha.add(nombrePedido, 3, 0);

		panelGeneral.add(panelDerecha);
		add(panelGeneral);

	}

	void actualizarPrecio(ArrayList<Articulo> articulos,ArrayList<JPanel> panelesArticulos) {
		float precioFinal=0;
		for (Articulo a : articulos) {
			
			precioFinal=precioFinal+a.getPrecio();
			

		}

	}

	void refrescarLista(ArrayList<Articulo> articulos, DefaultListModel modeloPedido) {
		if (!articulos.isEmpty()) {
			for (Articulo articulo : articulos) {
				modeloPedido.addElement(articulo.toString());

			}

		}
	}

	void eliminarArticulo(JList listaArticulos, DefaultListModel modeloPedido) {
		if (listaArticulos.getSelectedValue() == null) {
			JOptionPane.showMessageDialog(null, "Selecciona un producto para eliminar");

		} else {

			modeloPedido.removeElement(listaArticulos.getSelectedValue());

		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaRestaurante();

			}
		});

	}

}
