package com.evodat.webapp.model;

public class MealcourseDO {

    private Long id;
    private String title;
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MealcourseDO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", count=" + count +
                '}';
    }
}
