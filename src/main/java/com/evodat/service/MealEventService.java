package com.evodat.service;

import com.evodat.model.MealEvent;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface MealEventService {
    List<MealEvent> getAllFromDate();
}
