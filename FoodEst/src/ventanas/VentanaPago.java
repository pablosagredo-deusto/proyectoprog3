package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import clases.Articulo;
import clases.Pedido;


public class VentanaPago extends JFrame{
	JPanel pnlCentral;
	JLabel p;
	JLabel cambiar;
	JButton prueba;

	public VentanaPago(Pedido pedidoActual) {
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1150, 505);
		
		
		
	
		pnlCentral = new JPanel();
		
		pnlCentral.setLayout(new BoxLayout(pnlCentral, BoxLayout.Y_AXIS));
		
		pnlCentral.setBackground(Color.WHITE);
		
		p = new JLabel();
		p.setText("PRECIO");
		p.setFont(new Font("Arial", Font.BOLD, 15)); 
		
		cambiar = new JLabel();
		cambiar.setText("RESTAURANTE");
		cambiar.setFont(new Font("Arial", Font.BOLD, 15)); 
		
		prueba= new JButton("PULSAME");
		float precioFinal=0;
		for (Articulo a : pedidoActual.getArticulos()) {
			precioFinal=precioFinal+a.getPrecio();
			
			
		}
		String s = Float.toString(precioFinal);
		System.out.println(""+precioFinal);
		
		prueba.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cambiar.setText(pedidoActual.getRestaurante());
				p.setText(s);

			}
		});
		
		pnlCentral.add(cambiar);
		pnlCentral.add(p);
		pnlCentral.add(prueba);
		
		
		add(pnlCentral);
		setVisible(true);

		
	}
	
	public static void main(String[] args) {
		VentanaPago vpago=new VentanaPago(null);
	}
	

}
