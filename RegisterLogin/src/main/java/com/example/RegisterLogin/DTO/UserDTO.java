package com.example.RegisterLogin.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class UserDTO {

    private Long userID;
    @NotBlank(message = "First name cannot be blank")
    private String userFirstName;
    @NotBlank(message = "Last name cannot be blank")
    private String userLastName;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    private String role="client";
    private BigDecimal points= BigDecimal.valueOf(0);
    private BigDecimal plasticContrib= BigDecimal.valueOf(0);
    private BigDecimal aluminumContrib=BigDecimal.valueOf(0);
    private BigDecimal metalContrib=BigDecimal.valueOf(0);
    private BigDecimal glassContrib=BigDecimal.valueOf(0);
    private BigDecimal paperCardboardContrib=BigDecimal.valueOf(0);
    private BigDecimal electronicContrib=BigDecimal.valueOf(0);

    public UserDTO() {
    }

    public UserDTO(Long userID, String userFirstName, String userLastName, String email, String password, String address, String role, BigDecimal points, BigDecimal plasticContrib, BigDecimal aluminumContrib, BigDecimal metalContrib, BigDecimal glassContrib, BigDecimal paperCardboardContrib, BigDecimal electronicContrib) {
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