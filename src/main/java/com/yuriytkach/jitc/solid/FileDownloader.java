package com.yuriytkach.jitc.solid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDownloader {

  public byte[] downloadFileContent(final String filePath) {
    try {
      return Files.readAllBytes(Path.of(filePath));
    } catch (final IOException ex) {
      throw new IllegalArgumentException("Cannot read file " + filePath + ": " + ex.getMessage(), ex);
    }
  }
}
