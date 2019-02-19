package com.evodat.webapp.action;

import com.evodat.model.Mealcourse;
import com.evodat.model.MealcourseType;

public class MealCourseAction extends BaseAction{

    private Mealcourse mealCourse;
    private String mealcourseType;
    private static final MealcourseType[] mealcourseTypes = MealcourseType.values();

    public String save(){
        log.info("saving...");
        mealCourse.setMealcourseType(MealcourseType.valueOf(mealcourseType));
        mealCourseManager.save(mealCourse);
        return SUCCESS;
    }

    public Mealcourse getMealCourse() {
        return mealCourse;
    }

    public void setMealCourse(Mealcourse mealCourse) {
        this.mealCourse = mealCourse;
    }

    public MealcourseType[] getMealcourseTypes() {
        return mealcourseTypes;
    }

    public String getMealcourseType() {
        return mealcourseType;
    }

    public void setMealcourseType(String mealcourseType) {
        this.mealcourseType = mealcourseType;
    }
}
