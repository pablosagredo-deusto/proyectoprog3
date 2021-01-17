package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Factura {
	double total = 0.0;
	String texto = "";
	List<Producto> productos;
	ArrayList<String> palabras;

	public void crearFacturaPdf(Pedido p) throws Exception {
		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Text
			String texto2 = "-----------------";
			String prueba = "";
			String texto4 = "";

			ArrayList<String> palabras = new ArrayList<String>();
			List<Producto> productos;
			productos = p.getProductos();
			double total = 0.0;
			int i = 50;

			contentStream.beginText();
			contentStream.setFont(PDType1Font.COURIER_BOLD, 22);
			contentStream.newLineAtOffset(200, 500);
			// linea4

			// linea2
			contentStream.showText(texto2);
			contentStream.newLineAtOffset(0, 30);
			// linea1

			for (Producto producto : productos) {
				total = +producto.getPrecio();
				prueba = producto.toStringPrecio();
				contentStream.showText(prueba);
				contentStream.newLineAtOffset(0, i);
				i = +30;

				palabras.add(prueba);
			}

			texto4 = String.valueOf(total);

			contentStream.showText(texto);
			contentStream.newLineAtOffset(0, 30);
			// linea1
			contentStream.showText(texto2);
			
			System.out.println("id"+p.getId());
			String id="";
			id=String.valueOf(p.getId());
			contentStream.newLineAtOffset(150, 300);
			contentStream.showText(id);
			
			contentStream.endText();

			// imagen prueba
			PDImageXObject pdImage = PDImageXObject.createFromFile("src/imagenes/resumen.png", document);
			contentStream.drawImage(pdImage, 20, 700);
			
			

			// imagen prueba
			PDImageXObject pdImage2 = PDImageXObject.createFromFile("src/imagenes/logo.png", document);
			contentStream.drawImage(pdImage2, 150, 100);

			contentStream.close();

			document.save("factura_foodest.pdf");

			System.out.println("pdf creado");
		}
	}

	

	public static void main(String[] args) throws Exception {
		Factura f = new Factura();
		Restaurante restaurante = null;
		f.crearFacturaPdf(null);

	}

}