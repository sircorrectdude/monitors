package com.evodat.model;

import org.compass.annotations.SearchableId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mealevent")
public class MealEvent {

    private Long id;

    private Date date;

    private Meal meal;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
//    @JoinColumn(name="meal_id")
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
