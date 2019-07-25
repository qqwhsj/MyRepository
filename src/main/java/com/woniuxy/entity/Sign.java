package com.woniuxy.entity;

public class Sign {
    private String sid;

    private String sname;

    private String signin;

    private String signout;

    private String signip;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSignin() {
        return signin;
    }

    public void setSignin(String signin) {
        this.signin = signin == null ? null : signin.trim();
    }

    public String getSignout() {
        return signout;
    }

    public void setSignout(String signout) {
        this.signout = signout == null ? null : signout.trim();
    }

    @Override
    public String toString() {
        return "Sign{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", signin='" + signin + '\'' +
                ", signout='" + signout + '\'' +
                ", signip='" + signip + '\'' +
                '}';
    }

    public String getSignip() {
        return signip;
    }

    public void setSignip(String signip) {
        this.signip = signip == null ? null : signip.trim();
    }
}