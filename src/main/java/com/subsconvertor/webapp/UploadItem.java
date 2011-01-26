package com.subsconvertor.webapp;


import org.gmr.web.multipart.GMultipartFile;

/**
 */
public class UploadItem {

    private int framerateFrom;
    private int framerateInto;
    private GMultipartFile subtitle;

    public int getFramerateFrom() {
        return framerateFrom;
    }

    public void setFramerateFrom(int framerateFrom) {
        this.framerateFrom = framerateFrom;
    }

    public GMultipartFile getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(GMultipartFile subtitle) {
        this.subtitle = subtitle;
    }

    public int getFramerateInto() {
        return framerateInto;
    }

    public void setFramerateInto(int framerateInto) {
        this.framerateInto = framerateInto;
    }
}
