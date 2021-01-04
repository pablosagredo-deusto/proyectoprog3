package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Factura {

	public void crearFacturaPdf(Pedido p) throws Exception {
		try (PDDocument document = new PDDocument()) {
			PDPage page = new PDPage(PDRectangle.A4);
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			// Text
			String texto = "Resumen Pedido";
			String texto2 = "-----------------";
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_BOLD, 22);
			contentStream.newLineAtOffset(200, 500);
			// linea1
			contentStream.showText(texto2);
			contentStream.newLineAtOffset(0, 30);
			// linea2
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
		String texto = ped.toString();
		String ruta = "src/imagenes";
		File archivo = new File(ruta);
		System.out.println("Texto" + texto);
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		Factura f = new Factura();
		f.crearFacturaPdf(null);

	}

}
