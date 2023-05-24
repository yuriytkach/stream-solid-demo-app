package com.yuriytkach.jitc.solid.downloader.impl;

import com.yuriytkach.jitc.solid.SupportedExtension;
import com.yuriytkach.jitc.solid.downloader.FileContentDownloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PdfFileContentDownloader implements FileContentDownloader {

    @Override
    public String downloadFileContent(String filePath) {
        System.out.println("Downloading pdf file " + filePath);
        try {
            return new String(Files.readAllBytes(Path.of(filePath)));
        } catch (final IOException ex) {
            throw new IllegalArgumentException("Cannot read file " + filePath + ": " + ex.getMessage(), ex);
        }
    }

    @Override
    public SupportedExtension getSupportedExtension() {
        return SupportedExtension.PDF;
    }
}
