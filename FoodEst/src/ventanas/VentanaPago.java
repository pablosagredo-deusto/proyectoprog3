package ventanas;

import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import java.io.File;

//problemas imports con libs externas
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import clases.EstadoPedido;
import clases.Pedido;
import clases.Producto;
import clases.TipoProducto;
import clases.Usuario;
import clases.Factura;
import clases.ManagerDB;

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
	Factura fact;

	String ruta = "src/lib/factura.txt";
	String contenido = "pruebaa";
	File file = new File(ruta);

	public VentanaPago(Pedido ped, Usuario us) {

		// para test de ventana
		List<Producto> productosBurgerKing = new ArrayList<Producto>();

		Pizza1 = new Producto();
		// a�adir datos con sets a este producto

		productosBurgerKing.add(Pizza1);

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

		p = new JLabel();
		p.setText("TOTAL A PAGAR \n" + ped.getPreciototal());
		p.setFont(new Font("Arial", Font.BOLD, 15));

		p1 = new JLabel();
		p1.setText("Seleccione su forma de pago --->");
		p1.setFont(new Font("Arial", Font.BOLD, 15));

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

		JRadioButton checkPdf = new JRadioButton(".pdf");
		ButtonGroup group = new ButtonGroup();
		group.add(checkPdf);

		pnlCentralIzq.setLayout(gridLayout2);
		pnlCentralIzq.add(p);
		pnlCentralIzq.add(checkPdf);
		pnlCentralIzq.add(factura);
		JButton finalizar = new JButton("PAGAR Y FINALIZAR");
		pnlCentralIzq.add(finalizar);

		pnlCentral.add(pnlCentralIzq);
		pnlCentral.add(efectivo);
		pnlCentral.add(tarjeta);
		add(pnlCentral);
		setVisible(true);

		efectivo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setVisible(false);
				ped.setMetodoPago("Efectivo");

			}
		});

		tarjeta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ped.setMetodoPago("Tarjeta");
				// VentanaFinal vent =new VentanaFinal(ped);

			}
		});
		finalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ManagerDB db = new ManagerDB();
				try {
					db.connect();
					db.insertarPedido(ped);
					db.disconnect();
				} catch (Exception e2) {
					// TODO: handle exception
				}

				new VentanaFinal(ped);
				dispose();

			}
		});

		factura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Factura fact = new Factura();
				if (checkPdf.isSelected()) {
					System.out.println("pdf");
					try {
						fact.crearFacturaPdf(ped);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un formato para su factura.");
				}

			}
		});

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Pedido pd = new Pedido();
				Usuario us = new Usuario();
				new VentanaPago(pd, us);

			}
		});
	}

}