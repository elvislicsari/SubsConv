package com.subsconvertor.model;

import com.google.api.translate.Language;

public class Subtitle {

    private long id;

    private String subtitleName;

    private String subtitleContentType;

    private byte[] subtitleOriginalContent;

    private byte[] subtitleConvertedContent;

    private float framerateFrom;

    private float framerateInto;

    private String subtitleType;

    private String language;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubtitleName() {
        return subtitleName;
    }

    public void setSubtitleName(String subtitleName) {
        this.subtitleName = subtitleName;
    }

    public String getSubtitleContentType() {
        return subtitleContentType;
    }

    public void setSubtitleContentType(String subtitleContentType) {
        this.subtitleContentType = subtitleContentType;
    }

    public byte[] getSubtitleOriginalContent() {
        return subtitleOriginalContent;
    }

    public void setSubtitleOriginalContent(byte[] subtitleOriginalContent) {
        this.subtitleOriginalContent = subtitleOriginalContent;
    }

    public byte[] getSubtitleConvertedContent() {
        return subtitleConvertedContent;
    }

    public void setSubtitleConvertedContent(byte[] subtitleConvertedContent) {
        this.subtitleConvertedContent = subtitleConvertedContent;
    }

    public float getFramerateFrom() {
        return framerateFrom;
    }

    public void setFramerateFrom(float framerateFrom) {
        this.framerateFrom = framerateFrom;
    }

    public float getFramerateInto() {
        return framerateInto;
    }

    public void setFramerateInto(float framerateInto) {
        this.framerateInto = framerateInto;
    }

    public String getSubtitleType() {
        return subtitleType;
    }

    public void setSubtitleType(String subtitleType) {
        this.subtitleType = subtitleType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}