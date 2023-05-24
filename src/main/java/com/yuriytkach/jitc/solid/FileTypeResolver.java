package com.yuriytkach.jitc.solid;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

public class FileTypeResolver {

  public boolean filterFile(final Path path) {
    return resolveTypeOptional(path.toString()).isPresent();
  }

  public FileType resolveType(final String fileKey) {
    return resolveTypeOptional(fileKey)
      .orElseThrow(() -> new IllegalArgumentException("Unknown file type: " + fileKey));
  }

  private Optional<FileType> resolveTypeOptional(final String fileKey) {
    return Arrays.stream(FileType.values())
      .filter(type -> fileKey.endsWith(type.getExtension()))
      .findFirst();
  }
}
