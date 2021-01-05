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
			db.connect();
			productos = db.getTodosProductos();
			
			
			for (Producto producto : productos) {
				if(producto.getId() == 2) {
					db.borrarProducto(producto);
				}
			}
			db.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		
	}

}
