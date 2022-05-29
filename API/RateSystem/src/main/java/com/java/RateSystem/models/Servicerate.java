package com.java.RateSystem.models;

import javax.persistence.*;

@Entity
@Table(name = "Services")
public class Servicerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String image;
    private String description;
    private Integer avgscore;

    public Servicerate() {
    }

    public Servicerate(String name, String image, String description, Integer avgscore) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.avgscore = avgscore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String serviceimg) {
        this.image = serviceimg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String servicedesc) {
        this.description = servicedesc;
    }

    public Integer getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Integer avgscore) {
        this.avgscore = avgscore;
    }

    @Override
    public String toString() {
        return "Servicerate{" +
                "name='" + name + '\'' +
                ", serviceimg='" + image + '\'' +
                ", servicedesc='" + description + '\'' +
                ", avgscore=" + avgscore +
                '}';
    }
}
