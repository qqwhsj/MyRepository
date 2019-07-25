package com.woniuxy.entity;

public class OffTime {
    private String offBegin;
    private String noonBegin;
    private String noonOver;
    private String offOver;

    @Override
    public String toString() {
        return "OffTime{" +
                "offBegin='" + offBegin + '\'' +
                ", noonBegin='" + noonBegin + '\'' +
                ", noonOver='" + noonOver + '\'' +
                ", offOver='" + offOver + '\'' +
                '}';
    }

    public String getOffBegin() {
        return offBegin;
    }

    public void setOffBegin(String offBegin) {
        this.offBegin = offBegin;
    }

    public String getNoonBegin() {
        return noonBegin;
    }

    public void setNoonBegin(String noonBegin) {
        this.noonBegin = noonBegin;
    }

    public String getNoonOver() {
        return noonOver;
    }

    public void setNoonOver(String noonOver) {
        this.noonOver = noonOver;
    }

    public String getOffOver() {
        return offOver;
    }

    public void setOffOver(String offOver) {
        this.offOver = offOver;
    }
}
