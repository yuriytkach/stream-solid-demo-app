package com.yuriytkach.jitc.solid;

import com.yuriytkach.jitc.solid.downloader.impl.DocFileContentDownloader;
import com.yuriytkach.jitc.solid.downloader.impl.PdfFileContentDownloader;
import com.yuriytkach.jitc.solid.downloader.impl.TxtFileContentDownloader;

import java.util.List;

public class FileProcessorApp {

  public static void main(final String[] args) {
    if (args.length < 3) {
      System.out.println("Usage: file-processor <folder> <word to search>");
      System.exit(1);
    }
    final String folder = args[0];
    final String word = args[1];
    final SupportedExtension extension = SupportedExtension.valueOf(args[2]);

    new FileProcessorApp().count(folder, word, extension);
  }

    private void count(final String folder, final String word, SupportedExtension extension) {

        final FileProcessor fileProcessor = new FileProcessor(
                new FileFinder(),
                new TextFileAnalyzer(),
                List.of(new TxtFileContentDownloader(), new PdfFileContentDownloader(), new DocFileContentDownloader())
        );

        final long count = fileProcessor.processLatestTextFile(folder, word, extension);
        System.out.printf("Occurrences of word '%s': %d%n", word, count);
    }

}
