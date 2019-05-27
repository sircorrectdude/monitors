package com.evodat.webapp.action;

import com.evodat.model.JCalendar;
import com.evodat.model.MealEventRoom;
import com.evodat.model.Room;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateMealEventRoomTimeAction extends BaseAction{

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    private MealEventRoom mealEventRoom;
    private String roomId;
    private String time;

    @Override
    public String execute(){
        Room room = new Room();
        room.setId(roomId);
        mealEventRoom = mealEventRoomManager.getCurrentMealEventRoom(room);

        mealEventRoom.setTime(getDateFromTime(time, mealEventRoom.getEventinfo()));
        mealEventRoom = mealEventRoomManager.save(mealEventRoom);
        setTime(simpleDateFormat.format(mealEventRoom.getTime()));
        return SUCCESS;
    }

    private Date getDateFromTime(String time, JCalendar eventinfo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(eventinfo.getStartTime());

        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendarTime = Calendar.getInstance();
        calendarTime.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, calendarTime.get(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendarTime.get(Calendar.MINUTE));
        return calendar.getTime();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public MealEventRoom getMealEventRoom() {
        return mealEventRoom;
    }

    public void setMealEventRoom(MealEventRoom mealEventRoom) {
        this.mealEventRoom = mealEventRoom;
    }
}
