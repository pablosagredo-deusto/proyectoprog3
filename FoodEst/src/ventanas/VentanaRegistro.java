package ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame{
	
	JPanel pnlCentral;
	JTextField correo;
	JTextField usuario;
	JTextField contraseña;
	JButton restaurante;
	JButton user;
	JLabel mail;
	JLabel llave;
	JLabel titulo;
	JLabel userIcon;
	
	public VentanaRegistro() {
		
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(550, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		pnlCentral = new JPanel();
		getContentPane().add(pnlCentral, BorderLayout.CENTER);
		pnlCentral.setLayout(null);
		pnlCentral.setBackground(Color.white);
		
		
		
		//Textfields
		
		usuario = new JTextField();
		usuario.setBounds(250, 190, 180, 40);
		pnlCentral.add(usuario);
				
		contraseña = new JTextField();
		contraseña.setBounds(250, 290, 180, 40);
		pnlCentral.add(contraseña);
		
		correo = new JTextField();
		correo.setBounds(250, 390, 180, 40);
		pnlCentral.add(correo);
		
		//Botones
		
		restaurante = new JButton();
		restaurante.setText("Restaurante");
		restaurante.setBackground(Color.white);
		restaurante.setFont(new Font("Arial", Font.PLAIN, 22));
		restaurante.setBounds(269, 490, 190, 90);
		pnlCentral.add(restaurante);
		
		user = new JButton();
		user.setText("Usuario");
		user.setBackground(Color.LIGHT_GRAY);
		user.setFont(new Font("Arial", Font.PLAIN, 22));
		user.setBounds(75, 490, 190, 90);
		pnlCentral.add(user);
		
		//Labels
		
		llave = new JLabel();
		llave.setIcon(new ImageIcon("src/imagenes/key.png"));
		llave.setBounds(110, 270, 120, 60);
		pnlCentral.add(llave);
				
		mail = new JLabel();
		mail.setIcon(new ImageIcon("src/imagenes/mail.png"));
		mail.setBounds(130, 370, 120, 60);
		pnlCentral.add(mail);	
		
		userIcon = new JLabel();
		userIcon.setIcon(new ImageIcon("src/imagenes/user.png"));
		userIcon.setBounds(130, 170, 120, 70);
		pnlCentral.add(userIcon);	
		
		titulo = new JLabel();
		titulo.setText("Registrate en Foodest");
		titulo.setBounds(130, 30, 450, 90);
		titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		pnlCentral.add(titulo);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		VentanaRegistro reg = new VentanaRegistro();
	}
}
