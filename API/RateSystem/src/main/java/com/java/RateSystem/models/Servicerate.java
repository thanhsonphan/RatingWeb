package com.java.RateSystem.models;

import javax.persistence.*;

@Entity
@Table(name = "Services")
public class Servicerate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer ServiceId;
    private String ServiceName;
    private String Image;
    private String Description;
    private Integer PointAvg;

    public Servicerate() {
    }

    public Servicerate(String serviceName, String image, String description, Integer pointAvg) {
        ServiceName = serviceName;
        Image = image;
        Description = description;
        PointAvg = pointAvg;
    }

    public Integer getPointAvg() {
        return PointAvg;
    }

    public void setPointAvg(Integer pointAvg) {
        PointAvg = pointAvg;
    }

    public Integer getServiceId() {
        return ServiceId;
    }

    public void setServiceId(Integer serviceId) {
        ServiceId = serviceId;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Servicerate{" +
                "ServiceName='" + ServiceName + '\'' +
                ", Image='" + Image + '\'' +
                ", Description='" + Description + '\'' +
                ", PointAvg=" + PointAvg +
                '}';
    }
}
