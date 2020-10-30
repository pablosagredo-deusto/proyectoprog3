package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal() {
		
		
		
		JButton supermercado =  new JButton("Supermercados");
		JButton enviosExpres =  new JButton("Envios expres");
		JButton tiendas =  new JButton("Tiendas");
		JButton comida =  new JButton("Comida");
		JButton donacion =  new JButton("Donación");
		JTextField buscador = new JTextField("¿Qué estas buscando?");
		JButton buscar =  new JButton("Buscar");
		
		
		//PANEL ARRIBA
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(new GridLayout(1,3));
		
		JPanel panelArribaMedio = new JPanel();
		panelArribaMedio.setLayout(new GridLayout(2,1));
		JPanel panelLogo = new JPanel();
		JLabel labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon("src/Imagenes/logo.png"));
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
		JMenu menuUbicacion = new JMenu("Ubicacion");
		JMenu menuPerfil = new JMenu("Perfil");
		barra.add(menuUbicacion);
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
		panelBotones.add(supermercado);
		panelBotones.add(new JPanel());
		panelBotones.add(enviosExpres);
		panelBotones.add(new JPanel());
		panelBotones.add(tiendas);
		panelBotones.add(new JPanel());
		panelBotones.add(comida);
		panelBotones.add(new JPanel());
		panelBotones.add(donacion);
		
		
		JPanel panelAbajo =  new JPanel();
		panelAbajo.setLayout(new GridLayout(2,1));
		panelAbajo.add(panelBotones);
		panelAbajo.add(new JPanel());
		
		
		setLayout(new GridLayout(2,1));
		add(panelArriba);
		add(panelAbajo);
		
		
		
		
		
		
		
		/*
		buscador.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent e) {
		        JTextField fuente = (JTextField)e.getComponent();
		        fuente.setText("");
		        fuente.removeFocusListener(this);
		    }
		});
		getContentPane().requestFocusInWindow();
		*/
		supermercado.requestFocusInWindow();
    
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(1150, 505);
		setVisible(true);

				
	}
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal();
				
			}
		});

	}
}

