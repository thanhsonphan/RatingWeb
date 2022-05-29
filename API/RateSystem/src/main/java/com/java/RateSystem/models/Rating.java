package com.java.RateSystem.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private UUID id;
    private Integer serviceid;
    private String username;
    private Double point;
    private String Comment;
    private Date date;

    public Rating() {
    }

    public Rating(Integer serviceid, String username, Double point, String comment, java.util.Date date) {
        this.serviceid = serviceid;
        this.username = username;
        this.point = point;
        Comment = comment;
        this.date = date;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "serviceid=" + serviceid +
                ", userName='" + username + '\'' +
                ", point=" + point +
                ", Comment='" + Comment + '\'' +
                ", Date=" + date +
                '}';
    }
}
