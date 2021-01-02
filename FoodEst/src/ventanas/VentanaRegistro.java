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


import clases.ExceptionDB;
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
		JLabel lcontraseña = new JLabel("Contraseña");
		JLabel lrepetirContraseña = new JLabel("Repetir contraseña");
		JLabel ltitulo1 = new JLabel("      Registrate");
		JLabel ltitulo2 = new JLabel("en Foodest");
		ltitulo1.setFont(new Font("Cooper Black", Font.BOLD, 25));
		ltitulo2.setFont(new Font("Cooper Black", Font.BOLD, 25));
		
		JTextField tnombreUsuario = new JTextField();
		JTextField tnombre = new JTextField();
		JTextField tapellido = new JTextField();
		JTextField temail = new JTextField();
		JPasswordField tcontraseña = new JPasswordField();
		JPasswordField trepetirContraseña = new JPasswordField();
		
		JButton bRegistrar = new JButton("Registrar"); 
		JButton bCancelar = new JButton("Cancelar"); 

		 
		
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
		
		add(lcontraseña);
		add(tcontraseña);
		
		add(lrepetirContraseña);
		add(trepetirContraseña);
		
		add(bRegistrar);
		add(bCancelar);
		
		
		
		setSize(400, 500);
		setLayout(new GridLayout(8,2));
		
		
		
		bCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaActual.dispose();
				ventanaAnterior.setVisible(true);
				
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
						String contraseña = String.valueOf(tcontraseña.getPassword());
						String confirmacionContraseña = String.valueOf(trepetirContraseña.getPassword());
							
							
						if (contraseña.equals(confirmacionContraseña)) { //Que la contraseña esté bien confirmada
							Usuario usuarioNuevo = new Usuario();
							usuarioNuevo.setNombreUsuario(tnombreUsuario.getText());
							usuarioNuevo.setNombre(tnombre.getText());
							usuarioNuevo.setApellido(tapellido.getText());
							usuarioNuevo.setContraseña(contraseña); //la hemos guardado en un string arriba
							usuarioNuevo.setEmail(temail.getText());
								
							db.insertarUsuario(usuarioNuevo); 
							JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");	
						}else { //Que no lo esté
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");					
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
		
		JLabel lcontraseñaRestaurante = new JLabel("Contraseña:");
		JPasswordField tcontraseñaRestaurante = new JPasswordField();
		
		JLabel lrepetirContraseña = new JLabel("Repetir contraseña:");
		JPasswordField trepetirContraseñaRestaurante = new JPasswordField();
		
		JLabel ldireccion = new JLabel("Direccion:");
		JTextField tdireccion = new JPasswordField();
		
		
		add(ltitulo1);
		add(ltitulo2);
		
		add(lnombreRestaurante);
		add(tnombreRestaurante);
		
		add(lcategoriaRestaurante);
		add(tcategoriaRestaurante);
		
		add(lcontraseñaRestaurante);
		add(tcontraseñaRestaurante);
		
		add(lrepetirContraseña);
		add(trepetirContraseñaRestaurante);
		
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
						String contraseña = String.valueOf(tcontraseñaRestaurante.getPassword());
						String confirmacionContraseña = String.valueOf(trepetirContraseñaRestaurante.getPassword());
						
						
						if (contraseña.equals(confirmacionContraseña)) { //Que la contraseña esté bien confirmada
							Restaurante restauranteNuevo = new Restaurante();
							restauranteNuevo.setNombre(tnombreRestaurante.getText());
							restauranteNuevo.setCategoria(tcategoriaRestaurante.getText());
							restauranteNuevo.setContraseña(contraseña); //ya la hemos guardado en un string arriba
							restauranteNuevo.setDireccion(tdireccion.getText());
							restauranteNuevo.setEnviogratis(false); //esto luego se podra cambiar en ventanAdministracion
							
							
							db.insertarRestaurante(restauranteNuevo);
							
							JOptionPane.showMessageDialog(null, "Restaurante registrado con éxito");	
						}else { //Que no lo estén
							JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");					
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
		JTabbedPane panelPestañas = new JTabbedPane(); //contenedor de pestañas
		
		
		JFrame ventanaActual = this;
		panelPestañas.add("Registro Usuario", new VentanaRegistroUsuario(ventanaAnterior, ventanaActual));
		panelPestañas.add("Registro Restaurante", new VentanRegistroRestaurante(ventanaAnterior, ventanaActual));
		
		
		panelPestañas.setSelectedIndex(indiceVentanaPorDefecto);
		
		
		
		add(panelPestañas);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(400, 500);
		setResizable(false);
		setVisible(true);
	}
	
}
