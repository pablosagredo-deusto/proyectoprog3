package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;


public class VentanaPago extends JFrame{
	JPanel pnlCentral;
	JLabel p;

	public VentanaPago() {
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1150, 505);
		
		
		
	
		pnlCentral = new JPanel();
		
		pnlCentral.setLayout(new GridLayout(4,4));
		
		pnlCentral.setBackground(Color.WHITE);
		
		p = new JLabel();
		p.setText("PAGO");
		p.setFont(new Font("Arial", Font.BOLD, 15)); 
		
		
		pnlCentral.add(p);
		add(pnlCentral);
		setVisible(true);

		
	}
	
	public static void main(String[] args) {
		VentanaPago vpago=new VentanaPago();
	}
	

}
