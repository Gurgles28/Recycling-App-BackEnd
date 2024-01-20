package com.example.RegisterLogin.DTO;

import jakarta.persistence.Column;

public class UserDTO {

    private Long userID;
    private String userFirstName;
    private String userLastName;
    private String email;
    private String password;
    private String address;
    private String role;
    private int points;
    private int plasticContrib;
    private int aluminumContrib;
    private int metalContrib;
    private int glassContrib;
    private int paperCardboardContrib;
    private int electronicContrib;

    public UserDTO() {
    }

    public UserDTO(Long userID, String userFirstName, String userLastName, String email, String password, String address, String role, int points, int plasticContrib, int aluminumContrib, int metalContrib, int glassContrib, int paperCardboardContrib, int electronicContrib) {
        this.userID = userID;
        this.address = address;
        this.email = email;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
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
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
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
        return "UserDTO{" +
                "userID=" + userID +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
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
