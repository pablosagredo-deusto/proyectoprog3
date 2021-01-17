package clases;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.*;

import clases.*;
import clases.Menu;
import ventanas.VentanaAdministracionRestaurante;
import ventanas.VentanaRestaurante;

public class Pruebas {
	public static void main(String[] args) {
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		ManagerDB db = new ManagerDB();
		try {
			db.connect();
			pedidos = db.getTodosPedidos();
			db.disconnect();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for (Pedido pedido : pedidos) {
	    	
	    		
				String stid = String.valueOf(pedido.getId());
				String stdireccion = pedido.getDireccion().toString();
				String stproductos = "";
				for (Producto producto : pedido.getProductos()) {
					stproductos = stproductos + producto.toString() + ",";
				}
				String stprecio = String.valueOf(pedido.getPreciototal());
				String stpago = pedido.getMetodopago();
				
				String stmenus = "";
				for (Menu menu : pedido.getMenus()) {
					stmenus = stmenus + menu.toString() + ",";
				}
				
				String stcubiertos = "";
				if (pedido.isCubiertos()) {
					stcubiertos = "SI";
				} else {
					stcubiertos = "NO";
				}
				
				System.out.println(stid);
				System.out.println(stdireccion);
				System.out.println(stproductos);
				System.out.println(stprecio);
				System.out.println(stpago);
				System.out.println(stmenus);
				System.out.println(stcubiertos);


			
		}
		
	}

}
