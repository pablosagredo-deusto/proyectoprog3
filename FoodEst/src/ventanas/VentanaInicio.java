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
		JButton a�adir1 = new JButton("A�adir1");
		JButton a�adir2 = new JButton("A�adir2");
		JButton a�adir3 = new JButton("A�adir2");
		JButton pedir = new JButton("A�adir3");
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout());

		panelMenu.setLayout(new GridLayout(4,3));

		
	}
	
	public static void main(String[] args) {
		
		JPanel panelAbajo = new JPanel();
		
	}
}
