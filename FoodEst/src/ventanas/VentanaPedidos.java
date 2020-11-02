package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class VentanaPedidos extends JFrame{
	
	
	public VentanaPedidos() {
		
		
		JSplitPane panelGeneral = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		//panelGeneral.setBorder(null); //Sin bordes
		panelGeneral.setResizeWeight(0.02); //Parte de arriba del panel
		panelGeneral.setEnabled(false); //Que no se pueda mover
		panelGeneral.setDividerSize(0); //Sin espacio de division
		
		//PANEL TITULO
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new BorderLayout());
		
		JTextArea titulo = new JTextArea("Tus pedidos");
		titulo.setEditable(false);
		Font font = new Font("Gill Sans MT", Font.BOLD, 50);
		titulo.setFont(font);
		titulo.setOpaque(false);
		
		
		
		JButton atras = new JButton("Atras"); //Añadir logo de "atras"
		
		
		panelTitulo.add(atras, BorderLayout.WEST);
		panelTitulo.add(titulo, BorderLayout.CENTER);
		
		panelGeneral.add(panelTitulo);
		
		
		
		
		
		//PANEL ABAJO (A ESTE PANEL ES AL QUE HAY QUE AÑADIRLE LUEGO LOS PEDIDOS)
		JPanel panelMedio = new JPanel();
		
		JPanel panelPedidos = new JPanel(); //Añadir los nuevos pedidos a este
		panelPedidos.setBorder(LineBorder.createBlackLineBorder());
		JScrollPane scrollPanelAbajo = new JScrollPane(panelPedidos); 
		panelMedio.add(scrollPanelAbajo);
		panelGeneral.add(panelMedio);
		
		
		

		add(panelGeneral);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("FoodEst");
		setSize(1150, 505);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPedidos();
				
			}
		});

	}

}
