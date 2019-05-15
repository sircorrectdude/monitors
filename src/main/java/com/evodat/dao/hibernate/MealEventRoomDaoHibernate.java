package com.evodat.dao.hibernate;

import com.evodat.dao.MealEventRoomDao;
import com.evodat.model.MealEventRoom;
import com.evodat.model.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mealEventRoomDao")
public class MealEventRoomDaoHibernate extends GenericDaoHibernate<MealEventRoom, Long>
		implements MealEventRoomDao {
    public MealEventRoomDaoHibernate() {
        super(MealEventRoom.class);
    }

    @Override
    public MealEventRoom getCurrentMealEventRoom(Room room) {
        List<MealEventRoom> mealEventRooms = getHibernateTemplate().find("from MealEventRoom m where m.eventinfo.color = ? and m.eventinfo.startTime <= current_time and m.eventinfo.endTime >= current_time", room);
        if(null == mealEventRooms || mealEventRooms.isEmpty()){
            return null;
        }
        return mealEventRooms.get(0);
    }
}
