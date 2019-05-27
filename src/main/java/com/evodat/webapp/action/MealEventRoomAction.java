package com.evodat.webapp.action;

import com.evodat.model.*;
import com.evodat.webapp.model.MealcourseDO;
import com.opensymphony.xwork2.Preparable;

import javax.sound.sampled.Port;
import java.text.SimpleDateFormat;
import java.util.*;

public class MealEventRoomAction extends BaseAction  implements Preparable {

    private String roomId;
    private MealEventRoom mealEventRoom;
    private MealEvent mealEvent;
    private JCalendar runningCalendar;

    private MealcourseDO starter;
    private MealcourseDO dessert;
    private Map<Long, MealcourseDO> maincourses;

    private String formattedMealEventTime;

    public void prepare() throws Exception {
        mealEvent = mealEventManager.getCurrentMealEvent();
        maincourses = new HashMap<Long, MealcourseDO>();
    }

    @Override
    public String execute() {
        if(null == mealEvent){
            addActionError("No Meal today");
            return ERROR;
        }
        Room room = new Room();
        room.setId(roomId);

        runningCalendar = jCalendarManager.getRunningCalendar(room);
        if(null == runningCalendar){
            addActionError("No Event today");
            return ERROR;
        }

        mealEventRoom = addMealEventRoom(runningCalendar);
        setFormattedMealEventTime(new SimpleDateFormat("HH:mm").format(mealEventRoom.getTime()));

        createPortions();


        Iterator<Map.Entry<Long, MealcourseDO>> itr = maincourses.entrySet().iterator();

//        while(itr.hasNext())
//        {
//            Map.Entry<Long, MealcourseDO> entry = itr.next();
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//        }

        return SUCCESS;

    }

    private MealEventRoom addMealEventRoom(JCalendar jCalendar) {
        MealEventRoom mealEventRoom = mealEventRoomManager.getCurrentMealEventRoom(jCalendar.getColor());
        if(null == mealEventRoom){
            mealEventRoom = new MealEventRoom();
            mealEventRoom.setEventinfo(runningCalendar);

            Calendar now = Calendar.getInstance();
            now.set(Calendar.HOUR, 0);
            now.set(Calendar.MINUTE,0);
            now.set(Calendar.AM_PM, Calendar.PM);
            mealEventRoom.setTime(now.getTime());
            mealEventRoom = mealEventRoomManager.save(mealEventRoom);
        }
        return mealEventRoom;
    }

    private void createPortions() {
        for(Mealcourse mealcourse: mealEvent.getMeal().getMealcourses()){
            if(mealcourse.getMealcourseType() == MealcourseType.STARTER){
                starter = new MealcourseDO();
                starter.setTitle(mealcourse.getTitle());
            }
            if(mealcourse.getMealcourseType() == MealcourseType.DESSERT){
                dessert = new MealcourseDO();
                dessert.setTitle(mealcourse.getTitle());
            }
            if(mealcourse.getMealcourseType() == MealcourseType.MAINCOURSE){
                MealcourseDO maincourse = new MealcourseDO();
                maincourse.setTitle(mealcourse.getTitle());
                maincourse.setId(mealcourse.getId());
                maincourse.setCount(0);
                maincourses.put(mealcourse.getId(), maincourse);

            }
        }
        if(null!=mealEventRoom && null!=mealEventRoom.getPortions()) {

            for (Portion portion : mealEventRoom.getPortions()) {
                if (portion.getMealcourse().getMealcourseType() == MealcourseType.STARTER) {
                    starter = new MealcourseDO();
                    starter.setTitle(portion.getMealcourse().getTitle());
                }
                if (portion.getMealcourse().getMealcourseType() == MealcourseType.DESSERT) {
                    dessert = new MealcourseDO();
                    dessert.setTitle(portion.getMealcourse().getTitle());
                }
                if (portion.getMealcourse().getMealcourseType() == MealcourseType.MAINCOURSE) {
                    MealcourseDO maincourse = maincourses.get(portion.getMealcourse().getId());
                    maincourse.setCount(maincourse.getCount() + 1);

                }

            }
        }
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public MealEventRoom getMealEventRoom() {
        return mealEventRoom;
    }

    public void setMealEventRoom(MealEventRoom mealEventRoom) {
        this.mealEventRoom = mealEventRoom;
    }

    public MealEvent getMealEvent() {
        return mealEvent;
    }

    public void setMealEvent(MealEvent mealEvent) {
        this.mealEvent = mealEvent;
    }

    public JCalendar getRunningCalendar() {
        return runningCalendar;
    }

    public void setRunningCalendar(JCalendar runningCalendar) {
        this.runningCalendar = runningCalendar;
    }

    public MealcourseDO getStarter() {
        return starter;
    }

    public void setStarter(MealcourseDO starter) {
        this.starter = starter;
    }

    public MealcourseDO getDessert() {
        return dessert;
    }

    public void setDessert(MealcourseDO dessert) {
        this.dessert = dessert;
    }

    public Map<Long, MealcourseDO> getMaincourses() {
        return maincourses;
    }

    public void setMaincourses(Map<Long, MealcourseDO> maincourses) {
        this.maincourses = maincourses;
    }

    public String getFormattedMealEventTime() {
        return formattedMealEventTime;
    }

    public void setFormattedMealEventTime(String formattedMealEventTime) {
        this.formattedMealEventTime = formattedMealEventTime;
    }
}
