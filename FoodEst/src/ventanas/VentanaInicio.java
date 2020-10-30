package ventanas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame {
	
	
	public VentanaInicio() {
		JPanel panelMenu = new JPanel();
		JLabel nombrerestaurante=new JLabel("");
		JLabel tag=new JLabel();
		JButton añadir1 = new JButton("Añadir1");
		JButton añadir2 = new JButton("Añadir2");
		JButton añadir3 = new JButton("Añadir2");
		JButton pedir = new JButton("Añadir3");
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout());

		panelMenu.setLayout(new GridLayout(4,3));

		
	}
	
	public static void main(String[] args) {
		
		JPanel panelAbajo = new JPanel();
		
	}
}
