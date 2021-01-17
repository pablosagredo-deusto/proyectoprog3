package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import clases.Usuario;

public class VentanaBorrarCuenta extends JFrame{
	
	
	public VentanaBorrarCuenta( ) {
		JLabel ltitulo = new JLabel("Borrar tu cuenta");
		JLabel lcontraseña = new JLabel("Itroduce tu contraseña");
		JTextField tcontraseña = new JTextField();
		JLabel lrepetirContraseña = new JLabel("Repite tu contraseña");
		JTextField trepetirContraseña = new JTextField();
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
		JPanel panelContraseña =  new JPanel();
		panelContraseña.setLayout(new GridLayout(0, 2));
		panelContraseña.add(lcontraseña);
		panelContraseña.add(tcontraseña);
		panelArriba.add(panelContraseña);
		JPanel panelRepetirContraseña =  new JPanel();
		panelRepetirContraseña.setLayout(new GridLayout(0, 2));
		panelRepetirContraseña.add(lrepetirContraseña);
		panelRepetirContraseña.add(trepetirContraseña);
		panelArriba.add(panelRepetirContraseña);
		
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
