package ventanas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import clases.Usuario;
import sun.jvm.hotspot.types.JBooleanField;

public class VentanaAdministracionRestaurante extends JFrame{
	
	public VentanaAdministracionRestaurante() {
		//PANEL DERECHA
		JPanel panelDerecha = new JPanel();
		
		
		
		
		//PANEL IZQUIERDA
		JPanel panelIzquierda = new JPanel();
		
		
		JLabel titulo = new JLabel("ADMINISTRACION");
		titulo.setFont(new Font("Cooper Black", Font.BOLD, 40));
		
		JPanel panelPedidos = new JPanel();
		TitledBorder border = new TitledBorder("Pedidos recibidos");
	    border.setTitleJustification(TitledBorder.CENTER);
	    border.setTitlePosition(TitledBorder.TOP);
	    panelPedidos.setBorder(border);
	    
	    JPanel panelBotonesAbajo = new JPanel();
	    JButton botonMarcarTodosPedidos  = new JButton("Marcar todos los pedidos como recibidos");
	    panelBotonesAbajo.add(botonMarcarTodosPedidos);
	    
	    
	    panelIzquierda.setLayout(new BorderLayout());
	    panelIzquierda.add(titulo, BorderLayout.NORTH);
	    panelIzquierda.add(panelPedidos, BorderLayout.CENTER);
	    panelIzquierda.add(panelBotonesAbajo, BorderLayout.CENTER);
		
	    
	    
	    
	    
	    
	    
	    
		add(panelIzquierda);
		add(panelDerecha);
		
		
		setLayout(new GridLayout(1,2));
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(1150, 505);
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				new VentanaAdministracionRestaurante();
				
				
			}
		});

	}

}
