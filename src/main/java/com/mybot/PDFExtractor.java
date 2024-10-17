package com.mybot;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PDFExtractor {

    public void extractTextFromPDF(String pdfFilePath, String textFilePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(pdfFilePath));
             FileWriter writer = new FileWriter(textFilePath)) {

            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            writer.write(text);
        }
    }
}
