package com.evodat.service;

import com.evodat.model.MealEventRoom;
import com.evodat.model.Room;

public interface MealEventRoomManager extends GenericManager<MealEventRoom, Long> {


    MealEventRoom getCurrentMealEventRoom(Room room);
}
