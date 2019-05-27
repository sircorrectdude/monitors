package com.evodat.webapp.util;

public class TimeDO implements Comparable< TimeDO >{

    private Long time;
    private String color;
    private String css;
    private String content;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(TimeDO o) {
        return this.getTime().compareTo(o.getTime());
    }
}
