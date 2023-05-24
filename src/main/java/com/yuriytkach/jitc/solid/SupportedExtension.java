package com.yuriytkach.jitc.solid;

public enum SupportedExtension {
    TXT(".txt"),
    PDF(".pdf"),
    DOC(".doc");

    private final String extension;

    SupportedExtension(final String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
