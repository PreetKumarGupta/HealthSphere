package HealthSphereApplication.medicalrecord;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportGenerator {

    public byte[] generatePatientReport(List<MedicalRecord> records) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            // Create a document object
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Title font
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            // Content font
            Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            // Add title to the document
            Paragraph title = new Paragraph("Patient Medical Records Report\n\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add patient records to the PDF
            for (MedicalRecord record : records) {
                document.add(new Paragraph("Diagnosis: " + record.getDiagnosis(), contentFont));
                document.add(new Paragraph("Treatment: " + record.getTreatment(), contentFont));
                document.add(new Paragraph("Date: " + record.getRecordDate(), contentFont));
                document.add(new Paragraph("------------------------------\n"));
            }

            // Close the document
            document.close();
        } catch (Exception e) {
            throw new RuntimeException("Error generating report", e);
        }

        // Return the generated PDF as byte array
        return outputStream.toByteArray();
    }
}
