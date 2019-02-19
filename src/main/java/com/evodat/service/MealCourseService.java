package com.evodat.service;

import com.evodat.model.Mealcourse;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface MealCourseService {

    List<Mealcourse> getAllMainCourses();
    List<Mealcourse> getAllDesserts();
    List<Mealcourse> getAllStarters();

}
