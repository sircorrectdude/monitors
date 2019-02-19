package com.evodat.dao.hibernate;

import com.evodat.dao.MealCourseDao;
import com.evodat.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mealCourseDao")
public class MealCourseDaoHibernate extends GenericDaoHibernate<Mealcourse, Long>
		implements MealCourseDao {
    public MealCourseDaoHibernate() {
        super(Mealcourse.class);
    }

    @Override
    public List<Mealcourse> getAllMainCourses() {

        List<Mealcourse> courses = getHibernateTemplate().find("from Mealcourse where mealcourseType=?", MealcourseType.MAINCOURSE);
        return courses;
    }

    @Override
    public List<Mealcourse> getAllDesserts() {
        List<Mealcourse> courses = getHibernateTemplate().find("from Mealcourse where mealcourseType=?", MealcourseType.DESSERT);
        return courses;
    }

    @Override
    public List<Mealcourse> getAllStarters() {
        List<Mealcourse> courses = getHibernateTemplate().find("from Mealcourse where mealcourseType=?", MealcourseType.STARTER);
        return courses;
    }
}
