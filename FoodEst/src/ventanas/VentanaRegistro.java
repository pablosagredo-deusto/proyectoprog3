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
import clases.Usuario;

public class VentanaRegistro extends JFrame{
	

	public VentanaRegistro(JFrame ventanaAnterior){


		
		JLabel lnombreUsuario = new JLabel("Nombre de usuario");
		JLabel lnombre = new JLabel("Nombre");
		JLabel lapellido = new JLabel("Apellido");
		JLabel lemail = new JLabel("Email");
		JLabel lcontrase�a = new JLabel("Contrase�a");
		JLabel lrepetirContrase�a = new JLabel("Repetir contrase�a");
		
		JTextField tnombreUsuario = new JTextField();
		JTextField tnombre = new JTextField();
		JTextField tapellido = new JTextField();
		JTextField temail = new JTextField();
		JPasswordField tcontrase�a = new JPasswordField();
		JPasswordField trepetirContrase�a = new JPasswordField();
		
		JButton bRegistrar = new JButton("Registrar"); 
		JButton bCancelar = new JButton("Cancelar"); 

		add(lnombreUsuario);
		add(tnombreUsuario);
		
		add(lnombre);
		add(tnombre);

		add(lapellido);
		add(tapellido);
		
		add(lemail);
		add(temail);
		
		add(lcontrase�a);
		add(tcontrase�a);
		
		add(lrepetirContrase�a);
		add(trepetirContrase�a);
		
		add(bRegistrar);
		add(bCancelar);
		
		
		setLayout(new GridLayout(7,2));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(400, 500);
		setResizable(false);
		setVisible(true);
		
		
		bCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventanaAnterior.setVisible(true);
				
			}
		});
		
		bRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerDB db = new ManagerDB();
				try {
					db.connect();
				} catch (ExceptionDB e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					List<Usuario> usuariosExistentes = db.getTodosUsuarios();
					for (Usuario usuario : usuariosExistentes) { 
						String nombre = usuario.getNombreUsuario();
						if(nombre.equals(tnombreUsuario.getText())) {// YA ESXISTE ESE NOMBRE DE USUARIO
							JOptionPane.showMessageDialog(null, "Nombre de usuario existente, elige otro");
						}else{ //NO EXISTE ---> LO REGISTRAMOS
							String contrase�a = String.valueOf(tcontrase�a.getPassword());
							String confirmacionContrase�a = String.valueOf(trepetirContrase�a.getPassword());
							
							
							if (contrase�a.equals(confirmacionContrase�a)) { //Que la contrase�a est� bien confirmada
								Usuario usuarioNuevo = new Usuario();
								usuarioNuevo.setNombreUsuario(tnombreUsuario.getText());
								usuarioNuevo.setNombre(tnombre.getText());
								usuarioNuevo.setApellido(tapellido.getText());
								usuarioNuevo.setContrase�a(contrase�a); //la hemos guardado en un string arriba
								usuarioNuevo.setEmail(temail.getText());
								
								db.insertarUsuario(usuarioNuevo); 
								JOptionPane.showMessageDialog(null, "Usuario registrado con exito");	
							}else { //Que no lo est�
								JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden");					
							}
						}	
					}	
					db.disconnect();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaRegistro();
				
			}
		});
	}
	
}
