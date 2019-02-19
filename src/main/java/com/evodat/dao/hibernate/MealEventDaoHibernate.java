package com.evodat.dao.hibernate;

import com.evodat.dao.MealCourseDao;
import com.evodat.dao.MealEventDao;
import com.evodat.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mealEventDao")
public class MealEventDaoHibernate extends GenericDaoHibernate<MealEvent, Long>
		implements MealEventDao {
    public MealEventDaoHibernate() {
        super(MealEvent.class);
    }

    @Override
    public List<MealEvent> getAllFromDate() {
        List<MealEvent> mealEvents = getHibernateTemplate().find("from MealEvent m");
        return  mealEvents;
    }
}
