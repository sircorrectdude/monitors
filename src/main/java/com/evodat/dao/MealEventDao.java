package com.evodat.dao;

import com.evodat.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MealEventDao extends GenericDao<MealEvent, Long> {

    @Transactional
    List<MealEvent> getAllFromDate();

    MealEvent getCurrentMealEvent();
}
