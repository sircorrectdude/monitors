package com.evodat.service;

import com.evodat.model.Mealcourse;

import java.util.List;

public interface MealCourseManager extends GenericManager<Mealcourse, Long> {

    List<Mealcourse> getAllMainCourses();
    List<Mealcourse> getAllDesserts();
    List<Mealcourse> getAllStarters();

}
