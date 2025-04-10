package com.example.hw.studentsurveyform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

/**
 * Survey entity class that maps to the "surveys" table in the database.
 */
@Entity // Marks this class as a JPA entity
@Table(name = "surveys") // Specifies the table name in the database
public class Survey {

    @Id // Primary key for the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the ID (auto-increment)
    private Long id;

    @Column(name = "first_name") // Maps this field to "first_name" column in the table
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_survey")
    private Date dateOfSurvey;

    @Column(name = "liked_most") // What the respondent liked most
    private String likedMost;

    @Column(name = "interested_in") // What the respondent is interested in
    private String interestedIn;

    @Column(name = "likelihood") // Likelihood of recommending or engaging
    private String likelihood;

    // ----- Getters -----

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public String getLikedMost() {
        return likedMost;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public String getLikelihood() {
        return likelihood;
    }

    // ----- Setters -----

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public void setLikedMost(String likedMost) {
        this.likedMost = likedMost;
    }

    public void setInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
    }

    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }
}
