package com.dpb.base.model;

public class MenuBean {
    private Integer id;

    private String menuname;

    private String menulink;

    private Integer pid;

    private String securyname;

    private String memo;

    private Long isdel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenulink() {
        return menulink;
    }

    public void setMenulink(String menulink) {
        this.menulink = menulink == null ? null : menulink.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSecuryname() {
        return securyname;
    }

    public void setSecuryname(String securyname) {
        this.securyname = securyname == null ? null : securyname.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getIsdel() {
        return isdel;
    }

    public void setIsdel(Long isdel) {
        this.isdel = isdel;
    }
}