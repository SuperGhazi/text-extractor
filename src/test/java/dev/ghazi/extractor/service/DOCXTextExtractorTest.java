package dev.ghazi.extractor.service;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DOCXTextExtractorTest {

    TextExtractor extractor = new DOCXTextExtractor();

    @Test
    void testExtractText() throws IOException {
        try (var inputStream = getClass().getClassLoader().getResourceAsStream("test.docx")) {
            var text = extractor.extractText(inputStream);
            log.info("[{}]", text);
        }
    }
}
