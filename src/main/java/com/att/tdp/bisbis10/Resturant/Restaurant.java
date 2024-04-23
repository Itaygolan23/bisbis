package com.att.tdp.bisbis10.Resturant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "restaurant") 
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double averageRating;
    private boolean isKosher; 
    private String cuisines;

    public Restaurant(Long id, String name, double averageRating, boolean isKosher, String cuisines) {
        this.id = id;
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Restaurant(String name, double averageRating, boolean isKosher, String cuisines) {
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Restaurant(){
        this.id = 0L;
        this.name= "";
        this.averageRating = 0;
        this.isKosher = true;
        this.cuisines = "";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public boolean isKosher() {
        return isKosher;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }
}
