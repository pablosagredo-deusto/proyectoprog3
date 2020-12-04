package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import clases.Usuario;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal(Usuario usuario) {
		
		
		
		JButton telepizza =  new JButton("Telepizza");
		JButton goikoGrill =  new JButton("Goiko-grill");
		JButton kfc =  new JButton("KFC");
		JButton deustoBurger =  new JButton("Deusto-Burguer");
		JButton pizzaHut =  new JButton("Pizza-Hut");
		JTextField buscador = new JTextField("¿Qué estas buscando?");
		JButton buscar =  new JButton("Buscar");
		
		
		//PANEL ARRIBA
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(1,3));
		
		JPanel panelArribaMedio = new JPanel();
		panelArribaMedio.setLayout(new GridLayout(2,1));
		JPanel panelLogo = new JPanel();
		JLabel labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon("src/imagenes/logo.png"));
		panelLogo.add(labelLogo);

		panelArribaMedio.add(panelLogo);
		JPanel panelArribaMedioAbajo =  new JPanel();
		panelArribaMedioAbajo.setLayout(new GridLayout(2,1));
		panelArribaMedioAbajo.add(buscador);
		
		JPanel panelBotonBuscar = new JPanel();
		panelBotonBuscar.setLayout(new GridLayout(1,3));
		panelBotonBuscar.add(new JPanel());
		panelBotonBuscar.add(buscar);
		panelBotonBuscar.add(new JPanel());
		panelArribaMedioAbajo.add(panelBotonBuscar);
		panelArribaMedio.add(panelArribaMedioAbajo);
		
		JPanel panelArribaIzquierda = new JPanel();
		panelArribaIzquierda.setLayout(new GridLayout(1, 3));
		JPanel panelArribaIzquierda1 = new JPanel();
		JMenuBar barra = new JMenuBar();
		JMenu menuDireccion = new JMenu("Direccion");
		JMenuItem misDirecciones =  new JMenuItem("Mis direcciones");
		menuDireccion.add(misDirecciones);
		JMenu menuPerfil = new JMenu("Perfil");
		JMenuItem verPerfil =  new JMenuItem("Mi perfil");
		JMenuItem otrasOpcionesPerfil =  new JMenuItem("Otras opciones");
		menuPerfil.add(verPerfil);
		menuPerfil.add(otrasOpcionesPerfil);
		barra.add(menuDireccion);
		barra.add(menuPerfil);
		panelArribaIzquierda1.add(barra);
		panelArribaIzquierda.add(panelArribaIzquierda1);
		panelArribaIzquierda.add(new JPanel());
		panelArribaIzquierda.add(new JPanel());
		
		
		JPanel panelArribaDerecha = new JPanel();
		panelArribaDerecha.setLayout(new GridLayout(1, 3));
		
		
		JButton tresBarras = new JButton(new ImageIcon("src/imagenes/tresBarras.png"));
		JPanel panelArribaDerecha3 = new JPanel();
		panelArribaDerecha3.setLayout(new GridLayout(3,1));
		
		panelArribaDerecha3.add(tresBarras);
		panelArribaDerecha3.add(new JPanel());
		panelArribaDerecha3.add(new JPanel());
		
		
		
		
		
		panelArribaDerecha.add(new JPanel());
		panelArribaDerecha.add(new JPanel());
		panelArribaDerecha.add(panelArribaDerecha3);
		
		panelArriba.add(panelArribaIzquierda);
		panelArriba.add(panelArribaMedio);
		panelArriba.add(panelArribaDerecha);
		
		
		
		
		
		//PANEL ABAJO
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,9));
		panelBotones.add(telepizza);
		panelBotones.add(new JPanel());
		panelBotones.add(goikoGrill);
		panelBotones.add(new JPanel());
		panelBotones.add(kfc);
		panelBotones.add(new JPanel());
		panelBotones.add(deustoBurger);
		panelBotones.add(new JPanel());
		panelBotones.add(pizzaHut);
		
		
		JPanel panelAbajo =  new JPanel();
		panelAbajo.setLayout(new GridLayout(2,1));
		panelAbajo.add(panelBotones);
		panelAbajo.add(new JPanel());
		
		
		setLayout(new GridLayout(2,1));
		add(panelArriba);
		add(panelAbajo);
		
		
		
		
		
		
		
		buscador.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	buscador.setText("");
            }
        });
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(1150, 505);
		setVisible(true);
		
		JFrame thisFrame = this;
		
		//Action listeners para los botones
		
		ActionListener actionBotones = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				new VentanaRestaurante(thisFrame);
				setVisible(false);
			}
		
		};
		
		
		telepizza.addActionListener(actionBotones);
		goikoGrill.addActionListener(actionBotones);
		kfc.addActionListener(actionBotones);
		deustoBurger.addActionListener(actionBotones);
		pizzaHut.addActionListener(actionBotones);
		
		
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String busqueda = buscar.getText();
				new VentanaBuscador(thisFrame ,busqueda);
				setVisible(false);
			}
		});
		verPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaPerfil(thisFrame, usuario); //Recibira un usuario
				setVisible(false);
			}
		});
		
		
		misDirecciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaDirecciones(thisFrame, usuario); //Esta ventana recibira un usuario
				setVisible(false);
			}
		});
				
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Usuario usuario = new Usuario(); //Este ususario es para probar la ventana
				new VentanaPrincipal(usuario);
				
				
			}
		});

	}
}

