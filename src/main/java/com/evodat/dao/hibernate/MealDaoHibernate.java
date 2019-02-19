package com.evodat.dao.hibernate;

import com.evodat.dao.MealDao;
import com.evodat.model.Meal;
import org.springframework.stereotype.Repository;

@Repository("mealDao")
public class MealDaoHibernate extends GenericDaoHibernate<Meal, Long>
		implements MealDao{
    public MealDaoHibernate() {
        super(Meal.class);
    }

}
