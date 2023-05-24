package com.yuriytkach.jitc.solid;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileType {
  TXT ("txt"),
  PDF ("pdf"),

  WORD ("docx");

  private final String extension;
}
