package ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class VentanaLogin extends JFrame {

	JButton boton = new JButton();
	JButton boton2 = new JButton();
	

	
	JPanel pnlCentral;
	JTextField usuario;
	JTextField contrase�a;
	JLabel mail;
	JLabel llave;
	JLabel recuperar;
	JLabel registrar;
	JLabel registrarRestaurante;
	JLabel titulo;
	JButton user;
	JButton restaurante;
	Scanner sc;
	ArrayList<String> usuarios = new ArrayList<>();
	
	public VentanaLogin() {
		
		setTitle("Login");
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
		usuario.setBounds(250, 180, 180, 40);
		pnlCentral.add(usuario);
		
		contrase�a = new JTextField();
		contrase�a.setBounds(250, 280, 180, 40);
		pnlCentral.add(contrase�a);
		
		//Labels
		
		llave = new JLabel();
		llave.setIcon(new ImageIcon("src/imagenes/key.png"));
		llave.setBounds(110, 170, 120, 60);
		pnlCentral.add(llave);
		
		mail = new JLabel();
		mail.setIcon(new ImageIcon("src/imagenes/mail.png"));
		mail.setBounds(130, 270, 120, 60);
		pnlCentral.add(mail);
		
		titulo = new JLabel();
		titulo.setText("Inicia sesi�n en Foodest");
		titulo.setBounds(50, 30, 450, 90);
		titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		pnlCentral.add(titulo);
		
		recuperar = new JLabel();
		recuperar.setText("Recuperar contrase�a");
		recuperar.setForeground(Color.blue);
		recuperar.setBounds(198, 330, 200, 90);
		recuperar.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(recuperar);
		
		
		registrar = new JLabel();
		registrar.setText("�No tienes cuenta de usuario? Registrate");
		registrar.setForeground(Color.blue);
		registrar.setBounds(175, 540, 250, 60);
		registrar.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(registrar);
		
		registrarRestaurante = new JLabel();
		registrarRestaurante.setText("Registrar restaurante");
		registrarRestaurante.setForeground(Color.green);
		registrarRestaurante.setBounds(175, 540, 250, 60);
		registrarRestaurante.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(registrarRestaurante);
		
		//Botones
		
		
		restaurante = new JButton();
		restaurante.setText("Restaurante");
		restaurante.setBackground(Color.white);
		restaurante.setFont(new Font("Arial", Font.PLAIN, 22));
		restaurante.setBounds(269, 430, 190, 90);
		pnlCentral.add(restaurante);
		
		user = new JButton();
		user.setText("Usuario");
		user.setBackground(Color.LIGHT_GRAY);
		user.setFont(new Font("Arial", Font.PLAIN, 22));
		user.setBounds(75, 430, 190, 90);
		pnlCentral.add(user);
	        
	    setVisible(true);
	    
	    
	    
	    JFrame thisFrame = this;
	    
	    registrar.addMouseListener(new MouseListener() {
			
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
				setVisible(false);
				new VentanaRegistro(thisFrame);
				
			}
		});
	    
	    
	    
	    registrarRestaurante.addMouseListener(new MouseListener() {
			
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
				new VentanaResgistrarRestaurante();
				
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

