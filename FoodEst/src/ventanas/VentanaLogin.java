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
import java.util.List;

import javax.swing.*;

import clases.ExceptionDB;
import clases.ManagerDB;
import clases.Restaurante;
import clases.Usuario;

public class VentanaLogin extends JFrame {

	
	
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
	    JTextField tnombre = new JTextField("Nombre");
	    panel1.add(tnombre, BorderLayout.CENTER);
	    
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(new BorderLayout());
	    panel2.add(logoContraseña, BorderLayout.WEST);
	    JPasswordField tcontraseña = new JPasswordField("Contraseña");
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
				if(checkUsuario.isSelected()) { //INICIO SESION USUARIO
					List<Usuario> usuarios;
					try {
						db.connect();
						
						usuarios = db.getTodosUsuarios();
						String nombreRecibido = tnombre.getText();
						String contraseñaRecibido = String.valueOf(tcontraseña.getPassword());
						
						for (Usuario usuario : usuarios) {
							if (usuario.getNombre().equals(nombreRecibido) && usuario.getContraseña().equals(contraseñaRecibido)) {
								new VentanaPrincipal(usuario);
								dispose();
							}
						}
						db.disconnect();
					} catch (ExceptionDB e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else if (checkRestaurante.isSelected()) { //INICIO SESION RESTAURANTE
					List<Restaurante> restaurantes;
					try {
						db.connect();
						
						restaurantes = db.getTodosRestaurantes();
						String nombreRecibido = tnombre.getText();
						String contraseñaRecibido = String.valueOf(tcontraseña.getPassword());
						
						for (Restaurante restaurante : restaurantes) {
							if (restaurante.getNombre().equals(nombreRecibido) && restaurante.getContraseña().equals(contraseñaRecibido)) {
								new VentanaAdministracionRestaurante(restaurante);
								dispose();
							}
						}
						db.disconnect();
					} catch (ExceptionDB e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
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
				System.out.println("prueba");
				new VentanaLogin();
				
			}
		});
	}
}

