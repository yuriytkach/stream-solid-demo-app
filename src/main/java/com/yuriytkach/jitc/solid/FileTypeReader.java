package com.yuriytkach.jitc.solid;

public interface FileTypeReader {

  boolean supports(FileType fileType);
  String readFileToString(byte[] fileBytes);

}
