package com.mybot;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PPTExtractor {

    public void extractTextFromPPT(String pptFilePath, String textFilePath) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(pptFilePath);
             XMLSlideShow ppt = new XMLSlideShow(inputStream);
             FileWriter writer = new FileWriter(textFilePath)) {

            ppt.getSlides().forEach(slide -> {
                List<XSLFShape> shapes = slide.getShapes();
                for (XSLFShape shape : shapes) {
                    if (shape instanceof XSLFTextShape) {
                        XSLFTextShape textShape = (XSLFTextShape) shape;
                        try {
                            writer.write(textShape.getText() + System.lineSeparator());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
