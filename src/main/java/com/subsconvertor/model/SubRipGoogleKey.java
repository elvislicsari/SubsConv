package com.subsconvertor.model;

/**
 *
 */
public class SubRipGoogleKey implements Comparable<SubRipGoogleKey> {
    private int lineCounter;
    private int packageNumber;
    private String timeLine;

    public int getLineCounter() {
        return lineCounter;
    }

    public void setLineCounter(int lineCounter) {
        this.lineCounter = lineCounter;
    }

    public int getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(int packageNumber) {
        this.packageNumber = packageNumber;
    }

    public String getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(String timeLine) {
        this.timeLine = timeLine;
    }

    @Override
    public String toString() {
        return "SubRipGoogleKey{" +
                "lineCounter=" + lineCounter +
                ", packageNumber=" + packageNumber +
                ", timeLine='" + timeLine + '\'' +
                '}';
    }

    public int compareTo(SubRipGoogleKey o) {
        int res = lineCounter - o.lineCounter;
        if (res == 0) {
            res = packageNumber - o.packageNumber;
        }
        return res;
    }
}
