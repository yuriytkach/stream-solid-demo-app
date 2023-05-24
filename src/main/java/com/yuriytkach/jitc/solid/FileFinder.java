package com.yuriytkach.jitc.solid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileFinder {

  private final Path folderPath;

  public String findLatestFile(final Function<Path, Boolean> fileFilter) {
    try (Stream<Path> paths = Files.walk(folderPath)) {
      return paths
        .filter(Files::isRegularFile)
        .filter(fileFilter::apply)
        .max(Comparator.comparing(path -> path.toFile().lastModified()))
        .map(Path::toString)
        .orElseThrow(() -> new RuntimeException("No text files found in " + folderPath));
    } catch (final IOException ex) {
      throw new IllegalStateException(
        "Error while searching for text files in " + folderPath + ":" + ex.getMessage(),
        ex
      );
    }
  }
}
