package ventanas;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaRestaurante extends JFrame {

	public VentanaRestaurante(String tituloRestaurante) {
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
		JLabel titulo = new JLabel(tituloRestaurante);
		
		Font font = new Font("Cooper Black", Font.BOLD, 40);
		titulo.setFont(font);

		panelNombre.setBackground(Color.red);

		// nombre panelNombreArriba
		JPanel panelNombreArriba = new JPanel();
		panelNombreArriba.setLayout(new BorderLayout());

		// nombre panelNombreAbajo
		JPanel panelNombreAbajo = new JPanel();
		panelNombreAbajo.setLayout(new GridLayout(0,5));
		
		JButton entrantes =new JButton("ENTRANTES");
		JButton principales=new JButton("PRINCIPALES");
		JButton segundos=new JButton("SEGUNDOS");
		JButton postres=new JButton("POSTRES");
		JButton buscar=new JButton();
		ImageIcon fot = new ImageIcon("src/Imagenes/lupa.png");
		buscar.setSize(40,40);
		Icon icono = new ImageIcon(
				fot.getImage().getScaledInstance(buscar.getWidth(), buscar.getHeight(), Image.SCALE_DEFAULT));
		buscar.setIcon(icono);
		buscar.repaint();
		buscar.setOpaque(false);
		buscar.setContentAreaFilled(false);
		buscar.setBorderPainted(false);
		
		panelNombreAbajo.add(entrantes,0,0);
		panelNombreAbajo.add(principales,0,1);
		panelNombreAbajo.add(segundos,0,2);
		panelNombreAbajo.add(postres,0,3);
		panelNombreAbajo.add(buscar,0,4);
		
		
		
		panelNombre.add(panelNombreArriba);
		panelNombre.add(panelNombreAbajo);

		panelNombreArriba.add(titulo, BorderLayout.WEST);
		
		//añadir jmenubar
		

		panelIzquierda.add(panelNombre);

		// Panel izquierdaAbajo
		JPanel panelIzquierdaAbajo = new JPanel();
		panelIzquierdaAbajo.setLayout(new GridLayout(2, 4,30,30)); // meter separacion entre espacios
		
		
		//PANEL1
		JPanel area1=new JPanel();
		JLabel text1=new JLabel("HAMBURGUESA");
		JButton b1=new JButton("AÑADIR");
		JTextArea text2=new JTextArea("INGREDIENTES:");
		text2.setEditable(false);
		
		
		//PANEL1-foto1
		
		area1.add(b1);
		area1.add(text1);
		area1.add(text2);
		
		JPanel area2=new JPanel();
		JPanel area3=new JPanel();
		JPanel area4=new JPanel();
		JPanel area5=new JPanel();
		JPanel area6=new JPanel();
		JPanel area7=new JPanel();
		
		
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
		//scroll.add(area);

		panelIzquierdaAbajo.setBackground(Color.red);

		panelGeneral.add(panelIzquierda);

		// Panel derecha
		JPanel panelDerecha = new JPanel();
		panelGeneral.add(panelDerecha);
		add(panelGeneral);

	}
/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaRestaurante();

			}
		});

	}
*/
}
