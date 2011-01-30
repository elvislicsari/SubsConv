package com.subsconvertor.dao;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Subtitle {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key id;

    @Persistent
    private String subtitleName;

    @Persistent
    private String subtitleType;

    @Persistent
    private byte[] subtitleOriginalContent;

    @Persistent
    private byte[] subtitleConvertedContent;

    @Persistent
    private int framerateFrom;

    @Persistent
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