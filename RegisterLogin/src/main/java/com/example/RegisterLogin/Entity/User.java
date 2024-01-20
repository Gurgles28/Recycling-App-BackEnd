package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

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
    private String email;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "first_name", length = 255)
    private String first_name;
    @Column(name = "last_name", length = 255)
    private String last_name;
    @Column(name = "role", length = 255)
    private String role;
    @Column(name = "points", length = 255)
    private int points;
    @Column(name = "plastic_contrib", length = 255)
    private int plasticContrib = 0;
    @Column(name = "aluminum_contrib", length = 255)
    private int aluminumContrib = 0;
    @Column(name = "metal_contrib", length = 255)
    private int metalContrib = 0;
    @Column(name = "glass_contrib", length = 255)
    private int glassContrib = 0;
    @Column(name = "PaperCardboard_contrib", length = 255)
    private int paperCardboardContrib = 0;
    @Column(name = "electronic_contrib", length = 255)
    private int electronicContrib = 0;

    public User() {
    }

    public User(Long id, String address, String email, String first_name, String last_name,String password, String role, int points, int plasticContrib, int aluminumContrib, int metalContrib, int glassContrib, int paperCardboardContrib, int electronicContrib) {
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

    public Long getUserID() {
        return id;
    }

    public void setUserID(Long userID) {
        this.id = userID;
    }

    public String getUserFirstName() {
        return first_name;
    }

    public void setUserFirstName(String userFirstName) {
        this.first_name = userFirstName;
    }

    public String getUserLastName() {
        return last_name;
    }

    public void setUserLastName(String userLastName) {
        this.last_name = userLastName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPlasticContrib() {
        return plasticContrib;
    }

    public void setPlasticContrib(int plasticContrib) {
        this.plasticContrib = plasticContrib;
    }

    public int getAluminumContrib() {
        return aluminumContrib;
    }

    public void setAluminumContrib(int aluminumContrib) {
        this.aluminumContrib = aluminumContrib;
    }

    public int getMetalContrib() {
        return metalContrib;
    }

    public void setMetalContrib(int metalContrib) {
        this.metalContrib = metalContrib;
    }

    public int getGlassContrib() {
        return glassContrib;
    }

    public void setGlassContrib(int glassContrib) {
        this.glassContrib = glassContrib;
    }

    public int getPaperCardboardContrib() {
        return paperCardboardContrib;
    }

    public void setPaperCardboardContrib(int paperCardboardContrib) {
        this.paperCardboardContrib = paperCardboardContrib;
    }

    public int getElectronicContrib() {
        return electronicContrib;
    }

    public void setElectronicContrib(int electronicContrib) {
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

                '}';
    }
}
