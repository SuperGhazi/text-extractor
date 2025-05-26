package dev.ghazi.extractor.service;

import java.io.IOException;
import java.io.InputStream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class UnsupportedExtensionTextExtractor implements TextExtractor {

    private final String contentType;

    @Override
    public String extractText(InputStream inputStream) throws IOException {
        log.warn("[{}] is not supported for text extraction.", contentType);
        return "";
    }
}
