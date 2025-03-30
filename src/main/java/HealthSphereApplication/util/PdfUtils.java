package HealthSphereApplication.util;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.ByteArrayOutputStream;


public class PdfUtils {

    // Method to generate PDF with title and content
    public static byte[] generatePdf(String title, String content) throws DocumentException {
        // Create a new document
        Document document = new Document();

        // Output stream to write the PDF bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            // Create a PdfWriter instance to write the document content to the output stream
            PdfWriter.getInstance(document, outputStream);

            // Open the document to start adding content
            document.open();

            // Define title and content fonts
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            // Add the title to the document
            Paragraph titleParagraph = new Paragraph(title, titleFont);
            titleParagraph.setAlignment(Element.ALIGN_CENTER); // Center align the title
            titleParagraph.setSpacingAfter(10); // Space after title
            document.add(titleParagraph);

            // Add the content to the document
            Paragraph contentParagraph = new Paragraph(content, contentFont);
            contentParagraph.setAlignment(Element.ALIGN_JUSTIFIED); // Justify content
            document.add(contentParagraph);

        } catch (Exception e) {
            throw new DocumentException("Error while generating PDF: " + e.getMessage(), e);
        } finally {
            // Close the document
            document.close();
        }

        // Return the generated PDF as a byte array
        return outputStream.toByteArray();
    }
}
