package dev.ghazi.extractor.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DOCXTextExtractor implements TextExtractor {

    @Override
    public String extractText(InputStream inputStream) throws IOException {
        try (var document = new XWPFDocument(inputStream);
            var extractor = new XWPFWordExtractor(document)) {
            return extractor.getText();
        }
    }
}
