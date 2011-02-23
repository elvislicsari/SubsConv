package com.subsconvertor.model;

/**
 *
 */
public enum SubtitleType {
    MicroDVD(".sub"),
    SubRip(".srt");

    private String extension;

    SubtitleType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

}
