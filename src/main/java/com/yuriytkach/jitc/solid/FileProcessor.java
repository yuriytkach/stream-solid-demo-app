package com.yuriytkach.jitc.solid;

import com.yuriytkach.jitc.solid.downloader.FileContentDownloader;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileProcessor {
  private final FileFinder fileFinder;
  private final TextFileAnalyzer textFileAnalyzer;
  private final Map<SupportedExtension, FileContentDownloader> contentDownloaderByExtension;

  public FileProcessor(FileFinder fileFinder, TextFileAnalyzer textFileAnalyzer, List<FileContentDownloader> contentDownloaders) {
    this.fileFinder = fileFinder;
    this.textFileAnalyzer = textFileAnalyzer;
    this.contentDownloaderByExtension = contentDownloaders.stream()
        .collect(Collectors.toMap(FileContentDownloader::getSupportedExtension, Function.identity()));
  }

  public long processLatestTextFile(final String folderPath, final String wordToCount, final SupportedExtension extension) {
    final String latestFileKey = fileFinder.findLatestTextFile(Path.of(folderPath), extension);
    final FileContentDownloader fileContentDownloader = contentDownloaderByExtension.get(extension);
    final String latestFileContent = fileContentDownloader.downloadFileContent(latestFileKey);
    return textFileAnalyzer.countWordOccurrences(latestFileContent, wordToCount);
  }

}
