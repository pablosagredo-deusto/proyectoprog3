package clases;

import java.awt.Dialog;
import java.awt.Image;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ventanas.VentanaFinal;
import ventanas.VentanaPrincipal;

public class Hilo extends Thread {
	static int limite = 0;
	int min = 5;
	int max = 15;

	JLabel eti = new JLabel();
	JOptionPane pane = new JOptionPane();

	public Hilo() {
	}

	public void run() {
		try {
			limite = numeroRandom(16, 18);
			int x = 0;
			System.out.println("Tiempo de pedido--> " + limite);

			while (VentanaFinal.iniciaHilo) {
				Thread.sleep(1000);
				if (x != limite) {
					ejecutarHilo(x);
					System.out.println("x --> " + x);
					x++;
				} else {
					VentanaFinal.iniciaHilo = false;
					Usuario usuario;
					usuario = VentanaFinal.user;
					new VentanaPrincipal(usuario);
					VentanaFinal.iniciaVentana = false;

				}
			}

			// Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		} catch (Exception e) {
			System.out.println("Error" + e);

		}
	}

	private void ejecutarHilo(int x) {
		System.out.println(x + " --- ");
		switch (x) {
		case 3:

			VentanaFinal.pnlCentralDerecha.getComponent(0).setVisible(true);
			VentanaFinal.pnlCentralDerecha.getComponent(1).setVisible(true);
			System.out.println("cuenta.. " + VentanaFinal.pnlCentralDerecha.getComponentCount());

			break;
		case 8:

			VentanaFinal.pnlCentralDerecha.getComponent(2).setVisible(true);
			VentanaFinal.pnlCentralDerecha.getComponent(3).setVisible(true);

			break;
		case 10:

			VentanaFinal.pnlCentralDerecha.getComponent(4).setVisible(true);
			VentanaFinal.pnlCentralDerecha.getComponent(5).setVisible(true);
			break;
		case 12:

			VentanaFinal.pnlCentralDerecha.getComponent(6).setVisible(true);
			VentanaFinal.pnlCentralDerecha.getComponent(7).setVisible(true);
			

			break;

		case 13:
			VentanaFinal.pnlCentralDerecha.getComponent(8).setVisible(true);
			pane.showMessageDialog(null, "ENTREGADO", "Actualizacion del pedido", JOptionPane.WARNING_MESSAGE);


			break;
		case 15:
			VentanaFinal.pnlCentralDerecha.getComponent(8).setVisible(true);
			VentanaFinal.pnlCentralIzquierda2.getComponent(0).setVisible(true);

			pane.showMessageDialog(null, "ENTREGADO", "Actualizacion del pedido", JOptionPane.WARNING_MESSAGE);


			break;
		}

	}

	private static int numeroRandom(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
