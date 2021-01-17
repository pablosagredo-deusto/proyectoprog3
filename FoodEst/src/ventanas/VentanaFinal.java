package ventanas;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Hilo;
import clases.Pedido;

public class VentanaFinal extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlCentral;
	JPanel pnlCentralDerecha;
	JPanel pnlCentralIzquierda;
	private JLabel flecha;
	JLabel flecha1;
	JLabel flecha2;
	JLabel flecha3;
	JButton botonIniciar;
	JButton botonAcabar;
	ImageIcon imagenFlechaVerde;
	Image image3;
	Image newImg3;
	public static boolean iniciaHilo = true;
	boolean corriendo= false;


	public VentanaFinal(Pedido ped) {

		GridLayout gridLayout1 = new GridLayout();

		gridLayout1.setRows(1);
		gridLayout1.setColumns(2);

		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1150, 505);
		setBackground(Color.WHITE);

		pnlCentral = new JPanel();
		pnlCentralDerecha = new JPanel();
		pnlCentralIzquierda = new JPanel();
		// 5 estados del pedido

		JLabel recibido = new JLabel();
		recibido.setText("   " + "RECIBIDO");
		recibido.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel preparando = new JLabel();
		preparando.setText("PREPARANDO");
		preparando.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel enviado = new JLabel();
		enviado.setText("ENVIADO");
		enviado.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel encamino = new JLabel();
		encamino.setText("EN CAMINO");
		encamino.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel entregado = new JLabel();
		entregado.setText("ENTREGADO");
		entregado.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel flecha = new JLabel();
		JLabel flecha1 = new JLabel();
		JLabel flecha2 = new JLabel();
		JLabel flecha3 = new JLabel();
		JLabel mapa1 = new JLabel();
		

		ImageIcon imagenFlecha = new ImageIcon("src/imagenes/flecha.png");
		Image image2 = imagenFlecha.getImage();
		Image newImg2 = image2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		imagenFlecha = new ImageIcon(newImg2);

		ImageIcon imagenFlechaVerde = new ImageIcon("src/imagenes/flechaverde.png");
		Image image3 = imagenFlechaVerde.getImage();
		Image newImg3 = image3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		imagenFlechaVerde = new ImageIcon(newImg3);

		flecha.setIcon(imagenFlecha);
		flecha1.setIcon(imagenFlechaVerde);
		flecha2.setIcon(imagenFlecha);
		flecha3.setIcon(imagenFlecha);

		ImageIcon imagenMapa = new ImageIcon("src/imagenes/mapa1.png");
		Image image4 = imagenMapa.getImage();
		Image newImg4 = image4.getScaledInstance(500, 400, java.awt.Image.SCALE_SMOOTH);
		imagenMapa = new ImageIcon(newImg4);

		mapa1.setIcon(imagenMapa);

		// a�adir panels
		pnlCentral.setLayout(gridLayout1);
		pnlCentral.add(pnlCentralIzquierda);
		pnlCentral.add(pnlCentralDerecha);

		
		botonIniciar = new JButton("Comenzar pedido");
		botonIniciar.addActionListener(this);
		botonAcabar = new JButton("Cancelar pedido");
		botonAcabar.addActionListener(this);

		// panelizquierdo
		pnlCentralIzquierda.setBackground(Color.WHITE);
		pnlCentralIzquierda.add(mapa1);
		pnlCentralIzquierda.add(botonIniciar);
		pnlCentralIzquierda.add(botonAcabar);

		// panelderecho
		// a�adir labels
		BoxLayout b = new BoxLayout(pnlCentralDerecha, BoxLayout.Y_AXIS);
		pnlCentralDerecha.setLayout(b);
		pnlCentralDerecha.setBackground(Color.WHITE);
		pnlCentralDerecha.add(recibido);
		pnlCentralDerecha.add(flecha);

		pnlCentralDerecha.add(preparando);
		pnlCentralDerecha.add(flecha1);
		pnlCentralDerecha.add(enviado);
		pnlCentralDerecha.add(flecha2);
		pnlCentralDerecha.add(encamino);
		pnlCentralDerecha.add(flecha3);
		pnlCentralDerecha.add(entregado);
		// botones
		

		// a�adir central
		add(pnlCentral);
		setVisible(true);

	}

	public static void main(String[] args) {
		VentanaFinal vent = new VentanaFinal(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonIniciar) {
			System.out.println("iniciar pulsado");
			if(corriendo==false) {
				iniciaHilo=true;
				corriendo=true;
				iniciarHilo();
			}
			
		}
		if(e.getSource()==botonAcabar) {
			System.out.println("acabar pulsado");
			corriendo=false;
			iniciaHilo=false;
			
		}
		
	}
	
	
	//para usar el thread
	public void iniciarHilo() {
		if (iniciaHilo == true) {
			System.out.println("Empieza el hilo");
			Hilo miHilo = new Hilo(flecha);
			miHilo.start();
		}

	}

	public JLabel getFlecha() {
		return flecha;
	}

}