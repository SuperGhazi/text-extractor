package dev.ghazi.extractor.service;

import java.io.IOException;
import java.io.InputStream;

public interface TextExtractor {

    String extractText(InputStream inputStream) throws IOException;
}
