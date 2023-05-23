package com.yuriytkach.jitc.solid;

import java.nio.file.Path;

public class FileProcessorApp {

  public static void main(final String[] args) {
    if (args.length < 2) {
      System.out.println("Usage: file-processor <folder> <word to search>");
      System.exit(1);
    }
    final String folder = args[0];
    final String word = args[1];

    new FileProcessorApp().count(folder, word);
  }

  private void count(final String folder, final String word) {
    final FileFinder fileFinder = new FileFinder(Path.of(folder));

    final FileProcessor fileProcessor = new FileProcessor(
      fileFinder,
      new FileDownloader(),
      new TextFileAnalyzer()
    );

    final long count = fileProcessor.processLatestTextFile(word);
    System.out.printf("Occurrences of word '%s': %d%n", word, count);
  }

}
