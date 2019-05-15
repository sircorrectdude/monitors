package com.evodat.dao;

import com.evodat.model.MealEventRoom;
import com.evodat.model.Room;

public interface MealEventRoomDao extends GenericDao<MealEventRoom, Long> {

    MealEventRoom getCurrentMealEventRoom(Room room);
}
