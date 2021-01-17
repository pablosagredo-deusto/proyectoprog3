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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Hilo;
import clases.Pedido;
import clases.Usuario;

public class VentanaFinal extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel pnlCentral;
	public static JPanel pnlCentralDerecha;
	JPanel pnlCentralIzquierda;
	public static JPanel pnlCentralIzquierda2;

	JLabel flecha;
	JLabel flecha1;
	JLabel flecha2;
	JLabel flecha3;
	public static JLabel gracias;
	JButton botonIniciar;
	JButton botonAcabar;
	ImageIcon imagenFlechaVerde;
	Image image3;
	Image newImg3;
	public static boolean iniciaHilo = true;
	public static boolean iniciaVentana = true;
	public static Usuario user;

	boolean corriendo = false;

	public VentanaFinal(Pedido ped) {

		user = ped.getUsuario();
		GridLayout gridLayout1 = new GridLayout();

		gridLayout1.setRows(1);
		gridLayout1.setColumns(3);

		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1150, 505);
		setBackground(Color.WHITE);

		pnlCentral = new JPanel();
		pnlCentralDerecha = new JPanel();
		pnlCentralIzquierda = new JPanel();
		pnlCentralIzquierda2 = new JPanel();

		JLabel recibido = new JLabel();
		recibido.setText("   " + "RECIBIDO");
		recibido.setFont(new Font("Arial", Font.BOLD, 15));
		recibido.setVisible(false);

		JLabel preparando = new JLabel();
		preparando.setText("PREPARANDO");
		preparando.setFont(new Font("Arial", Font.BOLD, 15));
		preparando.setVisible(false);

		JLabel enviado = new JLabel();
		enviado.setText("ENVIADO");
		enviado.setFont(new Font("Arial", Font.BOLD, 15));
		enviado.setVisible(false);

		JLabel encamino = new JLabel();
		encamino.setText("EN CAMINO");
		encamino.setFont(new Font("Arial", Font.BOLD, 15));
		encamino.setVisible(false);

		JLabel entregado = new JLabel();
		entregado.setText("ENTREGADO");
		entregado.setFont(new Font("Arial", Font.BOLD, 15));
		entregado.setVisible(false);

		JLabel flecha = new JLabel();
		flecha.setVisible(false);
		JLabel flecha1 = new JLabel();
		flecha1.setVisible(false);
		JLabel flecha2 = new JLabel();
		flecha2.setVisible(false);
		JLabel flecha3 = new JLabel();
		flecha3.setVisible(false);
		JLabel mapa1 = new JLabel();

		JLabel gracias = new JLabel();

		ImageIcon imagenFlecha = new ImageIcon("src/imagenes/flechaverde.png");
		Image image2 = imagenFlecha.getImage();
		Image newImg2 = image2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		imagenFlecha = new ImageIcon(newImg2);

		flecha.setIcon(imagenFlecha);
		flecha1.setIcon(imagenFlecha);
		flecha2.setIcon(imagenFlecha);
		flecha3.setIcon(imagenFlecha);

		// imahen mapa
		ImageIcon imagenMapa = new ImageIcon("src/imagenes/mapa1.png");
		Image image4 = imagenMapa.getImage();
		Image newImg4 = image4.getScaledInstance(500, 400, java.awt.Image.SCALE_SMOOTH);
		imagenMapa = new ImageIcon(newImg4);
		mapa1.setIcon(imagenMapa);


		// imahen gracias
		ImageIcon imagenGracias = new ImageIcon("src/imagenes/gracias.png");
		Image image5 = imagenGracias.getImage();
		Image newImg5 = image5.getScaledInstance(500, 400, java.awt.Image.SCALE_SMOOTH);
		imagenGracias = new ImageIcon(newImg5);

		gracias.setIcon(imagenGracias);
		gracias.setVisible(false);
		// 5 estados del pedido

		// a�adir panels
		pnlCentral.setLayout(gridLayout1);

		pnlCentral.add(pnlCentralIzquierda);
		pnlCentral.add(pnlCentralDerecha);
		pnlCentral.add(pnlCentralIzquierda2);

		botonIniciar = new JButton("Comenzar pedido");
		botonIniciar.addActionListener(this);
		botonAcabar = new JButton("Cancelar pedido");
		botonAcabar.addActionListener(this);

		// panelizquierdo2
		pnlCentralIzquierda2.setBackground(Color.WHITE);
		pnlCentralIzquierda2.add(gracias);

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

		pnlCentralDerecha.add(recibido);// 0
		pnlCentralDerecha.add(flecha);// 1
		pnlCentralDerecha.add(preparando);// 2
		pnlCentralDerecha.add(flecha1);// 3
		pnlCentralDerecha.add(enviado);// 4
		pnlCentralDerecha.add(flecha2);// 5
		pnlCentralDerecha.add(encamino);// 6
		pnlCentralDerecha.add(flecha3);// 7
		pnlCentralDerecha.add(entregado);// 8

		// anadir central
		add(pnlCentral);
		if (iniciaVentana)
			setVisible(true);
		else
			setVisible(false);

	}

	public static void main(String[] args) {
		VentanaFinal vent = new VentanaFinal(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonIniciar) {
			if (corriendo == false) {
				iniciaHilo = true;
				corriendo = true;
				JOptionPane.showMessageDialog(null, "PEDIDO COMENZADO");
				iniciarHilo();
			}

		}
		if (e.getSource() == botonAcabar) {
			corriendo = false;
			iniciaHilo = false;

		}

	}

	// para usar el thread
	public void iniciarHilo() {
		if (iniciaHilo == true) {
			Hilo miHilo = new Hilo();
			miHilo.start();
		}

	}

}
