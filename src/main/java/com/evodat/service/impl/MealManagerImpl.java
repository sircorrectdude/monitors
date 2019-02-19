package com.evodat.service.impl;

import com.evodat.dao.MealDao;
import com.evodat.model.Meal;
import com.evodat.service.MealManager;
import com.evodat.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mealManager")
@WebService(serviceName = "MealService", endpointInterface = "com.evodat.service.MealService")
public class MealManagerImpl extends GenericManagerImpl<Meal, Long> implements
        MealManager, MealService {

    private MealDao mealDao;

    @Autowired
    public void setMealDao(MealDao mealDao) {
        this.dao = mealDao;
        this.mealDao = mealDao;
    }

}
