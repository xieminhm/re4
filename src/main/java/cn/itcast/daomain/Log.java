package cn.itcast.daomain;

import java.util.Date;

public class Log {
    private int id;
    private Date visitTimeStr;
    private String ip;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitTimeStr() {
        return visitTimeStr;
    }

    public void setVisitTimeStr(Date visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", visitTimeStr=" + visitTimeStr +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
