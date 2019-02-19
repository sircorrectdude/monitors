package com.evodat.service.impl;

import com.evodat.dao.MealCourseDao;
import com.evodat.model.Mealcourse;
import com.evodat.service.MealCourseManager;
import com.evodat.service.MealCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

@Service("mealCourseManager")
@WebService(serviceName = "MealCourseService", endpointInterface = "com.evodat.service.MealCourseService")
public class MealCourseManagerImpl extends GenericManagerImpl<Mealcourse, Long> implements
        MealCourseManager, MealCourseService {

    private MealCourseDao mealCourseDao;

    @Autowired
    public void setMealCourseDao(MealCourseDao mealCourseDao) {
        this.dao = mealCourseDao;
        this.mealCourseDao = mealCourseDao;
    }

    @Override
    public List<Mealcourse> getAllMainCourses() {
        return mealCourseDao.getAllMainCourses();
    }

    @Override
    public List<Mealcourse> getAllDesserts() {
        return mealCourseDao.getAllDesserts();
    }

    @Override
    public List<Mealcourse> getAllStarters() {
        return mealCourseDao.getAllStarters();
    }
}
