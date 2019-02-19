package com.evodat.service.impl;

import com.evodat.dao.MealEventDao;
import com.evodat.model.MealEvent;
import com.evodat.service.MealEventManager;
import com.evodat.service.MealEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

@Service("mealEventManager")
@WebService(serviceName = "MealEventService", endpointInterface = "com.evodat.service.MealEventService")
public class MealEventManagerImpl extends GenericManagerImpl<MealEvent, Long> implements
        MealEventManager, MealEventService {

    private MealEventDao mealEventDao;

    @Autowired
    public void setMealEventDao(MealEventDao mealEventDao) {
        this.dao = mealEventDao;
        this.mealEventDao = mealEventDao;
    }

    @Override
    public List<MealEvent> getAllFromDate() {
        return mealEventDao.getAllFromDate();
    }
}
