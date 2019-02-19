package com.evodat.service;

import com.evodat.model.*;
import com.evodat.service.GenericManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MealEventManager extends GenericManager<MealEvent, Long> {

    List<MealEvent> getAllFromDate();
}
