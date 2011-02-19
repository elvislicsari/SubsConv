package com.subsconvertor.model;

public class Subtitle {

    private long id;

    private String subtitleName;

    private String subtitleType;

    private byte[] subtitleOriginalContent;

    private byte[] subtitleConvertedContent;

    private int framerateFrom;

    private int framerateInto;

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

    public String getSubtitleType() {
        return subtitleType;
    }

    public void setSubtitleType(String subtitleType) {
        this.subtitleType = subtitleType;
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

    public int getFramerateFrom() {
        return framerateFrom;
    }

    public void setFramerateFrom(int framerateFrom) {
        this.framerateFrom = framerateFrom;
    }

    public int getFramerateInto() {
        return framerateInto;
    }

    public void setFramerateInto(int framerateInto) {
        this.framerateInto = framerateInto;
    }
}