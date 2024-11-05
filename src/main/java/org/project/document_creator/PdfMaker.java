package org.project.document_creator;

import org.apache.commons.text.WordUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.project.vehicle_support.Car;

import java.util.Calendar;

import static org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName.*;


public class PdfMaker {

    public PdfMaker() {
    }

    public void createSaleOffer (Car car, String cena) throws Exception {
        Calendar c = Calendar.getInstance();
        String filename = "CarsTradingProject/src/PDF_files/saleOffer_" + car.getManufacturer()
                + "_" + car.getModel()
                + "_" + car.getPlateNumber()
                + "_" + c.get(Calendar.HOUR_OF_DAY)
                + "_" + c.get(Calendar.MINUTE)
                + "_" + c.get(Calendar.MILLISECOND)
                + ".pdf";

        PDDocument document = new PDDocument();
        PDPage page1 = new PDPage();
        document.addPage(page1);

        PDPageContentStream p = new PDPageContentStream(document, page1);

        writeTitle(p,250,750,25,"Sprzedam:");
        writeCarParameters(p, 40, 700,  "Marka :  ", car.getManufacturer());
        writeCarParameters(p, 40, 660, "Model :  " , car.getModel());
        writeCarParameters(p, 40, 620, "Rodzaj nadwozia: ", car.getBodyType());
        writeCarParameters(p, 40, 580, "Numer VIN: ", car.getVinNumber());
        writeCarParameters(p, 40, 540, "Rok produkcji: ", String.valueOf(car.getProductionYear()));
        writeCarDescription(p,40,450,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum", 40);
        writeLineOfText(p, 420, 150, "cena: "+ cena + " EU");
        writeLineOfText(p, 410, 110, "tel. 790-987-233");
        p.close();
        document.save(filename);
        document.close();
    }
    public static void writeTitle(PDPageContentStream content,
                                       int tx, int ty, int fontSize,
                                       String text) {


        try{
            content.beginText();
            content.newLineAtOffset(tx, ty); // 595 x 842\
            content.setFont(new PDType1Font(COURIER), fontSize);
            content.showText(text);
            content.endText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeLineOfText(PDPageContentStream content,
                                       int tx, int ty,
                                       String text) {


        try{
            content.beginText();
            content.newLineAtOffset(tx, ty); // 595 x 842\
            content.setFont(new PDType1Font(COURIER), 20);
            content.showText(text);
            content.endText();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeCarParameters(PDPageContentStream content,
                                          int tx, int ty,
                                          String text,
                                          String text2) {


       try{
           content.beginText();
           content.newLineAtOffset(tx, ty); // 595 x 842\
           content.setFont(new PDType1Font(COURIER),16);
           content.showText(text);
           content.setFont(new PDType1Font(COURIER),20);
           content.showText(text2);
           content.endText();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    public static void writeCarDescription(PDPageContentStream content,
                                           int tx, int ty,
                                           String text,
                                           int wrapLenght) {
        String[] lines = WordUtils.wrap(text,wrapLenght).split("\\r?\\n");

        int posY = 0;

        for (int i=0; i < lines.length; i++) {
            String l = lines[i];
            posY = ty - i * 15;
            writeLineOfText(content,tx,posY,l);
        }

    }
}
