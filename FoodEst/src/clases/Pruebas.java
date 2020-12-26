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
import ventanas.VentanaRestaurante;

public class Pruebas {
	public static void main(String[] args) {
		
		ManagerDB db = new ManagerDB();
		try {
			db.connect();
			
			
			Usuario us2 = new Usuario();
			us2.setNombre("prueba3");
			us2.setNombreUsuario("prueba3");
			us2.setContraseña("prueba3");
			us2.setApellido("prueba3");
			
			
			db.insertarUsuario(us2);
			
			db.disconnect();
		} catch (ExceptionDB e1) {
			e1.printStackTrace();
		}
		
	
		
	}

}
