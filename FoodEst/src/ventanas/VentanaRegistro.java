package ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import clases.ExceptionDB;
import clases.GeneradorContrasena;
import clases.ManagerDB;
import clases.Restaurante;
import clases.Usuario;



//-----PESTAÑA REGISTRO USUARIO--------
class VentanaRegistroUsuario extends JPanel{
	

	public VentanaRegistroUsuario(JFrame ventanaAnterior, JFrame ventanaActual){


		
		JLabel lnombreUsuario = new JLabel("Nombre de usuario");
		JLabel lnombre = new JLabel("Nombre");
		JLabel lapellido = new JLabel("Apellido");
		JLabel lemail = new JLabel("Email");
		JLabel lcontrasena = new JLabel("Contrasena");
		JLabel lrepetirContrasena = new JLabel("Repetir contrasena");
		JLabel ltitulo1 = new JLabel("      Registrate");
		JLabel ltitulo2 = new JLabel("en Foodest");
		ltitulo1.setFont(new Font("Cooper Black", Font.BOLD, 25));
		ltitulo2.setFont(new Font("Cooper Black", Font.BOLD, 25));
		
		JTextField tnombreUsuario = new JTextField();
		JTextField tnombre = new JTextField();
		JTextField tapellido = new JTextField();
		JTextField temail = new JTextField();
		JPasswordField tcontrasena = new JPasswordField();
		JPasswordField trepetirContrasena = new JPasswordField();
		
		
		JButton bRegistrar = new JButton("Registrar"); 
		JButton bCancelar = new JButton("Cancelar"); 
		JButton bContrasena = new JButton("Generar Contrasena");

		 
		
		add(ltitulo1);
		add(ltitulo2);
		
		add(lnombreUsuario);
		add(tnombreUsuario);
		
		add(lnombre);
		add(tnombre);

		add(lapellido);
		add(tapellido);
		
		add(lemail);
		add(temail);
		
		add(lcontrasena);
		add(tcontrasena);
		
		add(lrepetirContrasena);
		add(trepetirContrasena);
		
		
		add(bRegistrar);
		add(bCancelar);

		add(new JPanel());
		add(bContrasena);
		
		
		
		setSize(400, 500);
		setLayout(new GridLayout(9,2));
		
		
		
		bCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
				
			}
		});

		bContrasena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GeneradorContrasena g=new GeneradorContrasena();
				System.out.println("pulsado");
				Random rand = new Random();
				int largo=10;
				
				String password=g.generarContrasenha(rand, "", 0, largo);
				JOptionPane.showMessageDialog(null, "Contraseña generada -- "+password);

				tcontraseña.setText(password);
				trepetirContraseña.setText(password);
				
				

			}
		});
		
		bRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerDB db = new ManagerDB();
				
				try {
					db.connect();
					List<Usuario> usuariosExistentes = db.getTodosUsuarios();
					int numeroUsuarios = usuariosExistentes.size();
					int usuariosComprobados = 0;
					for (Usuario usuario : usuariosExistentes) { 
						String nombre = usuario.getNombreUsuario();
						if(nombre.equals(tnombreUsuario.getText())) {// YA ESXISTE ESE NOMBRE DE USUARIO
							JOptionPane.showMessageDialog(null, "Nombre de usuario existente, elige otro");
						}else{ 
							usuariosComprobados = usuariosComprobados + 1;
						}
					}		
							
					if(usuariosComprobados == numeroUsuarios) {
						//NO EXISTE ---> LO REGISTRAMOS
						String contrasena = String.valueOf(tcontrasena.getPassword());
						String confirmacionContrasena = String.valueOf(trepetirContrasena.getPassword());
							
							
						if (contrasena.equals(confirmacionContrasena)) { //Que la contrasena esté bien confirmada
							Usuario usuarioNuevo = new Usuario();
							usuarioNuevo.setNombreUsuario(tnombreUsuario.getText());
							usuarioNuevo.setNombre(tnombre.getText());
							usuarioNuevo.setApellido(tapellido.getText());
							usuarioNuevo.setContrasena(contrasena); //la hemos guardado en un string arriba
							usuarioNuevo.setEmail(temail.getText());
								
							db.insertarUsuario(usuarioNuevo); 
							JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");	
						}else { //Que no lo esté
							JOptionPane.showMessageDialog(null, "Las contrasenas no coinciden");					
						}
					}
						
					
					db.disconnect();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
				}
		});
	}
}

class VentanRegistroRestaurante extends JPanel{
	
