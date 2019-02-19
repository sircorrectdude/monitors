package com.evodat.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.compass.annotations.SearchableId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "meal")
public class Meal extends BaseObject implements Serializable {

    private Long id;
    private String name;
    private Set<Mealcourse> mealcourses;
//    private Set<MealEvent> events;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "meal_course",
            joinColumns = { @JoinColumn(name = "meal_id") },
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    public Set<Mealcourse> getMealcourses() {
        return mealcourses;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal)) return false;
        Meal meal = (Meal) o;
        return getId().equals(meal.getId()) &&
                getMealcourses().equals(meal.getMealcourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMealcourses());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMealcourses(Set<Mealcourse> mealcourses) {
        this.mealcourses = mealcourses;
    }

//    @OneToMany(mappedBy = "meal")
//    public Set<MealEvent> getEvents() {
//        if(null == events){
//            events = new HashSet<MealEvent>();
//        }
//        return events;
//    }


//    public void setEvents(Set<MealEvent> events) {
//        this.events = events;
//    }
}