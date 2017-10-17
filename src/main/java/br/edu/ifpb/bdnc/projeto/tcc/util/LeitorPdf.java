/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.projeto.tcc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Edilva
 */
public class LeitorPdf {

   private final BodyContentHandler handler;
    private final Metadata metadata;
    private final FileInputStream inputStream;
    private final ParseContext parseContext;

    public LeitorPdf(String path) throws FileNotFoundException{
        handler = new BodyContentHandler(-1);
        metadata = new Metadata();
        inputStream = new FileInputStream(new File(path));
        parseContext = new ParseContext();
    }
    
    public String getText() throws IOException, SAXException, TikaException, org.xml.sax.SAXException{
        PDFParser pdfParser = new PDFParser();
        pdfParser.parse(inputStream, handler, metadata, parseContext);
        return handler.toString();
    }
      
}
