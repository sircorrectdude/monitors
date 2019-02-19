package com.evodat.webapp.action;

import com.evodat.model.Meal;
import com.evodat.model.MealEvent;
import com.evodat.model.Mealcourse;
import com.evodat.webapp.model.MealCalendarEvent;
import com.opensymphony.xwork2.Preparable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MealEventAction extends BaseAction implements Preparable {

    private List<MealCalendarEvent> events;
    private String id;
    private String mealId;
    private String date;

    @Override
    public void prepare() throws Exception {
        List<MealEvent> mealEvents = mealEventManager.getAllFromDate();
        log.info(mealEvents.size());
        events = transform(mealEvents);
    }

    private List<MealCalendarEvent> transform(List<MealEvent> mealEvents) {
        List<MealCalendarEvent> events = new ArrayList<MealCalendarEvent>();
        for (MealEvent mealEvent : mealEvents) {
            MealCalendarEvent event = new MealCalendarEvent();
            event.setId(String.valueOf(mealEvent.getId()));
            event.setTitle(getMealTitle(mealEvent));
            event.setStart(new SimpleDateFormat("yyyy-MM-dd").format(mealEvent.getDate()));

            StringBuffer buf = new StringBuffer();
            buf.append(mealEvent.getMeal().getName());
            buf.append(":");
            for(Mealcourse mealcourse: mealEvent.getMeal().getMealcourses()){
                buf.append(mealcourse.getTitle()+"\n");
            }

            event.setDescription(buf.toString());
            events.add(event);
        }
        return events;

    }

    public String getMealTitle(MealEvent mealEvent) {
        String title = mealEvent.getMeal().getName() + ": ";
        for (Mealcourse course : mealEvent.getMeal().getMealcourses()) {
            title += course.getTitle() + ", ";
        }
        return title;
    }

    public String deleteEvent() {
        mealEventManager.remove(Long.valueOf(id));
        return SUCCESS;
    }

    public String saveEvent() {
        MealEvent event = new MealEvent();
        Date dateParsed = null;
        try {
            dateParsed = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        event.setDate(dateParsed);
        Meal meal = mealManager.get(Long.valueOf(mealId));
        event.setMeal(meal);
        mealEventManager.save(event);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public List<MealCalendarEvent> getEvents() {
        return events;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
