package com.yuriytkach.jitc.solid;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FileProcessorAppIT {

  private final FileProcessorApp tested = new FileProcessorApp();

  @Test
  void shouldCountWordsInTextFile() {
    final long result = tested.count("src/test/resources/count-in-text-file", "Слава");
    assertThat(result).isEqualTo(2);
  }

  @Test
  void shouldCountWordsInPdfFile() {
    final long result = tested.count("src/test/resources/count-in-pdf-file", "Слава");
    assertThat(result).isEqualTo(2);
  }

  @Test
  void shouldCountWordsInLatestFile() {
    final long result = tested.count("src/test/resources/count-in-latest", "Слава");
    assertThat(result).isEqualTo(3);
  }

}
