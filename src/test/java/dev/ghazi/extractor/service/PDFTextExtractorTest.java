package dev.ghazi.extractor.service;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PDFTextExtractorTest {

    TextExtractor extractor = new PDFTextExtractor();

    @Test
    void testExtractText() throws IOException {
        try (var inputStream = getClass().getClassLoader().getResourceAsStream("test.pdf")) {
            var text = extractor.extractText(inputStream);
            log.info("[{}]", text);
        }
    }
}
