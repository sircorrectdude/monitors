package com.evodat.model;

import org.compass.annotations.SearchableId;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "mealeventroom")
public class MealEventRoom {

    private Long id;

    private Date time;

    private Set<Portion> portions;

    private JCalendar eventinfo;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @OneToMany(mappedBy="mealEventRoom", fetch=FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    public Set<Portion> getPortions() {
        return portions;
    }

    public void setPortions(Set<Portion> portions) {
        this.portions = portions;
    }

    @ManyToOne
    public JCalendar getEventinfo() {
        return eventinfo;
    }

    public void setEventinfo(JCalendar eventinfo) {
        this.eventinfo = eventinfo;
    }
}
