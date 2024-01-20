package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "centers")
public class RecyclingCenter {

    @Id
    @Column(name = "id", length = 245)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "county", length = 255)
    private String county;
    @Column(name = "city", length = 255)
    private String city;
    @Column(name = "centerAddress", length = 255)
    private String centerAddress;
    @Column(name = "materials", length = 255)
    private String materials;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "hours", length = 255)
    private String hours;

    public RecyclingCenter() {
    }

    public RecyclingCenter(Long id, String county, String city, String centerAddress, String materials, String name, String hours) {
        this.id = id;
        this.county = county;
        this.city = city;
        this.centerAddress = centerAddress;
        this.materials = materials;
        this.name = name;
        this.hours = hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "RecyclingCenter{" +
                "id=" + id +
                ", county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", centerAddress='" + centerAddress + '\'' +
                ", materials='" + materials + '\'' +
                ", name='" + name + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}


