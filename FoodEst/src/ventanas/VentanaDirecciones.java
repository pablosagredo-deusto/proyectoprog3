package ventanas;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

<<<<<<< HEAD
=======
import clases.Direccion;
import clases.Usuario;
import homeControl.Cancion;

>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3

public class VentanaDirecciones extends JFrame{

	public VentanaDirecciones(JFrame ventanaAnterior, Usuario usuario) {
		
		
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
		
			//panel A�adir direcciones
		JPanel panelA�adir = new JPanel();
		JButton a�adir = new JButton("A�ADIR");
<<<<<<< HEAD
		JTextField direccion = new JTextField("C/Municipio/Calle/Piso/Puerta");
		JTextField nombreDireccion = new JTextField("Nombre de direccion");
=======
		
		
		JTextField nombreDireccion = new JTextField("Nombre de direcci�n");
		JTextField codigoPostal = new JTextField("C�digo postal");
		JTextField calle = new JTextField("Calle");
		JTextField municipio = new JTextField("Municipio");
		JTextField portal = new JTextField("Portal");
		JTextField pisoPuerta = new JTextField("Piso-puerta");
		
		
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
		JLabel labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon("src/Imagenes/ubicacion.png"));
		
		
		panelA�adir.add(labelLogo);
		panelA�adir.add(nombreDireccion);
<<<<<<< HEAD
		panelA�adir.add(direccion);
=======
		panelA�adir.add(codigoPostal);
		panelA�adir.add(municipio);
		panelA�adir.add(calle);
		panelA�adir.add(portal);
		panelA�adir.add(pisoPuerta);
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
		panelA�adir.add(a�adir);
		
		
		panelArriba.add(panelA�adir);
		
		
		
		
		panelGeneral.add(panelArriba);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//PANEL ABAJO
		
		
		JSplitPane panelAbajo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelAbajo.setBorder(null);
		panelAbajo.setResizeWeight(0.90); 
		panelAbajo.setEnabled(false); 
		panelAbajo.setDividerSize(0); 
		
		//Panel direcciones (donde se van a a�adir las direcciones)
		JPanel panelDirecciones = new JPanel();
		JScrollPane scrollPanelDirecciones = new JScrollPane(panelDirecciones);
		panelAbajo.add(panelDirecciones);
		
<<<<<<< HEAD
		
=======
		JList<Direccion> listaDirecciones = new JList<Direccion>();
		DefaultListModel<Direccion> modeloListaDirecciones = new DefaultListModel<Direccion>();
		listaDirecciones.setModel(modeloListaDirecciones);
		panelDirecciones.add(listaDirecciones);
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
		
		JPanel panelAbajoBotones = new JPanel();
<<<<<<< HEAD
		JButton botonBorrarUbicacion =  new JButton("Borrar ubicacion");
		JButton botonBorrarTodasUbicaciones =  new JButton("Borrar todas");
		panelAbajoBotones.add(botonBorrarUbicacion);
		panelAbajoBotones.add(botonBorrarTodasUbicaciones);
=======
		JButton botonBorrarDireccion =  new JButton("Borrar direccion");
		JButton botonBorrarTodasDirecciones =  new JButton("Borrar todas");
		panelAbajoBotones.add(botonBorrarDireccion);
		panelAbajoBotones.add(botonBorrarTodasDirecciones);
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
		panelAbajo.add(panelAbajoBotones);
		
		panelGeneral.add(panelAbajo);
	
		
		
		
		
		
		add(panelGeneral);
		
		
		
		
		
		
		
		
		
		
		
		nombreDireccion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	nombreDireccion.setText("");
            }
        });
		municipio.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	municipio.setText("");
            }
        });
		calle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	calle.setText("");
            }
        });
		portal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	portal.setText("");
            }
        });
		pisoPuerta.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	pisoPuerta.setText("");
            }
        });
		
<<<<<<< HEAD
		
=======
		a�adir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Direccion nueva = new Direccion();
				nueva.setNombre(nombreDireccion.getText());
				nueva.setCodigoPostal(Integer.parseInt(codigoPostal.getText()));
				nueva.setMunicipio(municipio.getText());
				nueva.setCalle(calle.getText());
				nueva.setPortal(Integer.parseInt(portal.getText()));
				nueva.setPisoPuerta(pisoPuerta.getText());
				modeloListaDirecciones.addElement(nueva);
				
			}
		});
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
		
		botonBorrarTodasDirecciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modeloListaDirecciones.removeAllElements();
				//queda quitarlos de donde se guarden : bd o fichero
			}
		});
		
		botonBorrarDireccion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listaDirecciones.getSelectedValue() ==  null) {
					JOptionPane.showMessageDialog(null, "Selecciona una direccion");
				}else {
					Direccion direccion = (Direccion) listaDirecciones.getSelectedValue();
					modeloListaDirecciones.removeElement(direccion);
					//ELIMINARLA del ususario
				}
				
			}
		});
		
		botonBorrarTodasDirecciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(modeloListaDirecciones.isEmpty() ==  true) {
					JOptionPane.showMessageDialog(null, "No hay direcciones guardadas");
				}else {
				modeloListaDirecciones.clear();
				
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
