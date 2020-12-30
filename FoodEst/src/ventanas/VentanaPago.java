package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import clases.EstadoPedido;
import clases.Pedido;
import clases.Producto;
import clases.Restaurante;
import clases.TipoProducto;

public class VentanaPago extends JFrame {
	JPanel pnlCentral;
	JPanel pnlCentralIzq;
	JPanel pnlCentralDer;
	JPanel pnlCentralCent;
	JLabel p;
	JLabel p1;
	JButton efectivo;
	JButton tarjeta;
	JButton factura;
	ImageIcon imagenEfectivo;
	Image image2;
	Image newImg2;

	ImageIcon imagenTarjeta;
	Image image3;
	Image newImg3;
	
	Producto Pizza1;

	public VentanaPago(Pedido ped) {
		
		
		//para test de ventana
		List<Producto> productosBurgerKing = new ArrayList<Producto>();
		Pizza1 = new Producto("Piza", 001, 15.5, "pizza", null, false, TipoProducto.PIZZA, null);
		productosBurgerKing.add(Pizza1);
		Pedido ped2= new Pedido(1, null, null, EstadoPedido.RECIBIDO, productosBurgerKing, 12, "", false);
		
		

		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(1150, 505);

		pnlCentral = new JPanel();

		pnlCentralIzq = new JPanel();
		pnlCentralDer = new JPanel();
		pnlCentralCent = new JPanel();

		GridLayout gridLayout1 = new GridLayout();

		gridLayout1.setRows(1);
		gridLayout1.setHgap(30);
		gridLayout1.setVgap(30);
		gridLayout1.setColumns(3);

		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.setRows(3);
		gridLayout2.setHgap(30);
		gridLayout2.setColumns(1);

		pnlCentral.setLayout(gridLayout1);

		pnlCentral.setBackground(Color.WHITE);

		
		double precio=ped.getPreciototal();
		String cadena="";
		for (Producto producto : ped.getProductos()) {
			cadena="\n"+producto.toStringPrecio();			
		}
		p = new JLabel();
		p.setText("TOTAL A PAGAR\n"+"  "+"---"+" "+ cadena);
		p.setFont(new Font("Arial", Font.BOLD, 15));

		p1 = new JLabel();
		p1.setText("Seleccione su forma de pago --->");
		p1.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel p2 = new JLabel();
		p2.setText("Generar factura en txt");
		p2.setFont(new Font("Arial", Font.BOLD, 15));

		efectivo = new JButton();
		efectivo.setText("EFECTIVO \n");
		efectivo.setFont(new Font("Arial", Font.BOLD, 15));

		ImageIcon imagenEfectivo = new ImageIcon("src/imagenes/cash.png");
		Image image2 = imagenEfectivo.getImage();
		Image newImg2 = image2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		imagenEfectivo = new ImageIcon(newImg2);
		efectivo.setIcon(imagenEfectivo);

		tarjeta = new JButton();
		tarjeta.setText("TARJETA");
		tarjeta.setFont(new Font("Arial", Font.BOLD, 15));

		ImageIcon imagenTarjeta = new ImageIcon("src/imagenes/cc.png");
		Image image3 = imagenTarjeta.getImage();
		Image newImg3 = image3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		imagenTarjeta = new ImageIcon(newImg3);
		tarjeta.setIcon(imagenTarjeta);
		
		
		factura = new JButton();
		factura.setFont(new Font("Arial", Font.BOLD, 15));

		ImageIcon imagenFactura = new ImageIcon("src/imagenes/factura.png");
		Image image4 = imagenFactura.getImage();
		Image newImg4 = image4.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		imagenFactura = new ImageIcon(newImg4);
		factura.setIcon(imagenFactura);
		
		
		JRadioButton checkTxt= new JRadioButton(".txt");
		JRadioButton checkXml = new JRadioButton(".xml");
		ButtonGroup group = new ButtonGroup(); 
		group.add(checkTxt);
		group.add(checkXml);

		pnlCentralIzq.setLayout(gridLayout2);
		pnlCentralIzq.add(p);
		pnlCentralIzq.add(p2);
		pnlCentralIzq.add(checkTxt);
		pnlCentralIzq.add(checkXml);
		pnlCentralIzq.add(factura);


		pnlCentral.add(pnlCentralIzq);
		pnlCentral.add(efectivo);
		pnlCentral.add(tarjeta);
		add(pnlCentral);
		setVisible(true);

		efectivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				ped.setMetodoPago("Efectivo");
				for (Producto producto : ped.getProductos()) {
					producto.toStringPrecio();
				}
				

			}
		});

		tarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ped.setMetodoPago("Tarjeta");

			}
		});

	}

	public static void main(String[] args) {
		VentanaPago vpago = new VentanaPago(null);
	}

}
