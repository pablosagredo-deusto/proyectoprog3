package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;


public class VentanaPerfil extends JFrame{
	
	JPanel pnlCentral;
	JLabel fPerfil;
	JComboBox<String> pais;
	JComboBox<String> idioma;
	JComboBox<String> codInv;
	JLabel p;
	JLabel i;
	JLabel in;
	JLabel e;
	JLabel editar;
	JTextField email;
	JTextField tel;
	JTextField nom;
	JButton guardar;
	JButton cerrar;
	JButton borrar;
	
	
	public VentanaPerfil() {
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
		
		p = new JLabel();
		p.setText("País");
		p.setBounds(460, 100, 120, 120);
		p.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(p);
		
		i = new JLabel();
		i.setText("Idioma");
		i.setBounds(460, 150, 120, 120);
		i.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(i);
		
		in = new JLabel();
		in.setText("Invitación");
		in.setBounds(460, 200, 120, 120);
		in.setFont(new Font("Arial", Font.PLAIN, 15)); 
		pnlCentral.add(in);
		
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
		pais = new JComboBox<>();
		pais.addItem("España");
		pais.setBounds(580, 150, 102, 30);
		pnlCentral.add(pais);
		
		idioma = new JComboBox<>();
		idioma.addItem("Español");
		idioma.addItem("English");
		idioma.setBounds(580, 200, 102, 30);
		pnlCentral.add(idioma);
		
		codInv = new JComboBox<>();
		codInv.addItem("");
		codInv.setBounds(580, 250, 102, 30);
		pnlCentral.add(codInv);
		
		//Textfields
		email = new JTextField();
		email.setText("ejemplo@gmail.com");
		email.setBounds(580, 300, 180, 30);
		pnlCentral.add(email);
		
		tel = new JTextField();
		tel.setText("Número de Teléfono");
		tel.setBounds(580, 80, 180, 30);
		pnlCentral.add(tel);
		
		nom = new JTextField();
		Font fuente = new Font("Dialog", Font.BOLD, 26);
		nom.setFont(fuente);
		nom.setText("Nombre Apellido");
		nom.setBounds(580, 20, 240, 50);
		pnlCentral.add(nom); 
		
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
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		VentanaPerfil vp = new VentanaPerfil();
	}
}
