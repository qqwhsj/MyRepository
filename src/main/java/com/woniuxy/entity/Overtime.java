package com.woniuxy.entity;

public class Overtime {
    private String oid;

    private String oname;

    private String submittime;

    private String otbegin;

    private String otover;

    private String duration;

    private String discription;

    private Integer isratify;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    public String getSubmittime() {
        return submittime;
    }

    public void setSubmittime(String submittime) {
        this.submittime = submittime == null ? null : submittime.trim();
    }

    public String getOtbegin() {
        return otbegin;
    }

    public void setOtbegin(String otbegin) {
        this.otbegin = otbegin == null ? null : otbegin.trim();
    }

    public String getOtover() {
        return otover;
    }

    public void setOtover(String otover) {
        this.otover = otover == null ? null : otover.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? null : discription.trim();
    }

    public Integer getIsratify() {
        return isratify;
    }

    public void setIsratify(Integer isratify) {
        this.isratify = isratify;
    }

    @Override
    public String toString() {
        return "Overtime{" +
                "oid='" + oid + '\'' +
                ", oname='" + oname + '\'' +
                ", submittime='" + submittime + '\'' +
                ", otbegin='" + otbegin + '\'' +
                ", otover='" + otover + '\'' +
                ", duration='" + duration + '\'' +
                ", discription='" + discription + '\'' +
                ", isratify=" + isratify +
                '}';
    }
}