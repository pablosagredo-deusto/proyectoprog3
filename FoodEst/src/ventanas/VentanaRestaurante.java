package ventanas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Restaurante;

public class VentanaRestaurante extends JFrame {

	public VentanaRestaurante() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(680, 580);
		setVisible(true);
		setTitle("Inicio");
		setLayout(new GridLayout(3, 4));

		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(Color.green);
		panelIzq.setLayout(new GridLayout());
		
		
		JPanel panelMed = new JPanel();
		panelMed.setBackground(Color.red);
		panelMed.setLayout(new GridLayout());
		JPanel panelDer = new JPanel();
		panelDer.setBackground(Color.black);
		panelDer.setLayout(new GridLayout());

		add(panelDer);
		add(panelMed);
		add(panelIzq);

	}

	public static void main(String[] args) {

		new VentanaRestaurante();

	}

}
