package com.yuriytkach.jitc.solid.readers;

import com.yuriytkach.jitc.solid.FileType;
import com.yuriytkach.jitc.solid.FileTypeReader;

public class TextFileReader implements FileTypeReader {

  @Override
  public boolean supports(final FileType fileType) {
    return FileType.TXT == fileType;
  }

  @Override
  public String readFileToString(final byte[] fileBytes) {
    return new String(fileBytes);
  }
}
