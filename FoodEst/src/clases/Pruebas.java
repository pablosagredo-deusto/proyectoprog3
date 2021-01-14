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
		ManagerDB db = new ManagerDB();
		
		List<Producto> productosSegundos;
		try {
			db.connect();
			productosSegundos = db.getTodosProductosDeUnTipo(TipoProducto.BEBIDA);

			db.disconnect();
			
			for (Producto producto : productosSegundos) {
				System.out.println(producto.getNombre());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
