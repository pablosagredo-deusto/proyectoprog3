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
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import clases.ExceptionDB;
import clases.ManagerDB;
import clases.Usuario;

public class VentanaLogin extends JFrame {
<<<<<<< HEAD

	JButton boton = new JButton();
	JButton boton2 = new JButton();
=======

>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
	
<<<<<<< HEAD

	
	JPanel pnlCentral;
	JTextField usuario;
	JTextField contraseña;
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
=======
>>>>>>> branch 'master' of https://github.com/pablosagredo-deusto/proyectoprog3
	
	public VentanaLogin() {
		
		//PanelArriba
		JPanel panelArriba = new JPanel();
		JLabel titulo = new JLabel("       INICIA SESION EN FOODEST");
		titulo.setFont(new Font("Cooper Black", Font.BOLD, 20));
		
		JRadioButton checkRestaurante = new JRadioButton("Restaurante");
		JRadioButton checkUsuario = new JRadioButton("Usuario");
		ButtonGroup group = new ButtonGroup(); //Para que solo uno de ellos este seleccionado
		group.add(checkRestaurante);
		group.add(checkUsuario);
	    JPanel panelChecks = new JPanel();
	    panelChecks.setLayout(new FlowLayout());
	    panelChecks.add(checkRestaurante);
	    panelChecks.add(checkUsuario);

	    panelArriba.setLayout(new GridLayout(2,1));
	    panelArriba.add(titulo);
	    panelArriba.add(panelChecks);
	    
	    //PanelMedio
	    JPanel panelMedio = new JPanel();
	    panelMedio.setLayout(new GridLayout(2,1));
	    
	    		//Para reducir los logos
	    ImageIcon imagenUsuario = new ImageIcon("src/imagenes/userFoto.png"); 
	    Image image = imagenUsuario.getImage(); 
	    Image newImg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); 
	    imagenUsuario = new ImageIcon(newImg);
	    JLabel logoUsuario = new JLabel();
	    logoUsuario.setIcon(imagenUsuario);
	    
	    
	    		//Para reducir los logos
	    ImageIcon imagenContraseña = new ImageIcon("src/imagenes/key.png"); 
	    Image image2 = imagenContraseña.getImage(); 
	    Image newImg2 = image2.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); 
	    imagenContraseña = new ImageIcon(newImg2);
	    JLabel logoContraseña = new JLabel();
	    logoContraseña.setIcon(imagenContraseña);
	    
	    
	    JPanel panel1 = new JPanel();
	    panel1.setLayout(new BorderLayout());
	    panel1.add(logoUsuario, BorderLayout.WEST);
	    JTextField tusuario = new JTextField("Nombre de usuario");
	    panel1.add(tusuario, BorderLayout.CENTER);
	    
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(new BorderLayout());
	    panel2.add(logoContraseña, BorderLayout.WEST);
	    JPasswordField tcontraseña = new JPasswordField("Introduce tu contraseña");
	    tcontraseña.setEchoChar((char) 0);
	    panel2.add(tcontraseña, BorderLayout.CENTER);
	    
	    panelMedio.add(panel1);
	    panelMedio.add(panel2);
	    
	    
	    
	    //panelAbajo 
	    JPanel panelAbajo = new JPanel();
	    
	    JPanel panelAbajo1 = new JPanel();
	    JButton bLogin = new JButton("Iniciar sesión");
	    JButton bCerrar = new JButton("Cerrar FOODEST");
	    
	    panelAbajo1.add(bLogin);
	    panelAbajo1.add(bCerrar);
	    
	    
	    
	    JPanel panelAbajo2 = new JPanel();
	    panelAbajo2.setLayout(new GridLayout(2,1));
	    
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
	    
	    
	    setLayout(new GridLayout(3,1));
	    add(panelArriba);
	    add(panelMedio);
	    add(panelAbajo);
	    
	    
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(400, 500);
		setResizable(false);
		setVisible(true);
		
		
		
		//ACTIONLISTENERS

		tcontraseña.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	tcontraseña.setEchoChar('*'); 
            	tcontraseña.setText("");
            }
        });
		tusuario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	tusuario.setText("");
            }
        });
		
		bCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		JFrame thisFrame = this;
		crearCuentaUsuario.addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new VentanaRegistro(thisFrame);
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
		
		
		bLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerDB db = new ManagerDB();
				if(checkUsuario.isSelected()) {
					List<Usuario> usuarios;
					try {
						db.connect();
						usuarios = db.getTodosUsuarios();
						
						String nombreRecibido = tusuario.getText();
						String contraseñaRecibido = String.valueOf(tcontraseña.getPassword());
						
						for (Usuario usuario : usuarios) {
							if (usuario.getNombre() == nombreRecibido && usuario.getContraseña() == contraseñaRecibido  ) {
								new VentanaPrincipal(usuario);
							}
						}
						db.disconnect();
					} catch (ExceptionDB e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else if (checkRestaurante.isSelected()) {
					//iniciar sesion en restaurantes
					JOptionPane.showMessageDialog(null, "Implementar inicio de sesion en restaurantes");
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione restaurante o usuario para iniciar sesión");		
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

