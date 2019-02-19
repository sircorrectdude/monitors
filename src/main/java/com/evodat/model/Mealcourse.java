package com.evodat.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.SearchableId;

import javax.persistence.*;

@Entity
@Table(name = "mealcourse")
public class Mealcourse {

    private Long id;
    private String title;

    @Column(name = "order_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MealcourseType mealcourseType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append("title", title).toString();

    }

    public MealcourseType getMealcourseType() {
        return mealcourseType;
    }

    public void setMealcourseType(MealcourseType mealcourseType) {
        this.mealcourseType = mealcourseType;
    }
}
