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
		JLabel lcontraseña = new JLabel("Contraseña");
		JLabel lrepetirContraseña = new JLabel("Repetir contraseña");
		
		JTextField tnombreUsuario = new JTextField();
		JTextField tnombre = new JTextField();
		JTextField tapellido = new JTextField();
		JPasswordField tcontraseña = new JPasswordField();
		JPasswordField trepetirContraseña = new JPasswordField();
		
		JButton bRegistrar = new JButton("Registrar"); 
		JButton bCancelar = new JButton("Cancelar"); 

		add(lnombreUsuario);
		add(tnombreUsuario);
		
		add(lnombre);
		add(tnombre);

		add(lapellido);
		add(tapellido);
		
		add(lcontraseña);
		add(tcontraseña);
		
		add(lrepetirContraseña);
		add(trepetirContraseña);
		
		add(bRegistrar);
		add(bCancelar);
		
		
		setLayout(new GridLayout(6,2));
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
					db.connect("jdbc:sqlite:/C:\\Users\\guill\\git\\proyectoprog3\\FoodEst\\lib\\FoodEstDB" );
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
							String contraseña = String.valueOf(tcontraseña.getPassword());
							String confirmacionContraseña = String.valueOf(trepetirContraseña.getPassword());
							
							
							if (contraseña.equals(confirmacionContraseña)) { //Que la contraseña esté bien confirmada
								Usuario usuarioNuevo = new Usuario();
								usuarioNuevo.setNombreUsuario(tnombreUsuario.getText());
								usuarioNuevo.setNombre(tnombre.getText());
								usuarioNuevo.setApellido(tapellido.getText());
								usuarioNuevo.setContraseña(contraseña);
								
								db.insertarUsuario(usuarioNuevo); 
								JOptionPane.showMessageDialog(null, "Usuario registrado con exito");	
							}else { //Que no lo esté
								JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");					
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
	
}
