package org.song.ctfilevip.urianalyze.bean;

public class LinkInfo {
    private String vip_dx_url;
    private String vip_lt_url;
    private String vip_yd_url;
    private String doubleclick_url;
    private String file_name;
    private String file_size;

    public String getVip_dx_url() {
        return vip_dx_url;
    }

    public void setVip_dx_url(String vip_dx_url) {
        this.vip_dx_url = vip_dx_url;
    }

    public String getVip_lt_url() {
        return vip_lt_url;
    }

    public void setVip_lt_url(String vip_lt_url) {
        this.vip_lt_url = vip_lt_url;
    }

    public String getVip_yd_url() {
        return vip_yd_url;
    }

    public void setVip_yd_url(String vip_yd_url) {
        this.vip_yd_url = vip_yd_url;
    }

    public String getDoubleclick_url() {
        return doubleclick_url;
    }

    public void setDoubleclick_url(String doubleclick_url) {
        this.doubleclick_url = doubleclick_url;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    @Override
    public String toString() {
        return "LinkInfo{" +
                "vip_dx_url='" + vip_dx_url + '\'' +
                ", vip_lt_url='" + vip_lt_url + '\'' +
                ", vip_yd_url='" + vip_yd_url + '\'' +
                ", doubleclick_url='" + doubleclick_url + '\'' +
                ", file_name='" + file_name + '\'' +
                ", file_size='" + file_size + '\'' +
                '}';
    }
}
