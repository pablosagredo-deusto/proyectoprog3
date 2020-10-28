package ventanas;

import java.awt.*;

import javax.swing.*;

public class VentanaLogin extends JFrame {

	public VentanaLogin() {

		JPanel panelAbajo = new JPanel();
		JButton supermercado = new JButton("Supermercados");
		JButton enviosExpres = new JButton("Envios expres");
		JButton tiendas = new JButton("Tiendas");
		JButton comida = new JButton("Comida");
		JButton donacion = new JButton("Donacion");
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout());

		panelAbajo.setLayout(new GridLayout(2, 1));

	}

	public static void main(String[] args) {

	}
}
