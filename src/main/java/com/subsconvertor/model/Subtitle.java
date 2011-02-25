package com.subsconvertor.model;

import com.google.appengine.api.datastore.Key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Subtitle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

    private String subtitleName;

    private String subtitleContentType;

    private transient byte[] subtitleOriginalContent;

    private transient byte[] subtitleConvertedContent;

    private float framerateFrom;

    private float framerateInto;

    private String subtitleType;

    private String language;

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