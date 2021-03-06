package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

import javax.swing.*;

import clases.ExceptionDB;
import clases.GeneradorContrasena;
import clases.ManagerDB;
import clases.Producto;
import clases.Restaurante;
import clases.Usuario;

public class VentanaLogin extends JFrame {

	public VentanaLogin() {

		// PanelArriba
		JPanel panelArriba = new JPanel();
		JLabel titulo = new JLabel("       INICIA SESION EN FOODEST");
		titulo.setFont(new Font("Cooper Black", Font.BOLD, 20));

		JRadioButton checkRestaurante = new JRadioButton("Restaurante");
		JRadioButton checkUsuario = new JRadioButton("Usuario");
		ButtonGroup group = new ButtonGroup(); // Para que solo uno de ellos este seleccionado
		group.add(checkRestaurante);
		group.add(checkUsuario);
		JPanel panelChecks = new JPanel();
		panelChecks.setLayout(new FlowLayout());
		panelChecks.add(checkRestaurante);
		panelChecks.add(checkUsuario);

		panelArriba.setLayout(new GridLayout(2, 1));
		panelArriba.add(titulo);
		panelArriba.add(panelChecks);

		// PanelMedio
		JPanel panelMedio = new JPanel();
		panelMedio.setLayout(new GridLayout(2, 1));

		// Para reducir los logos
		ImageIcon imagenUsuario = new ImageIcon("src/imagenes/userFoto.png");
		Image image = imagenUsuario.getImage();
		Image newImg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		imagenUsuario = new ImageIcon(newImg);
		JLabel logoUsuario = new JLabel();
		logoUsuario.setIcon(imagenUsuario);

		// Para reducir los logos
		ImageIcon imagenContrasena = new ImageIcon("src/imagenes/key.png");
		Image image2 = imagenContrasena.getImage();
		Image newImg2 = image2.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		imagenContrasena = new ImageIcon(newImg2);
		JLabel logoContrasena = new JLabel();
		logoContrasena.setIcon(imagenContrasena);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(logoUsuario, BorderLayout.WEST);
		JTextField tnombre = new JTextField("Nombre");
		panel1.add(tnombre, BorderLayout.CENTER);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(logoContrasena, BorderLayout.WEST);
		JPasswordField tcontrasena = new JPasswordField("Contrasena");
		tcontrasena.setEchoChar((char) 0);
		panel2.add(tcontrasena, BorderLayout.CENTER);

		panelMedio.add(panel1);
		panelMedio.add(panel2);

		// panelAbajo
		JPanel panelAbajo = new JPanel();

		JPanel panelAbajo1 = new JPanel();
		JButton bLogin = new JButton("Iniciar sesi�n");
		JButton bCerrar = new JButton("Cerrar FOODEST");
		

		panelAbajo1.add(bLogin);
		panelAbajo1.add(bCerrar);

		JPanel panelAbajo2 = new JPanel();
		panelAbajo2.setLayout(new GridLayout(2, 1));

		JLabel crearCuentaUsuario = new JLabel();
		crearCuentaUsuario.setText("    Crear cuenta de usuario");
		crearCuentaUsuario.setForeground(Color.blue);
		panelAbajo2.add(crearCuentaUsuario);

		JLabel crearCuentaRestaurante = new JLabel();
		crearCuentaRestaurante.setText("Crear cuenta de restaurante");
		crearCuentaRestaurante.setForeground(Color.blue);
		panelAbajo2.add(crearCuentaRestaurante);

		panelAbajo.add(panelAbajo1);
		panelAbajo.add(panelAbajo2);

		setLayout(new GridLayout(3, 1));
		add(panelArriba);
		add(panelMedio);
		add(panelAbajo);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(400, 500);
		setResizable(false);
		setVisible(true);

		// ACTIONLISTENERS

		tcontrasena.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tcontrasena.setEchoChar('*');
				tcontrasena.setText("");
			}
		});
		tnombre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tnombre.setText("");
			}
		});

		bCerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		

		checkRestaurante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tnombre.setText("Nombre del restaurante");

			}
		});

		checkUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tnombre.setText("Nombre del usario");

			}
		});
		JFrame thisFrame = this;
		crearCuentaUsuario.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new VentanaRegistro(thisFrame, 0);
				setVisible(false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		crearCuentaRestaurante.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new VentanaRegistro(thisFrame, 1);
				setVisible(false);

			}
		});

		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ManagerDB db = new ManagerDB();
				if (checkUsuario.isSelected()) { // INICIO SESION USUARIO
					List<Usuario> usuarios;
					try {
						db.connect();

						usuarios = db.getTodosUsuarios();
						List<Producto> productos = db.getTodosProductos();
						int numeroUsuarios = usuarios.size();
						int usuariosComprobados = 0;
						String nombreUsuarioRecibido = tnombre.getText();
						String contrasenaRecibido = String.valueOf(tcontrasena.getPassword());

						for (Usuario usuario : usuarios) {
							if (usuario.getNombreUsuario().equals(nombreUsuarioRecibido)
									&& usuario.getContrasena().equals(contrasenaRecibido)) {
								new VentanaPrincipal(usuario);
								dispose();
							} else {
								usuariosComprobados = usuariosComprobados + 1;
							}
						}

						if (usuariosComprobados == numeroUsuarios) { // si se han comprobado todos ---> avisamos
							JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario");
						}
						db.disconnect();
					} catch (ExceptionDB e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (checkRestaurante.isSelected()) { // INICIO SESION RESTAURANTE
					List<Restaurante> restaurantes;
					try {
						db.connect();

						restaurantes = db.getTodosRestaurantes();
						int numeroRestaurantes = restaurantes.size();
						int restaurantesComprobados = 0;
						String nombreRecibido = tnombre.getText();
						String contrasenaRecibido = String.valueOf(tcontrasena.getPassword());

						for (Restaurante restaurante : restaurantes) {
							if (restaurante.getNombre().equals(nombreRecibido)
									&& restaurante.getContrasena().equals(contrasenaRecibido)) {
								System.out.println("hola");
								
								new VentanaAdministracionRestaurante(restaurante);

								dispose();
							} else {
								restaurantesComprobados = restaurantesComprobados + 1;
							}
						}

						if (restaurantesComprobados == numeroRestaurantes) {
							JOptionPane.showMessageDialog(null, "No se ha encontrado el restaurante");
						}

						db.disconnect();
					} catch (ExceptionDB e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Seleccione restaurante o usuario para iniciar sesi�n");
				}

			}
		});

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {				
				new VentanaLogin();

			}
		});
	}
}
