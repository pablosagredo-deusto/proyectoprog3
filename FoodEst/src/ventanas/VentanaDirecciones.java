package ventanas;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import clases.Direccion;


public class VentanaDirecciones extends JFrame{

	public VentanaDirecciones() {
		
		
		JSplitPane panelGeneral = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelGeneral.setBorder(null);
		panelGeneral.setResizeWeight(0.06); 
		panelGeneral.setEnabled(false); 
		panelGeneral.setDividerSize(0); 
		
		
		
		
		
		
		
		
		
		//PANEL ARRIBA
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(2,1));
		
			//panel TITULO
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new BorderLayout());
		
		JTextArea titulo = new JTextArea("Tus direcciones");
		titulo.setEditable(false);
		Font font = new Font("Gill Sans MT", Font.BOLD, 40);
		titulo.setFont(font);
		titulo.setOpaque(false);
		
		
		
		JButton atras = new JButton(new ImageIcon("src/imagenes/logoAtras2.png"));
		
		
		panelTitulo.add(atras, BorderLayout.WEST);
		panelTitulo.add(titulo, BorderLayout.CENTER);
		
		panelArriba.add(panelTitulo);
		
			//panel Añadir direcciones
		JPanel panelAñadir = new JPanel();
		JLabel labelLogoUbicacion = new JLabel();
		labelLogoUbicacion.setIcon(new ImageIcon("src/imagenes/ubicacion.png"));
		JButton añadir = new JButton("AÑADIR");
		JTextField direccion = new JTextField("C/Municipio/Calle/Portal/Piso-Puerta");
		JTextField nombreDireccion = new JTextField("Nombre de dirección");
		JTextField codigoPostal = new JTextField("Código postal");
		JLabel labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon("src/Imagenes/ubicacion.png"));
		
		
		panelAñadir.add(labelLogo);
		panelAñadir.add(nombreDireccion);
		panelAñadir.add(codigoPostal);
		panelAñadir.add(direccion);
		panelAñadir.add(añadir);
		
		
		panelArriba.add(panelAñadir);
		
		
		
		
		panelGeneral.add(panelArriba);
		
		
		
		

		//PANEL ABAJO
		
		
		JSplitPane panelAbajo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelAbajo.setBorder(null);
		panelAbajo.setResizeWeight(0.90); 
		panelAbajo.setEnabled(false); 
		panelAbajo.setDividerSize(0); 
		
		//Panel direcciones (donde se van a añadir las direcciones)
		JPanel panelDirecciones = new JPanel();
		JScrollPane scrollPanelDirecciones = new JScrollPane(panelDirecciones);
		panelAbajo.add(panelDirecciones);
		
		JList listaDirecciones = new JList();
		DefaultListModel modeloListaDirecciones = new DefaultListModel();
		listaDirecciones.setModel(modeloListaDirecciones);
		panelDirecciones.add(listaDirecciones);
		
		JPanel panelAbajoBotones = new JPanel();
		JButton botonBorrarUbicacion =  new JButton("Borrar direccion");
		JButton botonBorrarTodasUbicaciones =  new JButton("Borrar todas");
		panelAbajoBotones.add(botonBorrarUbicacion);
		panelAbajoBotones.add(botonBorrarTodasUbicaciones);
		panelAbajo.add(panelAbajoBotones);
		
		panelGeneral.add(panelAbajo);
	
		
		
		
		
		
		add(panelGeneral);
		
		
		
		
		
		
		
		
		
		//LISTENERS
		
		nombreDireccion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	nombreDireccion.setText("");
            }
        });
		direccion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	direccion.setText("");
            }
        });
		codigoPostal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	codigoPostal.setText("");
            }
        });
		
		añadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Direccion nueva = new Direccion();
				nueva.setDireccion(direccion.getText());
				nueva.setCodigoPostal(Integer.parseInt(codigoPostal.getText()));
				nueva.setNombre(nombreDireccion.getText());
				modeloListaDirecciones.addElement(nueva);
				
			}
		});
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(1150, 505);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaDirecciones();
				
			}
		});

	}
	
		
}
