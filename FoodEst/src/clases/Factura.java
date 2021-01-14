package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Factura {
	double total = 0.0;
	String texto="";
	List<Producto> productos;


	public void crearFacturaPdf(Pedido p) throws Exception {
		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Text
			String texto = "Resumen Pedido";
			String texto2 = "-----------------";
			String texto3 = "";
			String texto4 = "";

			List<Producto> productos;
			productos = p.getProductos();
			double total = 0.0;
			for (Producto producto : productos) {
				total = +producto.getPrecio();
				texto3 =texto3+ producto.toStringPrecio();
				System.out.println(texto3);

			}
			texto4= String.valueOf(total);
			
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_BOLD, 22);
			contentStream.newLineAtOffset(200, 500);
			// linea4
			contentStream.showText(texto4);
			contentStream.newLineAtOffset(0, 70);
			// linea3
			contentStream.showText(texto3);
			contentStream.newLineAtOffset(0, 50);
			// linea2
			contentStream.showText(texto2);
			contentStream.newLineAtOffset(0, 30);
			// linea1
			contentStream.showText(texto);
			contentStream.endText();

			// imagen prueba
			PDImageXObject pdImage = PDImageXObject.createFromFile("src/imagenes/logo.png", document);
			contentStream.drawImage(pdImage, 150, 700);

			contentStream.close();

			document.save("factura_foodest.pdf");

			System.out.println("pdf creado");
		}
	}

	public void crearFacturaTxt(Pedido ped) throws Exception {
		
		productos = ped.getProductos();
		
		for (Producto producto : productos) {
			total = +producto.getPrecio();
			texto =texto+ producto.toStringPrecio();
			System.out.println(texto);

		}
		String ruta = "C:/Users/Usuario/Desktop";
		File archivo = new File(ruta);
		System.out.println("Texto" + texto);
		
		try {		
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println("bw write");
			bw.write(texto);
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		Factura f = new Factura();
		Restaurante restaurante = null;
		f.crearFacturaPdf(null);

	}

}
