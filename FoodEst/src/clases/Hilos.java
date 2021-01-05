package clases;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import ventanas.VentanaFinal;

public class Hilos extends Thread {
	static int contador = 0;

	public static void main(String[] args) {
		int velocidad = 2;

		Timer timer;
		TimerTask tarea;

		int velmil = velocidad * 1000;
		VentanaFinal vent = new VentanaFinal(null);
		vent.setVisible(true);

		tarea = new TimerTask() {

			@Override
			public void run() {
				
				switch(contador) {
				case 0:
					contador=1;
					ImageIcon imagenFlechaVerde = new ImageIcon("src/imagenes/cc.png");
					Image image3 = imagenFlechaVerde.getImage();
					Image newImg3 = image3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
					imagenFlechaVerde = new ImageIcon(newImg3);
					
					vent.getFlecha().setIcon(imagenFlechaVerde);
					
					
					break;
				case 1:
					contador=2;
					
					
					break;
				case 2:
					contador=3;
					
					
					break;
				case 3:
					contador=4;
					
					
					break;
				case 4:
					contador=5;
					
					
					break;
				}
				

			}
		};
		
		timer=new Timer();
		
		timer.scheduleAtFixedRate(tarea, velmil, velmil);

}

}
