/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alangonzalez
 */
public class Reportes {

    Herramientas herraminetas;

    public Reportes() {
        herraminetas = new Herramientas();
    }

    
    /**
     * alan gonzalez crea y guarda un reporte simple devuelve el nombre random del archivo
     * @param rutaAlmacen 
     */
    public String  reporteSimple(String rutaAlmacen, String param1) {
        
        

        String randomString =herraminetas.randomString(5);
        Document documento = new Document(PageSize.A4, 0, 0, 0, 0);
        FileOutputStream ficheroPdf = null;
        try {
            // System.out.println(rutaAlmacen + "/"+randomString+".pdf");
            ficheroPdf = new FileOutputStream(rutaAlmacen + "/"+randomString+".pdf");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
        } catch (DocumentException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
            
        documento.open();
        try {
           // documento.add(new Paragraph("Esto es el primer párrafo, normalito"));
            
            
            documento.add(new Paragraph(param1, FontFactory.getFont("arial", 22, Font.NORMAL, BaseColor.BLACK)));
            documento.add(new Paragraph(param1, FontFactory.getFont("arial", 22, Font.NORMAL, BaseColor.BLUE)));
            documento.add(new Paragraph(param1, FontFactory.getFont("arial", 22, Font.NORMAL, BaseColor.GRAY)));
//            documento.add(new Paragraph("Este es el segundo y tiene una fuente rara", FontFactory.getFont("arial", 22, Font.ITALIC, BaseColor.CYAN)));
            
//documento.add(new Paragraph("Este es el segundo y tiene una fuente rara", FontFactory.getFont("arial", 22, Font.ITALIC, BaseColor.CYAN)));
        } catch (DocumentException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.close();
        return  rutaAlmacen + "/"+randomString+".pdf";
    }
    


}
