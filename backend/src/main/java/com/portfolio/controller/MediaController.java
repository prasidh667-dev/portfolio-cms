package com.portfolio.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/upload")
public class MediaController {

    private static final long MAX_BYTES = 5_000_000L;

    private final Path uploadDir;

    public MediaController(@Value("${app.upload-dir}") String uploadDir) {
        this.uploadDir = Paths.get(uploadDir).toAbsolutePath().normalize();
    }

    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, String> upload(@RequestParam("file") MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is empty");
        }

        String type = file.getContentType() == null ? "" : file.getContentType();
        if (!type.startsWith("image/")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only image uploads are allowed");
        }

        if (file.getSize() > MAX_BYTES) {
            throw new ResponseStatusException(HttpStatus.PAYLOAD_TOO_LARGE, "Max file size is 5MB");
        }

        Files.createDirectories(uploadDir);

        String name = UUID.randomUUID() + "-" + safeName(file.getOriginalFilename());

        Path target = uploadDir.resolve(name).normalize();
        if (!target.startsWith(uploadDir)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid file name");
        }

        try (var in = file.getInputStream()) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }

        return Map.of("filename", name, "url", "/uploads/" + name);
    }

    private String safeName(String original) {

        String base = original == null ? "image" : Path.of(original).getFileName().toString();

        String cleaned = base.replaceAll("[^A-Za-z0-9._-]", "_");
        if (cleaned.isBlank() || cleaned.equals(".") || cleaned.equals("..")) {
            return "image";
        }

        return cleaned.length() > 100 ? cleaned.substring(cleaned.length() - 100) : cleaned;
    }
}