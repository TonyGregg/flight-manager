package com.genil.learning.flightmanager.entity;

import javax.persistence.*;

/**
 * Created by Antony Genil Gregory on 12/11/2018 5:51 AM
 * For project : flight-manager
 **/
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
