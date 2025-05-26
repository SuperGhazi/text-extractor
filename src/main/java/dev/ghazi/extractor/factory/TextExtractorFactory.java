package dev.ghazi.extractor.factory;

import dev.ghazi.extractor.service.DOCXTextExtractor;
import dev.ghazi.extractor.service.PDFTextExtractor;
import dev.ghazi.extractor.service.TextExtractor;
import dev.ghazi.extractor.service.UnsupportedExtensionTextExtractor;

public class TextExtractorFactory {

    public static TextExtractor getExtractor(String contentType) {
        return switch (contentType) {
            case "application/pdf" -> new PDFTextExtractor();
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document" -> new DOCXTextExtractor();
            default -> new UnsupportedExtensionTextExtractor(contentType);
        };
    }
}
