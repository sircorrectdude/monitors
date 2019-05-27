package com.evodat.webapp.action;

import com.evodat.model.*;
import com.evodat.webapp.model.MealcourseDO;
import com.opensymphony.xwork2.Preparable;

import java.util.HashMap;
import java.util.Map;

public class AddMealCourseAction extends BaseAction implements Preparable {

    private MealEvent mealEvent;
    private Mealcourse mealcourse;
    private String mealCourseId;
    private String roomId;
    private Room room;
    private MealEventRoom mealEventRoom;

    private MealcourseDO starter;
    private MealcourseDO dessert;
    private Map<String, MealcourseDO> maincourses;

    public void prepare() throws Exception {
        mealEvent = mealEventManager.getCurrentMealEvent();
        maincourses = new HashMap<String, MealcourseDO>();
    }

    @Override
    public String execute() {
        Room room = new Room();
        room.setId(roomId);
        mealEventRoom = mealEventRoomManager.getCurrentMealEventRoom(room);
        mealcourse = mealCourseManager.get(Long.valueOf(mealCourseId));

        Portion portion = new Portion();
        portion.setMealcourse(mealcourse);
        portion.setMealEventRoom(mealEventRoom);

        if(mealEventRoom.getPortions().size() < mealEventRoom.getEventinfo().getNumberPersons()) {
            mealEventRoom.getPortions().add(portion);
            mealEventRoom = mealEventRoomManager.save(mealEventRoom);
        }
        createPortions();
        return SUCCESS;
    }

    public String removePortion(){
        Room room = new Room();
        room.setId(roomId);
        mealEventRoom = mealEventRoomManager.getCurrentMealEventRoom(room);

        for(Portion portion: mealEventRoom.getPortions()){
            if(String.valueOf(portion.getMealcourse().getId()).equals(mealCourseId)){
//                System.out.println(portion.getMealcourse().getId() + "== " +mealCourseId);
//                System.out.println("portion.getId(): "+portion.getId());
                portion.getMealEventRoom().getPortions().remove(portion);
                mealEventRoomManager.save(mealEventRoom);
                portionManager.remove(portion.getId());
                break;
            }
        }
        createPortions();
        return SUCCESS;
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
                maincourses.put("ID_"+mealcourse.getId(), maincourse);

            }
        }

        for(Portion portion: mealEventRoom.getPortions()) {
            if(portion.getMealcourse().getMealcourseType() == MealcourseType.STARTER){
                starter = new MealcourseDO();
                starter.setTitle(portion.getMealcourse().getTitle());
            }
            if(portion.getMealcourse().getMealcourseType() == MealcourseType.DESSERT){
                dessert = new MealcourseDO();
                dessert.setTitle(portion.getMealcourse().getTitle());
            }
            if(portion.getMealcourse().getMealcourseType() == MealcourseType.MAINCOURSE){
                MealcourseDO maincourse = maincourses.get("ID_"+portion.getMealcourse().getId());
                maincourse.setCount(maincourse.getCount() + 1);

            }

        }
    }

    public Mealcourse getMealcourse() {
        return mealcourse;
    }

    public void setMealcourse(Mealcourse mealcourse) {
        this.mealcourse = mealcourse;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public MealEventRoom getMealEventRoom() {
        return mealEventRoom;
    }

    public void setMealEventRoom(MealEventRoom mealEventRoom) {
        this.mealEventRoom = mealEventRoom;
    }

    public String getMealCourseId() {
        return mealCourseId;
    }

    public void setMealCourseId(String mealCourseId) {
        this.mealCourseId = mealCourseId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public MealEvent getMealEvent() {
        return mealEvent;
    }

    public void setMealEvent(MealEvent mealEvent) {
        this.mealEvent = mealEvent;
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

    public Map<String, MealcourseDO> getMaincourses() {
        return maincourses;
    }

    public void setMaincourses(Map<String, MealcourseDO> maincourses) {
        this.maincourses = maincourses;
    }
}
