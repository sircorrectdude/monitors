package com.evodat.webapp.action;
import com.evodat.model.*;
import com.opensymphony.xwork2.Preparable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    public class MealAction extends BaseAction implements Preparable {

    private List<Meal> meals;
    private Meal meal;
    private String id;

    private List<Mealcourse> maincourses;
    private List<Mealcourse> starters;
    private List<Mealcourse> desserts;

    private Mealcourse starter;
    private Mealcourse dessert;
    private List<Mealcourse> maincoursesToAdd;
//    private String name;

    public void prepare() throws Exception {
        maincourses = mealCourseManager.getAllMainCourses();
        log.info(maincourses.size());
        desserts = mealCourseManager.getAllDesserts();
        starters = mealCourseManager.getAllStarters();

    }

    public String cancel() {
        if (!"list".equals(from)) {
            return "mainMenu";
        }
        return "cancel";
    }

    public String list() {
        meals = mealManager.getAll();
        return SUCCESS;
    }

    public String execute() {
        return SUCCESS;
    }

    public String edit() throws IOException {

        if (id != null) {
            meal = mealManager.get(Long.valueOf(id));
        } else {
            meal = new Meal();
        }

        return SUCCESS;
    }

    public String delete(){
        mealManager.remove(Long.valueOf(id));
        return SUCCESS;
    }

    public String save() throws IOException {
        log.info("saving meal...");
//        Meal meal = new Meal();
        Set<Mealcourse> mealcourses = new HashSet<Mealcourse>();
        mealcourses.add(starter);
        mealcourses.addAll(maincoursesToAdd);
        mealcourses.add(dessert);
        meal.setMealcourses(mealcourses);
//        meal.setName(name);
//        MealEvent event = new MealEvent();
//        event.setDate(new Date());
//        meal.getEvents().add(event);
        mealManager.save(meal);

        return SUCCESS;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Mealcourse> getMaincourses() {
        return maincourses;
    }

    public void setMaincourses(List<Mealcourse> maincourses) {
        this.maincourses = maincourses;
    }

    public List<Mealcourse> getStarters() {
        return starters;
    }

    public void setStarters(List<Mealcourse> starters) {
        this.starters = starters;
    }

    public List<Mealcourse> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Mealcourse> desserts) {
        this.desserts = desserts;
    }

    public Mealcourse getStarter() {
        return starter;
    }

    public void setStarter(Mealcourse starter) {
        this.starter = starter;
    }

    public Mealcourse getDessert() {
        return dessert;
    }

    public void setDessert(Mealcourse dessert) {
        this.dessert = dessert;
    }

    public List<Mealcourse> getMaincoursesToAdd() {
        return maincoursesToAdd;
    }

    public void setMaincoursesToAdd(List<Mealcourse> maincoursesToAdd) {
        this.maincoursesToAdd = maincoursesToAdd;
    }
}
