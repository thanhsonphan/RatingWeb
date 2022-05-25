package com.java.RateSystem.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private UUID id;
    private String ServiceId;
    private String UserName;
    private Double Point;
    private String Comment;
    private Date Date;

    public Rating() {
    }

    public Rating(String serviceId, String userName, Double point, String comment, java.util.Date date) {
        ServiceId = serviceId;
        UserName = userName;
        Point = point;
        Comment = comment;
        Date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String serviceId) {
        ServiceId = serviceId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Double getPoint() {
        return Point;
    }

    public void setPoint(Double point) {
        Point = point;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ServiceId='" + ServiceId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Point=" + Point +
                ", Comment='" + Comment + '\'' +
                ", Date=" + Date +
                '}';
    }
}
