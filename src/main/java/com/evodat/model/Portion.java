package com.evodat.model;
import org.compass.annotations.SearchableId;
import javax.persistence.*;


@Entity
@Table(name = "portion")
public class Portion {

    private Long id;

    private Mealcourse mealcourse;

    private MealEventRoom mealEventRoom;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Mealcourse getMealcourse() {
        return mealcourse;
    }

    public void setMealcourse(Mealcourse mealcourse) {
        this.mealcourse = mealcourse;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="mealeventroom_id")
    public MealEventRoom getMealEventRoom() {
        return mealEventRoom;
    }

    public void setMealEventRoom(MealEventRoom mealEventRoom) {
        this.mealEventRoom = mealEventRoom;
    }

    @Override
    public String toString() {
        return "Portion{" +
                "id=" + id +
                ", mealcourse=" + mealcourse +
                ", mealEventRoom=" + mealEventRoom +
                '}';
    }
}
