package com.yuriytkach.jitc.solid.readers;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.yuriytkach.jitc.solid.FileType;
import com.yuriytkach.jitc.solid.FileTypeReader;

public class PdfFileReader implements FileTypeReader {

  @Override
  public boolean supports(final FileType fileType) {
    return FileType.PDF == fileType;
  }

  @Override
  public String readFileToString(final byte[] fileBytes) {
    try (PDDocument doc = PDDocument.load(fileBytes)) {
      final PDFTextStripper pdfTextStripper = new PDFTextStripper();
      return pdfTextStripper.getText(doc);
    } catch (final IOException ex) {
      throw new IllegalArgumentException("Cannot process PDF file: " + ex.getMessage(), ex);
    }
  }

}
