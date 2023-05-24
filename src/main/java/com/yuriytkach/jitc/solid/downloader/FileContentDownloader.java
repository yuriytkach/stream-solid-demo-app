package com.yuriytkach.jitc.solid.downloader;

import com.yuriytkach.jitc.solid.SupportedExtension;

public interface FileContentDownloader {
    String downloadFileContent(final String filePath);

    SupportedExtension getSupportedExtension();
}
