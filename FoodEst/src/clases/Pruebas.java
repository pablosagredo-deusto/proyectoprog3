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
import ventanas.VentanaAdministracionRestaurante;
import ventanas.VentanaRestaurante;

public class Pruebas {
	public static void main(String[] args) {
		
		
		Menu menu = new  Menu();
		menu.setNombre("menuPruba4");
		Producto pr1 = new Producto();
		pr1.setNombre("pr114");
		Producto pr2 = new Producto();
		pr2.setNombre("pr224");
	
		
		
		
		
		ManagerDB db = new ManagerDB();
		
		try {
			
			db.connect();
			List<Menu> todosMenus = db.getTodosMenus();	
			

			Menu menuBuscado = null;
			for (Menu menu2 : todosMenus) {
				if (menu2.getNombre().equals("menuPruba4")) {
					menuBuscado = menu2;

				}
			}
			db.disconnect();
			
			
			for (Producto producto : menuBuscado.getProductos()) {
				System.out.println(producto.getNombre());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
