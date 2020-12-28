package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import clases.Usuario;


public class VentanaPerfil extends JFrame{
	
	JPanel pnlCentral;
	JLabel fPerfil;
	JTextField apellido;
	JPasswordField contrase�a;
	JTextField email;
	JLabel lapellido;
	JLabel lcontrase�a;
	JLabel lid;
	JLabel e;
	JLabel editar;
	JTextField id;
	JTextField tel;
	JTextField nombre;
	JButton guardar;
	JButton cerrar;
	JButton borrar;
	JButton volver;
	
	
	public VentanaPerfil(JFrame ventanaAnterior, Usuario usuario) {
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1150, 505);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		pnlCentral = new JPanel();
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		pnlCentral.setLayout(null);
		
		pnlCentral.setBackground(Color.WHITE);
		
		//Labels
		
		lapellido = new JLabel();
		lapellido.setText("Apellido");
		lapellido.setBounds(460, 100, 120, 120);
		lapellido.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(lapellido);
		
		lcontrase�a = new JLabel();
		lcontrase�a.setText("Contrase�a");
		lcontrase�a.setBounds(460, 150, 120, 120);
		lcontrase�a.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(lcontrase�a);
		
		lid = new JLabel();
		lid.setText("Id usuario");
		lid.setBounds(460, 200, 120, 120);
		lid.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(lid);
		
		e = new JLabel();
		e.setText("Email");
		e.setBounds(460, 250, 120, 120);
		e.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(e);
		
		fPerfil = new JLabel();
		fPerfil.setIcon(new ImageIcon("src/imagenes/userFoto.png"));
		fPerfil.setBounds(400, 0, 120, 120);
		pnlCentral.add(fPerfil);
		
		//Combobox
		apellido = new JTextField(usuario.getApellido());
		apellido.setBounds(580, 150, 102, 30);
		pnlCentral.add(apellido);
		
		contrase�a = new JPasswordField(usuario.getContrase�a());
		contrase�a.setBounds(580, 200, 102, 30);
		pnlCentral.add(contrase�a);
		
		email = new JTextField(usuario.getEmail());
		email.setBounds(580, 300, 180, 30);
		pnlCentral.add(email);
		
		//Textfields
		id = new JTextField();
		id.setEditable(false);
		id.setText(String.valueOf(usuario.getId()));
		id.setBounds(580, 250, 102, 30);
		pnlCentral.add(id);
		
		tel = new JTextField();
		tel.setText("@" + usuario.getNombreUsuario());
		tel.setBounds(580, 80, 180, 30);
		pnlCentral.add(tel);
		
		nombre = new JTextField();
		Font fuente = new Font("Dialog", Font.BOLD, 26);
		nombre.setFont(fuente);
		nombre.setText(usuario.getNombre());
		nombre.setBounds(580, 20, 240, 50);
		pnlCentral.add(nombre); 
		
		//Botones
		guardar = new JButton();
		guardar.setText("Guardar cambios");
		guardar.setBackground(Color.white);
		guardar.setFont(new Font("Arial", Font.PLAIN, 12));
		guardar.setBounds(498, 360, 140, 30);
		pnlCentral.add(guardar);
		
		cerrar = new JButton();
		cerrar.setText("Guardar cambios");
		cerrar.setBackground(Color.white);
		cerrar.setFont(new Font("Arial", Font.PLAIN, 12));
		cerrar.setBounds(498, 410, 140, 30);
		pnlCentral.add(cerrar);
		
		borrar = new JButton();
		borrar.setText("Borrar Cuenta");
		borrar.setBackground(Color.white);
		borrar.setFont(new Font("Arial", Font.PLAIN, 12));
		borrar.setBounds(950, 410, 140, 30);
		pnlCentral.add(borrar);
		
		volver = new JButton();
		volver.setText("Volver");
		volver.setBackground(Color.white);
		volver.setFont(new Font("Arial", Font.PLAIN, 12));
		volver.setBounds(40, 410, 140, 30);
		pnlCentral.add(volver);
		
		
		
		
		volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				dispose();
				
			}
		});
		
		
		
		setVisible(true);
	}
	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Usuario usuario = new Usuario();
				VentanaPerfil vp = new VentanaPerfil(usuario);
				
				
				
			}
		});
		
	}
	*/
	
}
