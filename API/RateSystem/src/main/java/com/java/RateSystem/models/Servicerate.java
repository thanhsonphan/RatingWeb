package com.java.RateSystem.models;

import javax.persistence.*;

@Entity
@Table(name = "Services")
public class Servicerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String serviceimg;
    private String servicedesc;
    private Integer avgscore;

    public Servicerate() {
    }

    public Servicerate(String name, String serviceimg, String servicedesc, Integer avgscore) {
        this.name = name;
        this.serviceimg = serviceimg;
        this.servicedesc = servicedesc;
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

    public String getServiceimg() {
        return serviceimg;
    }

    public void setServiceimg(String serviceimg) {
        this.serviceimg = serviceimg;
    }

    public String getServicedesc() {
        return servicedesc;
    }

    public void setServicedesc(String servicedesc) {
        this.servicedesc = servicedesc;
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
                ", serviceimg='" + serviceimg + '\'' +
                ", servicedesc='" + servicedesc + '\'' +
                ", avgscore=" + avgscore +
                '}';
    }
}
