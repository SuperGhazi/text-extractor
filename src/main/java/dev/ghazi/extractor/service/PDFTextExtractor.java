package dev.ghazi.extractor.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PDFTextExtractor implements TextExtractor {

    @Override
    public String extractText(InputStream inputStream) throws IOException {
        try (var document = Loader.loadPDF(inputStream.readAllBytes())) {
            var extractor = new PDFTextStripper();
            return extractor.getText(document);
        }
    }
}
