package clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GestorProperties {
	// Propiedades
	private static Properties propiedades;

	public void GestorProperties() throws FileNotFoundException, IOException {
		propiedades = new Properties();
		propiedades.load(new FileReader("config.properties"));

	}

	public static String leerPropiedad(String clave,Properties p) throws FileNotFoundException, IOException {
		String resultado = "";
		resultado = p.getProperty(clave);

		return resultado;
	}

	
	
	
	
	
	public Map<String, String> leerTodasLasPropiedades(Properties p) throws FileNotFoundException, IOException {

		if (p == null) {
			new GestorProperties();
		}

		Map<String, String> listadoPropiedades = new HashMap<String, String>();

		Enumeration<Object> claves = p.keys();

		while (claves.hasMoreElements()) {
			Object clave = claves.nextElement();
			listadoPropiedades.put(clave.toString(), p.get(clave).toString());
		}

		return listadoPropiedades;
	}

}
