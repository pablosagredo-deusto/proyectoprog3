package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VentanaBuscador extends JFrame {
	
	public VentanaBuscador(JFrame ventanaAnterior,String busqueda) {
		
		JSplitPane panelGeneral = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelGeneral.setBorder(null);
		panelGeneral.setResizeWeight(0.06); 
		panelGeneral.setEnabled(false); 
		panelGeneral.setDividerSize(0);
		
		//PANEL BUSCADOR (ARRIBA)
		JPanel panelBuscador = new JPanel();
		panelBuscador.setLayout(new BorderLayout());
		
			//Panel Arriba izquierda
		JPanel panelIzquierda = new JPanel(); 
		panelIzquierda.setLayout(new GridLayout(3,1));
		JButton atras = new JButton(new ImageIcon("src/imagenes/logoAtras2.png"));
		panelIzquierda.add(atras);
		panelIzquierda.add(new JLabel(new ImageIcon("src/imagenes/lupa.png")));
		panelIzquierda.add(new JPanel());
		
		
			//Panel Arriba central
		JTextField buscador = new JTextField("¿Que producto estas buscando?");
		JPanel panelBuscadorCentral = new JPanel(); 
		panelBuscadorCentral.setLayout(new GridLayout(3,1));
		
		
		JTextArea titulo = new JTextArea("Buscador");
		titulo.setEditable(false);
		Font font = new Font("Gill Sans MT", Font.BOLD, 40);
		titulo.setFont(font);
		titulo.setOpaque(false);
		
		panelBuscadorCentral.add(titulo); //1
		panelBuscadorCentral.add(buscador); //2
		
		
		
		
					//Panel JRadioButton
		JPanel panelSelecciones = new JPanel();
		JRadioButton ocpion1 = new JRadioButton("Restaurantes");
	    JRadioButton opcion2 = new JRadioButton("Productos");
	    Box box1 = Box.createHorizontalBox();
	    box1.add(ocpion1);
	    box1.add(opcion2);

	    panelSelecciones.setLayout(new BorderLayout());
	    panelSelecciones.add(box1, BorderLayout.CENTER);
	    
		
		
		panelBuscadorCentral.add(panelSelecciones); //3
		
		
			//Panel Arriba derecha
		JButton buscar = new JButton("Buscar");
		JPanel panelBotonBuscar = new JPanel(); 
		panelBotonBuscar.setLayout(new GridLayout(3,1));
		panelBotonBuscar.add(new JPanel());
		panelBotonBuscar.add(buscar);
		panelBotonBuscar.add(new JPanel());
		
		
		
		
		panelBuscador.add(panelBuscadorCentral, BorderLayout.CENTER);
		panelBuscador.add(panelIzquierda, BorderLayout.WEST);
		panelBuscador.add(panelBotonBuscar, BorderLayout.EAST);
		
		
		
		panelGeneral.add(panelBuscador);
		
		
		
		
		
		
		
		
		
		
		
		//PANEL RESULTADOS
		JPanel panelResultados = new JPanel();
		JScrollPane scrollResultados = new JScrollPane(panelResultados);
		
		panelResultados.setLayout(new GridLayout(2,3,35,35));
		
		JPanel panelPrimerResultado = new JPanel();
		panelPrimerResultado.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelResultados.add(panelPrimerResultado);
		
		JPanel panelSegundoResultado = new JPanel();
		panelSegundoResultado.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelResultados.add(panelSegundoResultado);
		
		JPanel panelTercerResultado = new JPanel();
		panelTercerResultado.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelResultados.add(panelTercerResultado);
		
		JPanel panelCuartoResultado = new JPanel();
		panelCuartoResultado.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelResultados.add(panelCuartoResultado);
		
		JPanel panelQuintoResultado = new JPanel();
		panelQuintoResultado.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelResultados.add(panelQuintoResultado);
		
		JPanel panelSextoResultado = new JPanel();
		panelSextoResultado.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		panelResultados.add(panelSextoResultado);
		
		
		
		
		
		panelGeneral.add(panelResultados);
		
		add(panelGeneral);
		
		
		//LISTENERS
		
		buscador.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	buscador.setText("");
            }
        });
		
		
		
		
		ocpion1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JMenuBar barraTipoRestaurante = new JMenuBar();
				JMenu tipoRestaurante = new JMenu("Tipo de restaurante");
				barraTipoRestaurante.add(tipoRestaurante);
				panelSelecciones.add(barraTipoRestaurante, BorderLayout.EAST);
				
			}
		});
		
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				dispose();
				
			}
		});
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(1150, 505);
		setVisible(true);
	}
	
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaBuscador();
				
			}
		});

	}
	*/
		
}
