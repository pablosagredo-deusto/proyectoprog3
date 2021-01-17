package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import clases.Usuario;

public class VentanaBorrarCuenta extends JFrame{
	
	
	public VentanaBorrarCuenta( ) {
		JLabel ltitulo = new JLabel("Borrar tu cuenta");
		JLabel lcontrasena = new JLabel("Itroduce tu contrasena");
		JTextField tcontrasena = new JTextField();
		JLabel lrepetirContrasena = new JLabel("Repite tu contrasena");
		JTextField trepetirContrasena = new JTextField();
		JButton bborrar = new JButton("Borrar cuenta");		
		JButton bcancelar = new JButton("Canelar");
		JLabel lopinion = new JLabel("Dinos en que podriamos mejorar:");
		JTextArea topinion  = new JTextArea();
		
		setLayout(new GridLayout(2,0));
		
		//PANEL ARRIBA
		JPanel panelArriba =  new JPanel();
		panelArriba.setLayout(new GridLayout(4, 0));
		panelArriba.add(ltitulo);
		panelArriba.add(new JPanel());
		JPanel panelContrasena =  new JPanel();
		panelContrasena.setLayout(new GridLayout(0, 2));
		panelContrasena.add(lcontrasena);
		panelContrasena.add(tcontrasena);
		panelArriba.add(panelContrasena);
		JPanel panelRepetirContrasena =  new JPanel();
		panelRepetirContrasena.setLayout(new GridLayout(0, 2));
		panelRepetirContrasena.add(lrepetirContrasena);
		panelRepetirContrasena.add(trepetirContrasena);
		panelArriba.add(panelRepetirContrasena);
		
		//PANEL ABAJO
		
		JSplitPane panelAbajo = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		panelAbajo.setBorder(null);
		panelAbajo.setResizeWeight(0.85);
		panelAbajo.setEnabled(false);
		panelAbajo.setDividerSize(0);
		
		TitledBorder border = new TitledBorder("Dinos en que podemos mejorar:");
	    border.setTitleJustification(TitledBorder.CENTER);
	    border.setTitlePosition(TitledBorder.TOP);
	 
	    JPanel panelOpinion = new JPanel();
	    panelOpinion.setBorder(border);
	    
		panelOpinion.add(topinion);
		panelAbajo.add(panelOpinion);
		
		
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(bcancelar);
		panelBotones.add(bborrar);
		panelAbajo.add(panelBotones);
		
		
		
		
		
		
		add(panelArriba);
		add(panelAbajo);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Borrar cuenta");
		setSize(400, 500);
		setVisible(true);
		
		
		
		bcancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		bborrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnValue = 0;
		    	returnValue = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrar tu cuenta de FoodEst?", "Borrar cuenta", JOptionPane.YES_NO_OPTION);
		    		
		    	if (returnValue == JOptionPane.YES_OPTION) {
		    		//BORRAR CUENTA DE LA BASE DE DATOS
		    	} else if (returnValue == JOptionPane.NO_OPTION) {
		    		
		    	}
		    			
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaBorrarCuenta();
				
				
			}
		});

	}
	

}
