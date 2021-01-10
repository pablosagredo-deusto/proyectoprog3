package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Paisaje extends JPanel implements Runnable{
	public Paisaje(){
		//Se carga la imagen
		paisajes = ( new ImageIcon( "src/imagenes/flecha.png" ) ).getImage();
		//Se asigna la posicion en x dentro del JPanel
		posicion_x = 0;
		//Se asigna la posicion en y dentro del JPanel
		posicion_y = 20;
		//Se asigna el valor de los segundos
		segundos =  5;
		//se asigna el valor del frame
		frame = 0;
	}
	
	//---------- Metodo implementado de Runnable que controla el cambio de imagen ----------//
	public void run(){
		while( true ){
			try{
				//Actualiza el pintado del JPanel
				repaint();
				//Se espera 1 segundo
				Thread.sleep(1000);
				if( segundos > 0 ){
					segundos--;
				}
				else{
					//Ya habiendo transcurrido los 5 segundos cambia  de imagen
					segundos = 5;
					//Si va en la imagen 4 regresa a la 1 
					if( frame < 4 ){
						frame++;
					}
					else{ 
						frame = 0; 
					}
				}
				//Actualiza el pintado del JPanel
				repaint();
			}catch( Exception e ){ e.printStackTrace(); }
		}
	}
	//--------------------------------------------------------------------------------------//
	
	//-------------------- Se utiliza para pintar la imagen en el JPanel -------------------//
	public void paint( Graphics g ){
		//Pinta con azul un rectangulo
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 301, 20);
		//Escribe un texto de color blanco
		g.setColor(Color.WHITE);
		g.drawString(segundos+"", 145, 15);
		
		//Segun el frame calcula en la posicion en donde se encuentra dentro de la imagen
		int frameX = ( frame % 2 ) * ancho;
		int frameY = ( frame / 2) * alto;
		
		//Dibuja el frame especificado en la posicion indicada
		g.drawImage(paisajes, posicion_x, posicion_y, posicion_x + ancho, posicion_y + alto, 
				frameX, frameY, frameX + ancho, frameY + alto, this);
	}
	//--------------------------------------------------------------------------------------//
	
	//Posicion en x, dentro del JPanel
	int posicion_x;
	//Posicion en y, dentro del JPanel
	int posicion_y;
	//Ancho de los frames, no de la imagen en general
	int ancho = 301;
	//Alto de los frames, no de la imagen en general
	int alto = 301;
	//Frame que hay en las imagenes (en este caso 4)
	int frame;
	//Segundos en que aparece cada imagen
	int segundos;
	//Imagen a cargar de 603x603
	Image paisajes;
	
	
	public static void main(String[] args) {
		Paisaje p = new Paisaje();
		System.out.println("ss");
		p.run();
		
	}
}
