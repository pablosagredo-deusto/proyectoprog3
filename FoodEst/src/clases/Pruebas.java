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

public class Pruebas {
	public static void main(String[] args) {
		
			
		try {
				Class.forName("org.sqlite.JBDC");
				
		} catch ( ClassNotFoundException e) {
				System.out.println("No se ha podido cargar el driver de la base de datos");
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/C:\\Users\\guill\\git\\proyectoprog3\\FoodEst\\lib\\FoodEstDB" );
		
			
			Statement stmt = conn.createStatement(); // Creamos un statement donde va a ir la instruccion, a partir de la conexion
			
			//Ejecutamos la instruccion sobre el stmt anterior y guardamos lo que devuelva en este objeto (resultset)
			ResultSet result = stmt.executeQuery("SELECT * FROM RESTAURANTE"); 
			
			//para recorrer las filas de el ResultSet (El objeto donde se ha guardado el resultado)
			while(result.next()) { //mientras haya una fila siguiente
				String nombre = result.getString("NOMBRE_RESTAURANTE");
				
				
				System.out.println("Nombre: " + nombre );
			}
			
		} catch (SQLException e2) {
			System.out.println("Ha habido un error -->" + e2.getMessage());
		
		}
		System.out.println("Programa finalizado");
		
		
	
		
		
		/*
		try {
			ManagerDB db = new ManagerDB();
			db.connect();
			List<Restaurante> rs = db.getTodosRestaurantes();
			for (Restaurante restaurante : rs) {
				System.out.println(restaurante.getNombre());
			}
		} catch (ExceptionDB e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
	}

}
