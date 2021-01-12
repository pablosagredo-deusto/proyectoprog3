package clases;

import java.awt.Image;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ventanas.VentanaFinal;

public class Hilo extends Thread {
	static int limite = 0;
	int min = 5;
	int max = 15;
	
	
	JLabel eti=new JLabel();


	public Hilo(JLabel flecha) {
		this.eti =flecha;
	}

	public void run() {
		try {
			limite = numeroRandom(5, 10);
			int x=0;
			System.out.println("Tiempo de pedido--> " + limite);
			
			while (VentanaFinal.iniciaHilo) {
				Thread.sleep(1000);
				if(x!=limite) {
					if(x==3) {
						ejecutarHilo(x);
					}
					System.out.println("x --> " + x);
					x++;			
				}else {
					VentanaFinal.iniciaHilo=false;
				}
			}

			// Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
		} catch (Exception e) {
			System.out.println("Error" + e);

		}
	}
	
	private void ejecutarHilo(int x) {
		System.out.println(x+ " --- "+Thread.currentThread().getName());
		
		eti.setVisible(false);
		
	}

	private static int numeroRandom(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
