package com.subsconvertor.dao;

import com.google.appengine.api.datastore.Key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Subtitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key id;

    private String subtitleName;

    private String subtitleType;

    private byte[] subtitleOriginalContent;

    private byte[] subtitleConvertedContent;

    private int framerateFrom;

    private int framerateinto;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
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

    public int getFramerateinto() {
        return framerateinto;
    }

    public void setFramerateinto(int framerateinto) {
        this.framerateinto = framerateinto;
    }
}