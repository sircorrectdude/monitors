package com.evodat.service.impl;

import com.evodat.dao.MealEventRoomDao;
import com.evodat.model.MealEventRoom;
import com.evodat.model.Room;
import com.evodat.service.MealEventRoomManager;
import com.evodat.service.MealEventRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mealEventRoomManager")
@WebService(serviceName = "MealEventRoomService", endpointInterface = "com.evodat.service.MealEventRoomService")
public class MealEventRoomManagerImpl extends GenericManagerImpl<MealEventRoom, Long> implements
        MealEventRoomManager, MealEventRoomService {


    private MealEventRoomDao mealEventRoomDao;

    @Autowired
    public void setMealEventDao(MealEventRoomDao mealEventRoomDao) {
        this.dao = mealEventRoomDao;
        this.mealEventRoomDao = mealEventRoomDao;
    }


    @Override
    public MealEventRoom getCurrentMealEventRoom(Room room) {
        return mealEventRoomDao.getCurrentMealEventRoom(room);
    }
}
