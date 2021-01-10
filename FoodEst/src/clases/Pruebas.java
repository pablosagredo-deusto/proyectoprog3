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

import javax.imageio.ImageIO;
import javax.swing.*;

import clases.*;
import ventanas.VentanaAdministracionRestaurante;
import ventanas.VentanaRestaurante;

public class Pruebas {
	public static void main(String[] args) {
		ManagerDB db =  new ManagerDB();
		List<Producto> productos;
		try {
			
			Producto producto = new  Producto();
			
			producto.setNombre("ndo");
			producto.setPrecio(9.5);
			List<String> ingr = new ArrayList<String>();
			ingr.add("asf");
			ingr.add("asf");
			ingr.add("asf");
			producto.setIngredientes(ingr);
			producto.setVegano(true);
			producto.setIdRestaurante(2);
			producto.setTipo(TipoProducto.POSTRE);
					
			
			db.connect();
			db.insertarProducto(producto);
			db.disconnect();
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
	}

}
