package foodEst;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	
	public VentanaPrincipal() {
		
		
		JPanel panelAbajo =  new JPanel();
		JButton supermercado =  new JButton("Supermercados");
		JButton enviosExpres =  new JButton("Envios expres");
		JButton tiendas =  new JButton("Tiendas");
		JButton comida =  new JButton("Comida");
		JButton donacion =  new JButton("Donacion");
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout());
		
		panelAbajo.setLayout(new GridLayout(2,1));

				
	}
}
