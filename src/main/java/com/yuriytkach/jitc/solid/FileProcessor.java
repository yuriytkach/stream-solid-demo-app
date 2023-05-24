package com.yuriytkach.jitc.solid;

import java.util.Set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileProcessor {

  private final FileFinder fileFinder;

  private final FileDownloader fileDownloader;

  private final FileTypeResolver fileTypeResolver;

  private final Set<FileTypeReader> fileTypeReaders;

  private final TextAnalyzer textAnalyzer;

  public long processLatestTextFile(final String wordToCount) {
    final String latestFileKey = fileFinder.findLatestFile(fileTypeResolver::filterFile);

    final byte[] fileBytes = fileDownloader.downloadFileContent(latestFileKey);

    final FileType fileType = fileTypeResolver.resolveType(latestFileKey);

    final FileTypeReader reader = fileTypeReaders.stream()
      .filter(processor -> processor.supports(fileType))
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("Unsupported file type: " + fileType));

    final String fileContents = reader.readFileToString(fileBytes);
    return textAnalyzer.countWordOccurrences(fileContents, wordToCount);
  }

}
