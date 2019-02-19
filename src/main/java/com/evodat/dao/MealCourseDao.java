package com.evodat.dao;

import com.evodat.model.Mealcourse;

import java.util.List;

public interface MealCourseDao extends GenericDao<Mealcourse, Long> {

    List<Mealcourse> getAllMainCourses();

    List<Mealcourse> getAllDesserts();

    List<Mealcourse> getAllStarters();
}
