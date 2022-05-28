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
    private Integer serviceid;
    private String userName;
    private Double point;
    private String Comment;
    private Date Date;

    public Rating() {
    }

    public Rating(Integer serviceid, String userName, Double point, String comment, java.util.Date date) {
        this.serviceid = serviceid;
        this.userName = userName;
        this.point = point;
        Comment = comment;
        Date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
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
                "serviceid=" + serviceid +
                ", userName='" + userName + '\'' +
                ", point=" + point +
                ", Comment='" + Comment + '\'' +
                ", Date=" + Date +
                '}';
    }
}
