package com.subsconvertor.model;

/**
 *
 */
public class MultiDVDGoogleKey implements Comparable<MultiDVDGoogleKey> {

    private int lineNumber;
    private String framerates;

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getFramerates() {
        return framerates;
    }

    public void setFramerates(String framerates) {
        this.framerates = framerates;
    }

    public int compareTo(MultiDVDGoogleKey o) {
        int res = lineNumber - o.lineNumber;
        if (res == 0) {
            res = framerates.compareTo(o.framerates);
        }
        return res;
    }

    @Override
    public String toString() {
        return "MultiDVDGoogleKey{" +
                "lineNumber=" + lineNumber +
                ", framerates='" + framerates + '\'' +
                '}';
    }
}
