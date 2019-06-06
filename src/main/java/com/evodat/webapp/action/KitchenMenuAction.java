package com.evodat.webapp.action;

import com.evodat.model.*;
import com.evodat.webapp.util.TimeDO;

import java.util.*;


public class KitchenMenuAction extends BaseAction{

private List<TimeDO> data;

    public String execute() {

        List<JCalendar> nextCalendars = jCalendarManager.getNextCalendars(1);
        Calendar nowCalendar = Calendar.getInstance();
        List<MealEventRoom> mealEventRooms = new ArrayList<MealEventRoom>();

        for(JCalendar jCalendar: nextCalendars){
            Calendar eventCalendar = Calendar.getInstance();
            eventCalendar.setTime(jCalendar.getStartTime());
            // show on current day
            if (eventCalendar.get(Calendar.YEAR) == nowCalendar.get(Calendar.YEAR)
                    && eventCalendar.get(Calendar.MONTH) == nowCalendar.get(Calendar.MONTH)
                    && eventCalendar.get(Calendar.DAY_OF_MONTH) == nowCalendar.get(Calendar.DAY_OF_MONTH)){

                // show only if not yet finished
                if(!new java.util.Date().after(jCalendar.getEndTime())) {
                    mealEventRooms.add(addMealEventRoom(jCalendar));
                }
            }
        }


        data= new ArrayList<TimeDO>();

        for(MealEventRoom mealEventRoom : mealEventRooms){
            TimeDO timeDO = new TimeDO();
            timeDO.setTime(mealEventRoom.getTime().getTime());
            timeDO.setCss("sucess");
            String content = "";
            //Name der Veranastaltung
            content = content + "<div class='timeline_eventtitle'>"+mealEventRoom.getEventinfo().getSubject()+"</div>";
            //Anzahl Personen
            content = content + "<div class='timeline_event_number_persons'>("+mealEventRoom.getEventinfo().getNumberPersons()+" Teilnehmer)</div>";

            Set<Portion> portions = mealEventRoom.getPortions();

            Map<String, Integer> maincourses= new HashMap<String, Integer>();

            if(null!=mealEventRoom && null!=mealEventRoom.getPortions()) {

                for (Portion portion : mealEventRoom.getPortions()) {
                    if (portion.getMealcourse().getMealcourseType() == MealcourseType.MAINCOURSE) {
                        if( null ==maincourses.get(portion.getMealcourse().getTitle())){
                            maincourses.put(portion.getMealcourse().getTitle(),1);
                        }else{
                            maincourses.put(portion.getMealcourse().getTitle(),maincourses.get(portion.getMealcourse().getTitle())+1);
                        }
                    }
                }
            }


            if(!maincourses.isEmpty()) {
                Iterator<Map.Entry<String, Integer>> itr = maincourses.entrySet().iterator();
                while(itr.hasNext())
                {
                    Map.Entry<String, Integer> entry = itr.next();
                    content = content + ("<div class='timeline_maincourse_count'>" + entry.getValue() +"</div>"+
                            "<div class='timeline_maincourse_name'>" +entry.getKey()+"</div>");
                }
            }else{
                content = content + "<div class='timeline_maincourse_no_orders'>KEINE BESTELLUNGEN</div>";
            }
            timeDO.setContent(content);
            data.add(timeDO);
            Collections.sort(data);
//            Collections.reverse(data);
        }



        return SUCCESS;

    }

    private MealEventRoom addMealEventRoom(JCalendar jCalendar) {
        MealEventRoom mealEventRoom = mealEventRoomManager.getCurrentMealEventRoom(jCalendar.getColor());
        if(null == mealEventRoom){
            mealEventRoom = new MealEventRoom();
            mealEventRoom.setEventinfo(jCalendar);

            Calendar now = Calendar.getInstance();
            now.set(Calendar.HOUR, 0);
            now.set(Calendar.MINUTE,0);
            now.set(Calendar.AM_PM, Calendar.PM);
            mealEventRoom.setTime(now.getTime());
//            mealEventRoom = mealEventRoomManager.save(mealEventRoom);
        }
        return mealEventRoom;
    }


    public List<TimeDO> getData() {
        return data;
    }

    public void setData(List<TimeDO> data) {
        this.data = data;
    }
}