	public VentanRegistroRestaurante(JFrame ventanaAnterior, JFrame ventanaActual) {
		setSize(400, 500);
		setLayout(new GridLayout(7,2));
		 
		JLabel ltitulo1 = new JLabel("    Registra tu");
		JLabel ltitulo2 = new JLabel("restaurante");
		ltitulo1.setFont(new Font("Cooper Black", Font.BOLD, 25));
		ltitulo2.setFont(new Font("Cooper Black", Font.BOLD, 25));


		
		JButton bregistrar = new JButton("Resgistrar");
		JButton bcancelar = new JButton("Cancelar");

		JLabel lnombreRestaurante = new JLabel("Nombre de restaurante:");
		JTextField tnombreRestaurante = new JTextField();
		
		JLabel lcategoriaRestaurante = new JLabel("Categoria de restaurante:");
		JTextField tcategoriaRestaurante = new JTextField();
		
		JLabel lcontrasenaRestaurante = new JLabel("Contrasena:");
		JPasswordField tcontrasenaRestaurante = new JPasswordField();
		
		JLabel lrepetirContrasena = new JLabel("Repetir contrasena:");
		JPasswordField trepetirContrasenaRestaurante = new JPasswordField();
		
		JLabel ldireccion = new JLabel("Direccion:");
		JTextField tdireccion = new JPasswordField();
		
		
		
		
		add(ltitulo1);
		add(ltitulo2);
		
		add(lnombreRestaurante);
		add(tnombreRestaurante);
		
		add(lcategoriaRestaurante);
		add(tcategoriaRestaurante);
		
		add(lcontrasenaRestaurante);
		add(tcontrasenaRestaurante);
		
		add(lrepetirContrasena);
		add(trepetirContrasenaRestaurante);
		
		add(ldireccion);
		add(tdireccion);
		
		add(bregistrar);
		add(bcancelar);

		
		
		
		bcancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
				
			}
		});
		
		
		bregistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerDB db = new ManagerDB();
				
				try {
					db.connect();
					List<Restaurante> restaurantesExistentes = db.getTodosRestaurantes();
					int numeroRestaurantes = restaurantesExistentes.size();
					int restaurantesComprobados = 0;
					for (Restaurante restaurante : restaurantesExistentes) {
						String nombre = restaurante.getNombre();
						if(nombre.equals(tnombreRestaurante.getText())) {// YA ESXISTE ESE NOMBRE DE RESTAURANTE
							JOptionPane.showMessageDialog(null, "Restaurante ya registrado");
							break;
						}else {
							restaurantesComprobados = restaurantesComprobados +1;
						}
					}
					
					if(restaurantesComprobados == numeroRestaurantes ) { //si se han comprobado todos los restaurantes y no coincide ninguno (es decir, no esta)
						String contrasena = String.valueOf(tcontrasenaRestaurante.getPassword());
						String confirmacionContrasena = String.valueOf(trepetirContrasenaRestaurante.getPassword());
						
						
						if (contrasena.equals(confirmacionContrasena)) { //Que la contrasena esté bien confirmada
							Restaurante restauranteNuevo = new Restaurante();
							restauranteNuevo.setNombre(tnombreRestaurante.getText());
							restauranteNuevo.setCategoria(tcategoriaRestaurante.getText());
							restauranteNuevo.setContrasena(contrasena); //ya la hemos guardado en un string arriba
							restauranteNuevo.setDireccion(tdireccion.getText());
							restauranteNuevo.setEnviogratis(false); //esto luego se podra cambiar en ventanAdministracion
							
							
							db.insertarRestaurante(restauranteNuevo);
							
							JOptionPane.showMessageDialog(null, "Restaurante registrado con �xito");	
						}else { //Que no lo est�n
							JOptionPane.showMessageDialog(null, "Las contrasenas no coinciden");					
						}
					}
					
					
					db.disconnect();
				} catch (ExceptionDB e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		
		
		
		
		
		
		
		
		
	}
}



public class VentanaRegistro extends JFrame{
	
	public VentanaRegistro(JFrame ventanaAnterior, int indiceVentanaPorDefecto) {
		JTabbedPane panelPestanas = new JTabbedPane(); //contenedor de pestanas
		
		
		JFrame ventanaActual = this;
		panelPestanas.add("Registro Usuario", new VentanaRegistroUsuario(ventanaAnterior, ventanaActual));
		panelPestanas.add("Registro Restaurante", new VentanRegistroRestaurante(ventanaAnterior, ventanaActual));
		
		
		panelPestanas.setSelectedIndex(indiceVentanaPorDefecto);
		
		
		
		add(panelPestanas);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(400, 500);
		setResizable(false);
		setVisible(true);
	}
	
}
