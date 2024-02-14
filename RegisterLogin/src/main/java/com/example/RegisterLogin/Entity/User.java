package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", length = 245)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "email", length = 255)
    @Email(message = "Invalid email address")
    private String email;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "first_name", length = 255)
    private String first_name;
    @Column(name = "last_name", length = 255)
    private String last_name;
    @Column(name = "role", length = 255)
    private String role="client";
    @Column(name = "points", length = 255)
    private BigDecimal points= BigDecimal.valueOf(0);
    @Column(name = "plastic_contrib", length = 255)
    private BigDecimal plasticContrib = BigDecimal.valueOf(0);
    @Column(name = "aluminum_contrib", length = 255)
    private BigDecimal aluminumContrib = BigDecimal.valueOf(0);
    @Column(name = "metal_contrib", length = 255)
    private BigDecimal metalContrib = BigDecimal.valueOf(0);
    @Column(name = "glass_contrib", length = 255)
    private BigDecimal glassContrib = BigDecimal.valueOf(0);
    @Column(name = "PaperCardboard_contrib", length = 255)
    private BigDecimal paperCardboardContrib = BigDecimal.valueOf(0);
    @Column(name = "electronic_contrib", length = 255)
    private BigDecimal electronicContrib = BigDecimal.valueOf(0);

    public User() {
    }

    public User(Long id, String address, String email, String first_name, String last_name,String password, String role, BigDecimal points, BigDecimal plasticContrib, BigDecimal aluminumContrib, BigDecimal metalContrib, BigDecimal glassContrib, BigDecimal paperCardboardContrib, BigDecimal electronicContrib) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.role = role;
        this.points = points;
        this.plasticContrib = plasticContrib;
        this.aluminumContrib = aluminumContrib;
        this.metalContrib = metalContrib;
        this.glassContrib = glassContrib;
        this.paperCardboardContrib = paperCardboardContrib;
        this.electronicContrib = electronicContrib;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }

    public BigDecimal getPlasticContrib() {
        return plasticContrib;
    }

    public void setPlasticContrib(BigDecimal plasticContrib) {
        this.plasticContrib = plasticContrib;
    }

    public BigDecimal getAluminumContrib() {
        return aluminumContrib;
    }

    public void setAluminumContrib(BigDecimal aluminumContrib) {
        this.aluminumContrib = aluminumContrib;
    }

    public BigDecimal getMetalContrib() {
        return metalContrib;
    }

    public void setMetalContrib(BigDecimal metalContrib) {
        this.metalContrib = metalContrib;
    }

    public BigDecimal getGlassContrib() {
        return glassContrib;
    }

    public void setGlassContrib(BigDecimal glassContrib) {
        this.glassContrib = glassContrib;
    }

    public BigDecimal getPaperCardboardContrib() {
        return paperCardboardContrib;
    }

    public void setPaperCardboardContrib(BigDecimal paperCardboardContrib) {
        this.paperCardboardContrib = paperCardboardContrib;
    }

    public BigDecimal getElectronicContrib() {
        return electronicContrib;
    }

    public void setElectronicContrib(BigDecimal electronicContrib) {
        this.electronicContrib = electronicContrib;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + id +
                ", userFirstName='" + first_name + '\'' +
                ", userLastName='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", points='" + points + '\'' +
                ", plasticContrib='" + plasticContrib + '\'' +
                ", aluminumContrib='" + aluminumContrib + '\'' +
                ", metalContrib='" + metalContrib + '\'' +
                ", glassContrib='" + glassContrib + '\'' +
                ", paperCardboardContrib='" + paperCardboardContrib + '\'' +
                ", electronicContrib='" + electronicContrib + '\'' +
                '}';
    }
}