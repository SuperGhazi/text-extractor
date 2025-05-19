package dev.ghazi.extractor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.ghazi.extractor.dto.ExtractedText;
import dev.ghazi.extractor.factory.TextExtractorFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RestController
@RequestMapping("/api/v1/extractor")
public class TextExtractorController {

    @PostMapping
    public ResponseEntity<ExtractedText> extractText(@RequestParam MultipartFile file) {
        log.info("extract text - file.contentType [{}] - file.size [{}] - file.name [{}] - file.originalFilename [{}]", file.getContentType(), file.getSize(), file.getName(), file.getOriginalFilename());
        var  extractor = TextExtractorFactory.getExtractor(file.getContentType());
        try {
            var text = extractor.extractText(file.getInputStream());
            return ResponseEntity.ok(new ExtractedText(text));
        } catch (IOException e) {
            log.error("Error extracting text from file", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
